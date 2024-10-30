package com.william.fracgmentcontactjava.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.william.fracgmentcontactjava.R;
import com.william.fracgmentcontactjava.models.Contact;

public class        FragmentDetails extends Fragment {

    public interface IOnAttachListenner{
        Contact getContact();
    }

    private IOnAttachListenner attachListenner;
    private TextView tvNameContact;
    private TextView tvApellidoContact;
    private TextView tvCompanyContact;
    private TextView tvBirthContact;
    private TextView tvEmailContact;
    private TextView tvPhone1Contact;
    private TextView tvPhone2Contact;
    private TextView tvAddressContact;
    private ImageView imgPerfileContact;

    public FragmentDetails(){ super(R.layout.fragment_detail);}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.i("Entra en el detalle created", "Bein");
        super.onViewCreated(view, savedInstanceState);
        tvNameContact = view.findViewById(R.id.tvNombreContact);
        tvApellidoContact = view.findViewById(R.id.tvApellidoContact);
        tvCompanyContact = view.findViewById(R.id.tvEmpresaContact);
        tvBirthContact = view.findViewById(R.id.rvDateContact);
        tvEmailContact = view.findViewById(R.id.tvCorreoContact);
        tvPhone1Contact = view.findViewById(R.id.tvTelefono1Contact);
        tvPhone2Contact = view.findViewById(R.id.tvTelefono2Contact);
        tvAddressContact = view.findViewById(R.id.tvDireccionContact);
        imgPerfileContact = view.findViewById(R.id.imgPerfileContact);

        Contact tmp = attachListenner.getContact();
        Log.i("TXTVIEW", String.valueOf(tvNameContact));
        tvNameContact.setText("Nombre : " + tmp.getName());
        tvApellidoContact.setText("Apellido : " + tmp.getFirstSurname() + " " + tmp.getSecondSurname());
        tvAddressContact.setText("Direccion : " + tmp.getAddress());
        tvCompanyContact.setText("Empresa : " + tmp.getCompany());
        tvPhone1Contact.setText("Telefono 1 : " + tmp.getPhone1());
        tvPhone2Contact.setText("Telefono 2 : " + tmp.getPhone2());
        tvEmailContact.setText("Email : " + tmp.getEmail());
        imgPerfileContact.setImageResource(R.drawable.img);

    }
    //TODO: MIRRAR AQUI DA ERROR NO OLVIDAR NS DONDE PERO NO ENTRA. CREO!!!
        public void  setProp(Contact contact){
            Log.i("Dentro", "DENTRO!");
            tvAddressContact.setText(contact.getAddress());
            tvApellidoContact.setText(contact.getSecondSurname());
            tvBirthContact.setText(contact.getBirth());
            tvEmailContact.setText(contact.getEmail());
            tvCompanyContact.setText(contact.getCompany());
            tvNameContact.setText(contact.getName());
            tvPhone1Contact.setText(contact.getPhone1());
            tvPhone2Contact.setText(contact.getPhone2());
        }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        attachListenner = (IOnAttachListenner) requireActivity();
    }
}
