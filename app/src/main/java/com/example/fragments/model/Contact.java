package com.example.fragments.model;

public class Contact {

    private String mName;
    private String mAddress;

    public Contact(String mName, String mAddress) {
        this.mName = mName;
        this.mAddress = mAddress;
    }

    public String getmName() {
        return mName;
    }

    public String getmAddress() {
        return mAddress;
    }
}
