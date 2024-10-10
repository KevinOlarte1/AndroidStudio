package com.william.contactkevin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ConctactAdapter extends RecyclerView.Adapter<ConctactAdapter.ConctactViewHolder> {

    private List<Contact> contacts;


    public ConctactAdapter(List<Contact>contacts){
        this.contacts = contacts;


    }

    @NonNull
    @Override
    public ConctactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ConctactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ConctactViewHolder holder, int position) {
        Contact contact = this.contacts.get(position);
        holder.bindConctact(contact);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }


    public class ConctactViewHolder extends RecyclerView.ViewHolder{

        private TextView id_txt;
        private TextView name_txt;
        private  TextView firstSurname_txt;
        private TextView secondSurname_txt;
        private TextView address_txt;

        public ConctactViewHolder(@NonNull View itemView) {

            super(itemView);
            id_txt = (TextView) itemView.findViewById(R.id.id_txt);
            name_txt = (TextView) itemView.findViewById(R.id.name_txt);
            firstSurname_txt = (TextView) itemView.findViewById(R.id.firstSurname_txt);
            secondSurname_txt = (TextView) itemView.findViewById(R.id.secondSurname_txt);
            address_txt = (TextView) itemView.findViewById(R.id.secondSurname_txt);
        }


        public  void bindConctact(Contact contacto){
            this.id_txt.setText(contacto.getId());
            this.name_txt.setText(contacto.getName());
            this.firstSurname_txt.setText(contacto.getFirstSurname());
            this.secondSurname_txt.setText(contacto.getSecondSurname());
            this.address_txt.setText(contacto.getAddress());
        }
    }

}

