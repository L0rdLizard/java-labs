package ru.semestr1.lab1;
//доп: fraction класс для работы с дробями 2 методо add mul числитель и зн в разных полях
public class Main {
    public static void main(String[] args) {
        // Int a = new Int(5);
        // System.out.println("a = " + a);

        // Int b = new Int(10);
        // System.out.println("b = " + b);
        // System.out.println();

        // a.add(b);
        // System.out.println("a = a + b = " + a);
        // System.out.println();

        // a.sub(b);
        // System.out.println("a = a - b = " + a);
        // System.out.println();

        // a.increment();
        // System.out.println("a++ = " + a);
        // System.out.println();

        // a.decrement();
        // System.out.println("a-- = " + a);
        // System.out.println();
        Fraction a = new Fraction(1, 2);
        Fraction b = new Fraction(1, 3);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println();

        Fraction c = a.add(b);
        System.out.println("c = a + b = " + c);

        Fraction d = a.mul(b);
        System.out.println("d = a * b = " + d);
    }
}