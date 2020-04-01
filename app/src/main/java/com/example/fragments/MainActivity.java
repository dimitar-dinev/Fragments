package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import com.example.fragments.model.ContactDB;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements AddContactDialog.AddContactDialogListener {

    ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        adapter = new ContactAdapter(ContactDB.getContacts());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                AddContactDialog addContactDialog = AddContactDialog.newInstance();
                addContactDialog.setCancelable(false);
                addContactDialog.show(fragmentTransaction, "dialog");
            }
        });
    }

    @Override
    public void onContactAdded(String name, String address) {
        if (ContactDB.addContact(name, address)) {
            adapter.notifyDataSetChanged();
        }
    }
}
