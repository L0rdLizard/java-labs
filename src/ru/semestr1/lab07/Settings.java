package ru.semestr1.lab07;

import java.util.HashMap;
import java.io.*;
public class Settings {
    private HashMap<String, Integer> settingsMap;

    public Settings() {
        settingsMap = new HashMap<String, Integer>();
    }

    @Override
    public String toString(){
        return settingsMap.toString();
    }
    
    @Override
    public boolean equals(Object obj){
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Settings settings = (Settings) obj;
        return settingsMap.equals(settings.settingsMap);
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
            out.writeObject(this);
            out.flush();
            out.close();
        } catch (Exception e) {
            throw new IOException("Error while saving to binary file: " + e.getMessage());
        }
    }

    public void loadFromBinaryFile(String filename) throws IOException {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            Settings settings = (Settings) in.readObject();
            in.close();
            this.settingsMap = settings.settingsMap;
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
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] keyValue = line.split(" ");
//                settingsMap.put(keyValue[0], Integer.parseInt(keyValue[1]));
//            }
//        } catch (IOException e) {
//            throw new IOException("Error while reading from file", e);
//        }
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


}
