package com.william.listviewpaisos;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listCountry);
        Country[] paises = CountryParse.parseCountry(this);
        for (Country pais: paises) {
            Log.i("Caso1", pais.toString());
        }
        CountryAdapter apapterAdapter = new CountryAdapter(this, paises);
        listView.setAdapter(apapterAdapter);
    }
}