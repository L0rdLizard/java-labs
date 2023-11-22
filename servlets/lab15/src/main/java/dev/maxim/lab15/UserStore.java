package dev.maxim.lab15;

import lombok.Synchronized;
import lombok.ToString;

import java.io.*;
import java.util.ArrayList;

public class UserStore {
    private static volatile UserStore instance;
    private ArrayList<User> users = new ArrayList<>();

//    @ToString.Exclude
//    private final ObjectMapper objectMapper = new ObjectMapper();

    @ToString.Exclude
    private final File database;

    public UserStore(String databasePath) {
        this.database = new File(databasePath);
        try {
            if (this.database.createNewFile()) {
                addDummyUsers();
                save();
                System.out.println("Database created");
            } else {
                load();
                System.out.println("Database loaded");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static UserStore getInstance(String dbPath) {
        if (instance == null) {
            synchronized (UserStore.class) {
                if (instance == null) {
                    instance = new UserStore(dbPath);
                }
            }
        }
        return instance;
    }
    @Synchronized
    public void load() {
        users.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader("users15.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    String username = parts[0];
                    String password = parts[1];
                    User user = new User(username, password);
                    users.add(user);
                } else {
                    System.out.println("Некорректный формат строки: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (User user : users) {
            System.out.println("Username: " + user.getUsername() + ", Password: " + user.getPassword());
        }
    }

    @Synchronized
    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users15.txt"))) {
            for (User user : users) {
                writer.write(user.getUsername() + " " + user.getPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Synchronized
    public boolean check(User input) {
        for (User user : users) {
            if (user.equals(input)) return true;
        }
        return false;
    }

    private void addDummyUsers() {
        users.add(new User("root"));
        users.add(new User("demo"));
        users.add(new User("maksim"));
        users.add(new User("nastya"));
        users.add(new User("user", "abcd"));
        users.add(new User("potat", "1234"));
    }
}
