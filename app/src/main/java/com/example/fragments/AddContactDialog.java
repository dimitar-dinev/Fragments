package com.example.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class AddContactDialog extends DialogFragment {

    public interface AddContactDialogListener {
        void onContactAdded(String name, String address);
    }

    static AddContactDialog newInstance() {
        return new AddContactDialog();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.dialog_layout,  container, false);

        final EditText nameTextView = v.findViewById(R.id.nameEditText);
        final EditText addressTextView = v.findViewById(R.id.addressEditText);

        Button cancelButton = v.findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddContactDialog.this.dismiss();
            }
        });

        Button confirmButton = v.findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddContactDialogListener listener = (AddContactDialogListener) getActivity();
                if (listener != null) {

                    String nameText = nameTextView.getText().toString();
                    String addressText = addressTextView.getText().toString();

                    if (!nameText.isEmpty() && !addressText.isEmpty()) {
                        listener.onContactAdded(nameTextView.getText().toString(), addressTextView.getText().toString());
                        dismiss();
                    } else {
                        Toast.makeText(getActivity(), "You cannot have empty fields!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        return v;
    }
}
