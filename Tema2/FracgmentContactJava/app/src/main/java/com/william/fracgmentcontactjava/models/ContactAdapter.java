package com.william.fracgmentcontactjava.models;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.william.fracgmentcontactjava.R;
import com.william.fracgmentcontactjava.interfaces.IClickListenner;

import java.util.List;

public class ContactAdapter extends  RecyclerView.Adapter<ContactAdapter.ContactViewHolder>{

    private final List<Contact> contacts;
    private IClickListenner listenner;

    public ContactAdapter(List<Contact> contacts){ this.contacts = contacts; }

    public void setListenner(IClickListenner listenner){this.listenner = listenner; }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return  new ContactViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.bindPerson(contacts.get(position),position);
    }

    @Override
    public int getItemCount() { return contacts.size(); }


    public  class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private final TextView tvNameContact;
        private final TextView tvNumberContact;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameContact = itemView.findViewById(R.id.tvNameContact);
            tvNumberContact = itemView.findViewById(R.id.tvNumberContact);

            itemView.setOnClickListener(this);
        }


        private void bindPerson(Contact contact, int position){
            tvNumberContact.setText(contact.getPhone1());
            tvNameContact.setText(contact.getFirstSurname() + " " + contact.getSecondSurname());
        }

        @Override
        public void onClick(View view) {
            if(listenner != null)
                listenner.OnClick(getAdapterPosition());
        }
    }

}
