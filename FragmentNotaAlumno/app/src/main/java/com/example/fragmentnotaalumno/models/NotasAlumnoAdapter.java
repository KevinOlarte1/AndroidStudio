package com.example.fragmentnotaalumno.models;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentnotaalumno.R;
import com.example.fragmentnotaalumno.models.objects.Alumno;
import com.example.fragmentnotaalumno.models.objects.Asignatura;
import com.example.fragmentnotaalumno.models.objects.Nota;
import com.example.fragmentnotaalumno.ui.fragments.FragmentDetail.IOnAttachListennerDetail;
import com.example.fragmentnotaalumno.ui.fragments.FragmentDetail;

import java.util.List;
import java.util.Map;

public class NotasAlumnoAdapter extends RecyclerView.Adapter<NotasAlumnoAdapter.NotasAlumnoViewHolder> {

    //private static final List<Asignatura> asignaturas;
    private List<Nota> notas;

    private Map<String, Asignatura> asignatura;



    public NotasAlumnoAdapter(List<Nota> notas, Map<String, Asignatura> asignatura){this.notas = notas; this.asignatura = asignatura;}


    public void setAsignatura(Map<String, Asignatura> asignatura) {
        this.asignatura = asignatura;
    }

    @NonNull
    @Override
    public NotasAlumnoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notaalumno, parent, false);
        return new NotasAlumnoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotasAlumnoViewHolder holder, int position) {
            Nota nota = notas.get(position);
            holder.bindNota(nota, position);
    }

    @Override
    public int getItemCount() {
        return notas.size();
    }




    public  class NotasAlumnoViewHolder extends RecyclerView.ViewHolder{

        private final TextView tvCodigo;
        private final TextView tvNombreMateria;
        private final TextView tvNota;
        public NotasAlumnoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCodigo =itemView.findViewById(R.id.tvCodigo);
            tvNombreMateria = itemView.findViewById(R.id.tvNombreMateria);
            tvNota = itemView.findViewById(R.id.tvNota);
        }

        private void bindNota(Nota nota, int position){
            tvCodigo.setText(nota.getCodAsig());
            tvNombreMateria.setText(String.valueOf(asignatura.get(nota.getCodAsig()).getNomAsig()));
            tvNota.setText(String.valueOf(nota.getCalificacion()));

        }

    }





}
