package com.william.listviewpaisos.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.william.listviewpaisos.Country;
import com.william.listviewpaisos.R;

public class    CountryAdapter extends ArrayAdapter<Country> {

    private Country[] datos;
    private Context context;

    static class ViewHolder {
        ImageView imagen;
        TextView country;
        TextView capital;
        TextView poblation;
    }

    public CountryAdapter(@NonNull Context context, Country[] datos){
        super(context, R.layout.listitem_country, datos);
        this.datos = datos;
        this.context = context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View converView, @NonNull ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        /*View item =inflater.inflate(R.layout.listitem_country,null);
        TextView lblCountry = (TextView)item.findViewById(R.id.txtCountry);
        lblCountry.setText(datos[position].getCountryName());
        TextView lblCapital = (TextView)item.findViewById(R.id.txtCapital);
        lblCapital.setText(datos[position].getCapital());
        TextView lblPoblation = (TextView)item.findViewById(R.id.txtNumPoblation);
        lblPoblation.setText(datos[position].getPopulation());
        ImageView imgPais = (ImageView) item.findViewById(R.id.imgCountry);

        int imgId = context.getResources().getIdentifier("_"+ datos[position].getCountryCode().toLowerCase(),"drawable",context.getOpPackageName());
        if (imgId != 0)
            imgPais.setImageResource(imgId);
        return item; */
        View item = converView;
        ViewHolder holder;

        if (item == null){
            Log.i("Aqui", "Antes");
            item = inflater.inflate(R.layout.listitem_country,null);
            Log.i("Aqui", "despues");

            holder = new ViewHolder();
            holder.country = (TextView) item.findViewById(R.id.txtCountry);
            holder.capital = (TextView) item.findViewById(R.id.txtCapital);
            holder.poblation = (TextView) item.findViewById(R.id.txtNumPoblation);
            holder.imagen  = (ImageView) item.findViewById(R.id.imgCountry);

            item.setTag(holder);
        }
        else{
            holder = (ViewHolder) item.getTag();
        }
        holder.country.setText(datos[position].getCountryName());
        holder.capital.setText(datos[position].getCapital());
        holder.poblation.setText(datos[position].getPopulation());
        int imgId = context.getResources().getIdentifier("_"+ datos[position].getCountryCode().toLowerCase(),"drawable",context.getOpPackageName());

        if (imgId != 0)
            holder.imagen.setImageResource(imgId);

        return item;

    }

}
