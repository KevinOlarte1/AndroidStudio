package com.example.fragmentnotaalumno.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragmentnotaalumno.R;
import com.example.fragmentnotaalumno.models.Alumno;

public class FragmentDetail extends Fragment {

    public interface IOnAttachListenner{
        Alumno getContact();
    }

    private TextView tvNombre;
    private IOnAttachListenner attachListenner;

    public FragmentDetail(){super(R.layout.fragment_detail);}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvNombre =view.findViewById(R.id.tvNombre);

        Alumno tmp = attachListenner.getContact();
        tvNombre.setText(tmp.getNombre());
    }

    public void  setProp(Alumno alumno){
        tvNombre.setText(alumno.getNombre());

    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        attachListenner = (IOnAttachListenner) requireActivity();
    }
}

