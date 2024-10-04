package com.william.recyclerviewpaises.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.william.recyclerviewpaises.Country;
import com.william.recyclerviewpaises.R;
import com.william.recyclerviewpaises.listener.OnItemClickListener;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private Country[] countries;
    private OnItemClickListener listener;

    public  CountryAdapter(Country[] countries, OnItemClickListener listener){
        this.countries = countries;
        this.listener = listener;

    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country = countries[position];
        holder.bindCountry(country, listener);
    }

    @Override
    public int getItemCount() {
        return this.countries.length;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_country, parent, false);
        return new CountryViewHolder(itemView);
    }



    public class CountryViewHolder extends RecyclerView.ViewHolder{

        private ImageView imagen;
        private TextView country;
        private TextView capital;
        private TextView poblation;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);

            country = (TextView) itemView.findViewById(R.id.txtCountry);
            capital = (TextView) itemView.findViewById(R.id.txtCapital);
            poblation = (TextView) itemView.findViewById(R.id.txtNumPoblation);
            imagen  = (ImageView) itemView.findViewById(R.id.imgCountry);


        }

        public void bindCountry(Country country, OnItemClickListener listener){
            this.country.setText(country.getCountryName());
            this.capital.setText(country.getCapital());
            this.poblation.setText(country.getPopulation());
            this.imagen.setImageResource(country.getImageResource());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(country);
                }
            });



        }
    }





}
