package com.william.listviewpaisos;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.william.listviewpaisos.adapter.CountryAdapter;

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, paises[i].getCountryName(), Toast.LENGTH_LONG).show();
            }
        });
        listView.setAdapter(apapterAdapter);
    }
}