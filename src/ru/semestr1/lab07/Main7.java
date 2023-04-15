package ru.semestr1.lab07;

import java.io.*;
//класс для хранения данных о телефонах в магазине (марка, модель, стоимость). Метод вывести телефоны дорое
public class Main7 {
    public static void main(String[] args) {
//        Settings settings = new Settings();
//
//        settings.put("a", 1);
//        settings.put("bio", 2);
//        settings.put("centra", 3);
//        settings.put("delta", 4);
//        settings.put("answer", 42);
//        settings.put("number", 618);
//
//        System.out.println(settings);
//
//        String basePath = "src/ru/semestr1/lab07/";
//
//        try {
//            // save to binary file and load to new object
//            settings.saveToBinaryFile(basePath + "settings.bin");
//            Settings settings2 = new Settings();
//            settings2.loadFromBinaryFile(basePath + "settings.bin");
//            System.out.print("Read from binary file: ");
//            System.out.println(settings2);
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            // save to text file and load to new object
//            settings.saveToTextFile(basePath + "settings.txt");
//            Settings settings3 = new Settings();
//            settings3.loadFromTextFile(basePath + "settings.txt");
//            System.out.print("Read from text file: ");
//            System.out.println(settings3);
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }

        PhonesMarket phones = new PhonesMarket();
        phones.addPhone("Samsung", "Galaxy S7", 7000);
        phones.addPhone("Samsung", "Galaxy S10", 10000);
        phones.addPhone("Samsung", "Galaxy S9", 9000);
        phones.addPhone("Samsung", "Galaxy S6", 6000);
        phones.addPhone("Samsung", "Galaxy S8", 8000);

        System.out.println(phones);
        phones.sortByPrice();
        System.out.println(phones);
        phones.LowerPrice(8000);
        System.out.println();
        phones.HigherPrice(8000);
    }
}
