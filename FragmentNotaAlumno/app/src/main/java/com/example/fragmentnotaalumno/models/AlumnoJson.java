package com.example.fragmentnotaalumno.models;

import android.content.Context;
import android.util.Log;

import com.example.fragmentnotaalumno.R;
import com.example.fragmentnotaalumno.models.objects.Alumno;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlumnoJson {

    public static List<Alumno> getAlumnos(Context context){
        ArrayList<Alumno> listResult = null;
        InputStream in = context.getResources().openRawResource(R.raw.alumnos_notas);

        try{
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            String content = new String(buffer, StandardCharsets.UTF_8);
            JSONTokener jsonToken = new JSONTokener(content);
            JSONArray jsonArray = new JSONArray(jsonToken);
            listResult = new ArrayList<>(jsonArray.length());
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                int nia = obj.getInt("nia");
                String nombre = obj.getString("nombre");
                String apellido1 = obj.getString("apellido1");
                String apellidooo2 = obj.getString("apellido2");
                String fechaNacimiento = obj.getString("fechaNacimiento");
                String email = obj.getString("email");

                JSONArray notasArray = obj.getJSONArray("notas");
                Map<String, Double> notas = new HashMap<>();
                for (int j = 0; j < notasArray.length(); j++) {
                    JSONObject objectchild = notasArray.getJSONObject(j);
                    notas.put(objectchild.getString("codAsig"), objectchild.getDouble("calificacion"));

                }

                //listResult.add(new Alumno(nia, nombre,apellido1, apellidooo2, fechaNacimiento, email,notas));


            }

        } catch (IOException | JSONException e) {
            Log.e("Error21", e.getMessage());

        }

        return listResult;
    }
}
