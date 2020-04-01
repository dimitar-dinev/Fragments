package com.example.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fragments.model.Contact;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private List<Contact> mContacts;

    ContactAdapter(List<Contact> mContacts) {
        this.mContacts = mContacts;
    }

    static class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView addressTextView;
        ImageView image;

         ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.contact_name);
            addressTextView = itemView.findViewById(R.id.contact_address);
            image = itemView.findViewById(R.id.contact_image);
        }
    }


    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout, parent, false);
        return new ContactViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ContactViewHolder holder, int position) {
        holder.nameTextView.setText(mContacts.get(position).getmName());
        holder.addressTextView.setText(mContacts.get(position).getmAddress());

    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }
}
