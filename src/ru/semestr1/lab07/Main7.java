package ru.semestr1.lab07;

import java.io.*;

public class Main7 {
    public static void main(String[] args) {
        Settings test1 = new Settings();
        test1.put("Volume", 10);
        test1.put("Brightness", 8);
        System.out.println(test1);
        String basePath = "src/ru/semestr1/lab07/";
//        test1.saveToBinaryFile(basePath + "TestSaveToBin");
        try{
            test1.saveToBinaryFile(basePath + "TestSaveToBin");
            Settings test2 = new Settings();
            test2.loadFromBinaryFile("TestSaveToBin");
            System.out.println(test2);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

//        try{
//            test1.saveToTextFile(basePath + "TestSaveToText");
//            Settings test3 = new Settings();
//            test3.loadFromTextFile(basePath + "TestSaveToText");
//            System.out.println(test3);
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
    }
}
