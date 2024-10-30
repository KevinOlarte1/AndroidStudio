package com.example.fragmentnotaalumno.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentnotaalumno.R;
import com.example.fragmentnotaalumno.interfaces.IclickListenner;
import com.example.fragmentnotaalumno.models.objects.Alumno;
import com.example.fragmentnotaalumno.models.AlumnoAdapter;

import java.util.List;

public class FragmentList extends Fragment {

    public interface IOnAttachListenner{
        List<Alumno> getAlumnos();
    }

    private IclickListenner iclickListenner;
    private List<Alumno> alumnos;

    public FragmentList(){super(R.layout.fragment_list);}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvList = view.findViewById(R.id.rvList);
        AlumnoAdapter adapter = new AlumnoAdapter(alumnos);
        adapter.setListenner(iclickListenner);
        rvList.setAdapter(adapter);
        rvList.hasFixedSize();
        rvList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        IOnAttachListenner onAttachListenner = (IOnAttachListenner) requireActivity();
        iclickListenner = (IclickListenner) requireActivity();
        alumnos = onAttachListenner.getAlumnos();
    }
}
