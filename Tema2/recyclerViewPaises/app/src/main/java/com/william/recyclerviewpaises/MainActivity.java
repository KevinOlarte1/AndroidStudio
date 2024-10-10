package com.william.recyclerviewpaises;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.william.recyclerviewpaises.adapter.CountryAdapter;
import com.william.recyclerviewpaises.listener.OnItemClickListener;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {
    private final int NDATOS = 50;
    private Country[] datos;
    private RecyclerView rvListado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datos = CountryParse.parseCountry(this);
        Log.i("Info", datos.length + " Paises");
        for (Country country : datos) {
            Log.d("Pais", country.toString());
        }
        rvListado = findViewById(R.id.recyclerView);
            rvListado.setHasFixedSize(true);
        rvListado.setAdapter(new CountryAdapter(datos,this));
        rvListado.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }


    @Override
    public void onItemClick(Country country) {
        Toast.makeText(MainActivity.this, country.getCountryName(), Toast.LENGTH_SHORT).show();
    }
}