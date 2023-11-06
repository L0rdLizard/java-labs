package dev.maxim.lab13;

import lombok.*;

import java.util.ArrayList;

@Data
public class Contact {
    private String name;
    private ArrayList<String> phones = new ArrayList<>();

    public Contact(String name, String phone) {
        setName(name);
        addPhone(phone);
    }

    public Contact(String name, ArrayList<String> phones) {
        setName(name);
        this.phones = phones;
    }

    public void addPhone(String phone) {
        phones.add(phone);
    }
}
