package dev.maxim.lab13;

import lombok.Synchronized;
import lombok.ToString;

import java.io.*;
import java.io.FileInputStream;
import java.util.ArrayList;

@ToString
public class NoteBookStore {
    private static volatile NoteBookStore instance;

    private NoteBook noteBook = new NoteBook();

    @ToString.Exclude
    private final File database;

    public NoteBookStore(String databasePath) {
        this.database = new File(databasePath);
        try {
            this.database.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static NoteBookStore getInstance(String databasePath) {
        if (instance == null) {
            synchronized (NoteBookStore.class) {
                if (instance == null) {
                    instance = new NoteBookStore(databasePath);
                }
            }
        }
        return instance;
    }


    public synchronized void load() {
        noteBook = new NoteBook();
        try (BufferedReader reader = new BufferedReader(new FileReader(database))) {
            String line;
            String name = null;
            ArrayList<String> phones = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("#")) {
                    if (name != null) {
                        Contact contact = new Contact(name, phones);
                        noteBook.addContact(contact);
                    }
                    name = line.substring(1);
                    phones = new ArrayList<>();
                } else {
                    phones.add(line);
                }
            }

            if (name != null) {
                Contact contact = new Contact(name, phones);
                noteBook.addContact(contact);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(database))) {
            for (Contact contact : noteBook.getContacts()) {
                writer.write("#" + contact.getName());
                writer.newLine();
                for (String phone : contact.getPhones()) {
                    writer.write(phone);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Synchronized
    public NoteBook getAddressBook() {
        return noteBook;
    }

    @Synchronized
    public Contact getContact(String name) {
        return noteBook.getContact(name);
    }

    @Synchronized
    public void addContact(Contact contact) {
        noteBook.addContact(contact);
    }

    @Synchronized
    public void update(String name, String phone) {
        noteBook.update(name, phone);
    }
}
