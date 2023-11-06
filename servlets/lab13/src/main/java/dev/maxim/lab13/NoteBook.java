package dev.maxim.lab13;

import lombok.*;

import java.util.ArrayList;
import java.util.Objects;

@Data
public class NoteBook {
    private ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact){
        contacts.add(contact);
    }

    public Contact getContact(String name){
        for (Contact contact : contacts){
            if (Objects.equals(contact.getName(), name))
                return contact;
        }
        return null;
    }

    public void update(String name, String phone) {
        Contact contact = getContact(name);
        if (contact != null) {
            contact.addPhone(phone);
        } else {
            addContact(new Contact(name, phone));
        }
    }

    public void update(String name, ArrayList<String> phones) {
        Contact contact = getContact(name);
        if (contact != null) {
            contact.getPhones().addAll(phones);
        } else {
            addContact(new Contact(name, phones));
        }
    }
}
