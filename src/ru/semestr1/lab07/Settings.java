package ru.semestr1.lab07;

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

    }
    public void loadFromBinaryFile(String filename) throws IOException {

    }
    public void saveToTextFile(String filename) throws IOException {

    }
    public void loadFromTextFile(String filename) throws IOException {

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
}
