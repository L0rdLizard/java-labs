package ru.semestr1.lab07;

import java.util.Arrays;
import java.util.HashMap;
import java.io.*;
public class Settings {
    private HashMap<String, Integer> settingsMap;

    public Settings() {
        settingsMap = new HashMap<String, Integer>();
    }


    public void put(String key, int value) {
        settingsMap.put(key, value);
    }

    public int get(String key) {
        return settingsMap.get(key);
    }

    public void delete(String key) {
        settingsMap.remove(key);
    }

    public void saveToBinaryFile(String filename) throws IOException {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(settingsMap);
            out.flush();
            out.close();
        } catch (Exception e) {
            throw new IOException("Error while saving to binary file: " + e.getMessage() + Arrays.toString(e.getStackTrace()));
        }
    }

    public void loadFromBinaryFile(String filename) throws IOException {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            this.settingsMap = (HashMap<String, Integer>) in.readObject();
            in.close();
        } catch (Exception e) {
            throw new IOException("Error while loading from binary file: " + e.getMessage());
        }
    }

    public void saveToTextFile(String filename) throws IOException {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(filename));
            out.println(this);
            out.flush();
            out.close();
        } catch (Exception e) {
            throw new IOException("Error while saving to text file: " + e.getMessage());
        }
    }

    public void loadFromTextFile(String filename) throws IOException {
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String line = in.readLine();
            in.close();
            this.settingsMap = new HashMap<String, Integer>();
            String[] pairs = line.substring(10, line.length() - 1).split(", ");
            for (String pair : pairs) {
                String[] keyValue = pair.split("=");
                this.settingsMap.put(keyValue[0], Integer.parseInt(keyValue[1]));
            }
        } catch (Exception e) {
            throw new IOException("Error while loading from text file: " + e.getMessage());
        }
    }

    @Override
    public String toString(){
        return settingsMap.toString();
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Settings settings = (Settings) obj;
        return settings.settingsMap.equals(this.settingsMap);
    }

}
