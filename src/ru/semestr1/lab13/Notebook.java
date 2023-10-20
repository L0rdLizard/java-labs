package ru.semestr1.lab13;

import java.util.Arrays;
import java.util.List;

public class Notebook  {
    private String name;
    private List<String> phones;

    public Notebook(String name, List<String> phones) {
        this.name = name;
        this.phones = phones;
    }

    public Notebook() {
    }

    public String getName() {
        return name;
    }

    public List<String> getPhone() {
        return phones;
    }
}
