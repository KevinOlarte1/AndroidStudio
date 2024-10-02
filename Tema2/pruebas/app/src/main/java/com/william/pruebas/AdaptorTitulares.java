package com.william.pruebas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AdaptorTitulares extends ArrayAdapter<Titular> {

    private Titular[] datos;

    public AdaptorTitulares(@NonNull Context context, Titular[] datos){
        super(context,R.layout.listitem_titular,datos);
        this.datos = datos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View converView, @NonNull ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listitem_titular, null);
        TextView lblTitulo = (TextView) item.findViewById(R.id.TxtTitle);
        lblTitulo.setText(datos[position].getTitulo());
        TextView lblSubtitulo = (TextView) item.findViewById(R.id.TxtSubtitle   );
        lblSubtitulo.setText(datos[position].getSubtitulo());
        return item;

    }
}
