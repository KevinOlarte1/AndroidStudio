package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private  TextView tvSaludo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tvSaludo = findViewById(R.id.saludos);
        Toast.makeText(this, "OnCreate", Toast.LENGTH_LONG).show();
        Log.i(MainActivity.class.getName(),"aaaaaaaaaaaaaaaaaaaaa");
        Button button3 = findViewById(R.id.boton3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hola", Toast.LENGTH_LONG).show();
            }
        });


        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.saludos), (v, insets) -> {
        //    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        //    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        //    return insets;
        //});
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(MainActivity.class.getName(),"OnStart");

    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(MainActivity.class.getName(),"OnResume");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i(MainActivity.class.getName(),"OnRestart");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(MainActivity.class.getName(),"OnPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(MainActivity.class.getName(),"OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(MainActivity.class.getName(),"OnDestroy");
    }
}