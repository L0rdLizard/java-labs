package ru.semestr1.lab1;

public class Main {
    public static void main(String[] args) {
        Int a = new Int(5);
        Int b = new Int(10);
        a.add(b);
        a.tostring();
        a.sub(b);
        a.tostring();
        a.increment();
        a.tostring();
        a.decrement();
        a.tostring();
    }
}