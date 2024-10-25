package com.william.fracgmentcontactjava.ui;

import android.app.Person;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.william.fracgmentcontactjava.R;
import com.william.fracgmentcontactjava.interfaces.IClickListenner;
import com.william.fracgmentcontactjava.models.Contact;
import com.william.fracgmentcontactjava.models.ContactAdapter;
import com.william.fracgmentcontactjava.models.ContactJson;
import com.william.fracgmentcontactjava.ui.fragments.FragmentDetails;
import com.william.fracgmentcontactjava.ui.fragments.FragmentList;

import org.json.JSONException;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IClickListenner,
        FragmentList.IOnAttachListenner, FragmentDetails.IOnAttachListenner {

    private List<Contact> contacts;
    private final String CONTACTS_KEY = "CONTACTS";
    private final String SELECTED_CONTACT_KEY = "SELECTED_CONTACT";
    private FragmentManager fragmentManager;
    private FragmentDetails fragmentDetail;
    private boolean detalle;
    private int selectedContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        fragmentManager = getSupportFragmentManager();

        fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            loadData();
        } else {
            contacts = (List<Contact>) savedInstanceState.getSerializable(CONTACTS_KEY);
            selectedContact = savedInstanceState.getInt(SELECTED_CONTACT_KEY);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        detalle = findViewById(R.id.fcvDetail) != null; //!MIERDA DE VIDA.
        Log.i("detalle", String.valueOf(detalle));
        if (detalle) {
            fragmentDetail = (FragmentDetails) fragmentManager.findFragmentById(R.id.fcvDetail);
            if (!(fragmentManager.findFragmentById(R.id.fcvList) instanceof  FragmentList)){
                fragmentManager.popBackStack();
            }
        }
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(CONTACTS_KEY, (Serializable) contacts);
        outState.putInt(SELECTED_CONTACT_KEY, selectedContact);
    }

    public  void loadData(){
    selectedContact = -1;
    contacts = getContacts();
    if (!contacts.isEmpty()){
        selectedContact = 0;
    }


}

    @Override
    public void OnClick(int position) {

        Contact contact = contacts.get(position);
        selectedContact = position;
        Log.i("Clicked", String.valueOf(position));
        if (detalle){
            fragmentDetail.setProp(contact);
        }
        else {
            fragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .setReorderingAllowed(true)
                    .replace(R.id.fcvList, FragmentDetails.class, null)
                    .commit();
        }

        Log.i("Sale", "aaaaaaaaaaaaaa");
    }

    @Override
    public Contact getContact() {
        return contacts.get(selectedContact);
    }

    @Override
    public ArrayList<Contact> getContacts() {
        return ContactJson.parse(this);
    }
}