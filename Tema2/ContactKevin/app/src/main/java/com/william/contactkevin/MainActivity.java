package com.william.contactkevin;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycleView);

        ArrayList<Contact> usuarios = (ArrayList<Contact>) leerJsonDesdeRaw();
        for (Contact c: usuarios
             ) {
            Log.i("a", c.toString());

        }
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new ConctactAdapter(usuarios));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));




    }

    private List<Contact> leerJsonDesdeRaw() {
        try {
            // Abrir el archivo JSON desde la carpeta raw
            InputStream inputStream = getResources().openRawResource(R.raw.contacts);

            // Leer el archivo JSON
            InputStreamReader reader = new InputStreamReader(inputStream);

            // Crear una instancia de Gson
            Gson gson = new Gson();

            // Especificar el tipo de lista de usuarios
            Type usuarioListType = new TypeToken<List<Contact>>() {}.getType();

            // Convertir el JSON a una lista de objetos Usuario
            return gson.fromJson(reader, usuarioListType);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}