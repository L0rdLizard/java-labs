package ru.semestr1.lab07;

import java.io.*;

public class Main7 {
    public static void main(String[] args) {
//        Settings test1 = new Settings();
//        test1.put("Volume", 10);
//        test1.put("Brightness", 8);
//        System.out.println(test1);
//        String basePath = "src/ru/semestr1/lab07/";
////        test1.saveToBinaryFile(basePath + "TestSaveToBin");
//        try{
//            test1.saveToBinaryFile(basePath + "testSaveToBin");
//            Settings test2 = new Settings();
//            test2.loadFromBinaryFile(basePath + "testSaveToBin");
//            System.out.println(test2);
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }

        Settings settings = new Settings();

        settings.put("a", 1);
        settings.put("b", 2);
        settings.put("c", 3);
        settings.put("d", 4);
        settings.put("answer", 42);
        settings.put("number", 618);

        System.out.println(settings);

        String basePath = "src/ru/semestr1/lab07/";

        try {
            // save to binary file and load to new object
            settings.saveToBinaryFile(basePath + "settings.bin");
            Settings settings2 = new Settings();
            settings2.loadFromBinaryFile(basePath + "settings.bin");
            System.out.print("Read from binary file: ");
            System.out.println(settings2);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            // save to text file and load to new object
            settings.saveToTextFile(basePath + "settings.txt");
            Settings settings3 = new Settings();
            settings3.loadFromTextFile(basePath + "settings.txt");
            System.out.print("Read from text file: ");
            System.out.println(settings3);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
