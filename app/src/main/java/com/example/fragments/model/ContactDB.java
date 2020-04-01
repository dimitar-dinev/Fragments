package com.example.fragments.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactDB {

    private static List<Contact> contacts = new ArrayList<>(Arrays.asList(new Contact("Dimitar Dinev", "Varna, Bulgaria"),
                                                                        new Contact("Stefan Kolev", "LA, California, USA")));

    public static List<Contact> getContacts() {
                return contacts;
    }

    public static boolean addContact(String name, String address) {
        return contacts.add(new Contact(name, address));
    }
}
