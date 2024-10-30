package com.example.fragmentnotaalumno.models;

import android.content.Context;

import com.example.fragmentnotaalumno.R;
import com.example.fragmentnotaalumno.models.objects.Alumno;
import com.example.fragmentnotaalumno.models.objects.Asignatura;
import com.example.fragmentnotaalumno.models.objects.Nota;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataParser {

    public static List<Alumno> parseAlumnos(Context context) {
        List<Alumno> alumnos = new ArrayList<>();
        try {
            InputStream is = context.getResources().openRawResource(R.raw.alumnos_notas);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");

            JSONArray jsonArray = new JSONArray(new JSONTokener(json));
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject alumnoJson = jsonArray.getJSONObject(i);
                int nia = alumnoJson.getInt("nia");
                String nombre = alumnoJson.getString("nombre");
                String apellido1 = alumnoJson.getString("apellido1");
                String apellido2 = alumnoJson.getString("apellido2");
                String fechaNacimiento = alumnoJson.getString("fechaNacimiento");
                String email = alumnoJson.getString("email");
                JSONArray notasArray = alumnoJson.getJSONArray("notas");

                List<Nota> notas = new ArrayList<>();
                for (int j = 0; j < notasArray.length(); j++) {
                    JSONObject notaJson = notasArray.getJSONObject(j);
                    String codAsig = notaJson.getString("codAsig");
                    float calificacion = (float) notaJson.getDouble("calificacion");
                    notas.add(new Nota(codAsig, calificacion));
                }

                alumnos.add(new Alumno(nia, nombre, apellido1, apellido2, fechaNacimiento, email, notas));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alumnos;
    }

    public static Map<String, Asignatura> parseAsignaturas(Context context) {
        Map<String, Asignatura> asignaturas = new HashMap<>();
        try {
            InputStream is = context.getResources().openRawResource(R.raw.asignaturas);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");

            JSONArray jsonArray = new JSONArray(new JSONTokener(json));
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject asignaturaJson = jsonArray.getJSONObject(i);
                String codAsig = asignaturaJson.getString("codAsig");
                String nomAsig = asignaturaJson.getString("nomAsig");

                asignaturas.put(codAsig,new Asignatura(codAsig, nomAsig));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return asignaturas;
    }
}
