package com.william.fracgmentcontactjava.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.william.fracgmentcontactjava.R;
import com.william.fracgmentcontactjava.interfaces.IClickListenner;
import com.william.fracgmentcontactjava.models.Contact;
import com.william.fracgmentcontactjava.models.ContactAdapter;

import java.util.List;

public class FragmentList extends Fragment {

    public interface IOnAttachListenner{
        List<Contact> getContacts();
    }

    private IClickListenner clickListenner;
    private List<Contact> contacts;

    public FragmentList(){super(R.layout.fragment_list);}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvList = view.findViewById(R.id.rvList);
        ContactAdapter adapter = new ContactAdapter(contacts);
        adapter.setListenner(clickListenner);
        rvList.setAdapter(adapter);
        rvList.hasFixedSize();
        rvList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        IOnAttachListenner onAttachListenner = (IOnAttachListenner) requireActivity();
        clickListenner = (IClickListenner) requireActivity();
        contacts = onAttachListenner.getContacts();
    }
}
