package com.example.fragmentnotaalumno.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentnotaalumno.R;
import com.example.fragmentnotaalumno.interfaces.IclickListenner;
import com.example.fragmentnotaalumno.models.AlumnoAdapter;
import com.example.fragmentnotaalumno.models.NotasAlumnoAdapter;
import com.example.fragmentnotaalumno.models.objects.Alumno;
import com.example.fragmentnotaalumno.models.objects.Asignatura;
import com.example.fragmentnotaalumno.models.objects.Nota;

import java.util.List;
import java.util.Map;

public class FragmentDetail extends Fragment {

    public interface IOnAttachListennerDetail{
        Alumno getAlumno();
        Map<String, Asignatura> getAsignaturas();
    }
    private List<Nota> notas;
    private Map<String, Asignatura> asignaturas;

    public FragmentDetail(){super(R.layout.fragment_detail);}


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvDetail = view.findViewById(R.id.rvDetail);
        NotasAlumnoAdapter adapter = new NotasAlumnoAdapter(notas, asignaturas);
        rvDetail.setAdapter(adapter);
        rvDetail.hasFixedSize();
        rvDetail.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

    }


    @Override
    public void onAttach(@NonNull Context context) {
        Log.i("Entra", "asd");
        super.onAttach(context);
        IOnAttachListennerDetail onAttachListennerDetail = (IOnAttachListennerDetail) requireActivity();
        notas = onAttachListennerDetail.getAlumno().getNotas();
        asignaturas = onAttachListennerDetail.getAsignaturas();
    }
}

