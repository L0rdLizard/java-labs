package ru.semestr1.lab07;

import java.security.Key;
import java.util.HashMap;
//сделать чтения из файла
public class PhonesMarket {
    private HashMap<Integer, PhoneDetails> phones;
    private int PhoneId;

    public PhonesMarket() {
        phones = new HashMap<Integer, PhoneDetails>();
        PhoneId = 0;
    }

    public void addPhone(String brand, String model, int price) {
        PhoneDetails phone = new PhoneDetails();
        phone.brand = brand;
        phone.model = model;
        phone.price = price;
        phones.put(PhoneId, phone);
        PhoneId++;
    }

    public void sortByPrice() {
        for (int i = 0; i < phones.size(); i++) {
            for (int j = 0; j < phones.size() - 1; j++) {
                if (phones.get(j).price > phones.get(j + 1).price) {
                    PhoneDetails temp = phones.get(j);
                    phones.put(j, phones.get(j + 1));
                    phones.put(j + 1, temp);
                }
            }
        }
    }

    public void LowerPrice(int price) {
        for (int i = 0; i < phones.size(); i++) {
            if (phones.get(i).price < price) {
                System.out.println(phones.get(i).brand + " " + phones.get(i).model + " " + phones.get(i).price);
            }
        }
    }

    public void HigherPrice(int price) {
        for (int i = 0; i < phones.size(); i++) {
            if (phones.get(i).price > price) {
                System.out.println(phones.get(i).brand + " " + phones.get(i).model + " " + phones.get(i).price);
            }
        }
    }

    public void printPhone(int id) {
        System.out.println(phones.get(id).brand + " " + phones.get(id).model + " " + phones.get(id).price);
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < phones.size(); i++) {
            result.append("Phone ").append(i).append(": ").append(phones.get(i).brand).append(" ").append(phones.get(i).model).append(" ").append(phones.get(i).price).append("\n");
        }
        return result.toString();
    }
}