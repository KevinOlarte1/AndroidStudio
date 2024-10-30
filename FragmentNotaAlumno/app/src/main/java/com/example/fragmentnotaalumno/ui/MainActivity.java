package com.example.fragmentnotaalumno.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

import com.example.fragmentnotaalumno.R;
import com.example.fragmentnotaalumno.interfaces.IclickListenner;
import com.example.fragmentnotaalumno.models.Alumno;
import com.example.fragmentnotaalumno.models.AlumnoJson;
import com.example.fragmentnotaalumno.models.Asignatura;
import com.example.fragmentnotaalumno.models.AsignaturaJson;
import com.example.fragmentnotaalumno.ui.fragments.FragmentDetail;
import com.example.fragmentnotaalumno.ui.fragments.FragmentList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements IclickListenner, FragmentList.IOnAttachListenner, FragmentDetail.IOnAttachListenner {


    private List<Alumno> alumnos;
    private final String ALUMNO_KEY = "ALUMNO";
    private final String SELECTED_ALUMNO_KEY = "SELECTED_ALUMNO";
    private FragmentManager fragmentManager;
    private FragmentDetail fragmentDetail;
    private boolean detalle;
    private int selectedContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        fragmentManager = getSupportFragmentManager();

        fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            Log.i("Carga", "carga datos");
            loadData();
        } else {
            alumnos = (List<Alumno>) savedInstanceState.getSerializable(ALUMNO_KEY);
            selectedContact = savedInstanceState.getInt(SELECTED_ALUMNO_KEY);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        detalle = findViewById(R.id.fcvDetail) != null; //!MIERDA DE VIDA.
        Log.i("detalle", String.valueOf(detalle));
        if (detalle) {
            fragmentDetail = (FragmentDetail) fragmentManager.findFragmentById(R.id.fcvDetail);
            if (!(fragmentManager.findFragmentById(R.id.fcvList) instanceof FragmentList)){
                fragmentManager.popBackStack();
            }
        }

    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(ALUMNO_KEY, (Serializable) alumnos);
        outState.putInt(SELECTED_ALUMNO_KEY, selectedContact);
    }

    public  void loadData() {
        selectedContact = -1;
        alumnos = getAlumnos();
        if (!alumnos.isEmpty()) {
            selectedContact = 0;
        }
    }


    @Override
    public void onClick(int position) {

        Alumno alumno = alumnos.get(position);
        selectedContact = position;
        Log.i("Clicked", String.valueOf(position));
        if (detalle){
            fragmentDetail.setProp(alumno);
        }
        else {
            fragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .setReorderingAllowed(true)
                    .replace(R.id.fcvList, FragmentDetail.class, null)
                    .commit();
        }

        Log.i("Sale", "aaaaaaaaaaaaaa");
    }


    @Override
    public List<Alumno> getAlumnos() {
        return AlumnoJson.getAlumnos(this);
    }

    @Override
    public Alumno getContact() {
        return alumnos.get(selectedContact);
    }
}