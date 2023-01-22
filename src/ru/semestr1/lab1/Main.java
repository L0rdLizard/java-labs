package ru.semestr1.lab1;

public class Main {
    public static void main(String[] args) {
        Int a = new Int(5);
        System.out.println("a = " + a);

        Int b = new Int(10);
        System.out.println("b = " + b);
        System.out.println();

        a.add(b);
        System.out.println("a = a + b = " + a);
        System.out.println();

        a.sub(b);
        System.out.println("a = a - b = " + a);
        System.out.println();

        a.increment();
        System.out.println("a++ = " + a);
        System.out.println();

        a.decrement();
        System.out.println("a-- = " + a);
        System.out.println();

        // a.add(b);
        // a.tostring();
        // a.sub(b);
        // a.tostring();
        // a.increment();
        // a.tostring();
        // a.decrement();
        // a.tostring(); мимимииииииииииииииииииииииииииииииииииииииииииииииииииииииииииии
        // a.increment(); че это
    }
}