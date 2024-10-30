package com.example.fragmentnotaalumno.models;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.fragmentnotaalumno.R;
import com.example.fragmentnotaalumno.interfaces.IclickListenner;

import java.util.List;

public class AlumnoAdapter extends  RecyclerView.Adapter<AlumnoAdapter.AlumnoViewHolder>{

    private final List<Alumno> alumnos;
    private IclickListenner listenner;

    public AlumnoAdapter(List<Alumno> contacts){ this.alumnos = contacts; }

    public void setListenner(IclickListenner listenner){this.listenner = listenner; }

    @NonNull
    @Override
    public AlumnoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alumno, parent, false);
        return  new AlumnoViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull AlumnoViewHolder holder, int position) {
        holder.bindPerson(alumnos.get(position),position);
    }

    @Override
    public int getItemCount() { return alumnos.size(); }


    public  class AlumnoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private final TextView tvFullName;
        private final TextView tvEmail;
        private final TextView tvNia;

        public AlumnoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFullName = itemView.findViewById(R.id.tvFullName);
            tvEmail = itemView.findViewById(R.id.tvEmail);

            tvNia = itemView.findViewById(R.id.tvNia);

            itemView.setOnClickListener(this);
        }


        private void bindPerson(Alumno alumno, int position){
            tvFullName.setText(alumno.getNombre());
            tvEmail.setText(alumno.getEmail());
            tvNia.setText(String.valueOf(alumno.getNia()));

        }

        @Override
        public void onClick(View view) {
            if(listenner != null)
                listenner.onClick(getAdapterPosition());
        }
    }

}
