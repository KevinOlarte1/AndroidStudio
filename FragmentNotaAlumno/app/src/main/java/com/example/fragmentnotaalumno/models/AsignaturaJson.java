package com.example.fragmentnotaalumno.models;

import android.content.Context;

import com.example.fragmentnotaalumno.R;
import com.example.fragmentnotaalumno.models.objects.Asignatura;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class AsignaturaJson {

    public static List<Asignatura> parser(Context context){
        List<Asignatura> asignaturas = new ArrayList<>();
        InputStream in = context.getResources().openRawResource(R.raw.asignaturas);

        try{
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);

            String content =new String(buffer, StandardCharsets.UTF_8);
            JSONTokener jsonToken = new JSONTokener(content);
            JSONArray jsonArray = new JSONArray(jsonToken);

            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                String codAsig = obj.getString("codAsig");
                String nomAsig = obj.getString("nomAsig");

                asignaturas.add(new Asignatura(codAsig, nomAsig));
            }
        }catch (IOException ignored){

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return asignaturas;

    }
}
