package ru.semestr1.Anonimus.Anonimus2;

public class Main {
    public static void main(String[] args) {
        System.out.println("love you");
        System.out.println("  <3  <3");

        for (int i = 4; i <= 5; i++) {
            for (int j = 5; j > i; j--) {
                System.out.printf(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.printf("<3");
            }

            System.out.println();
        }

        for (int i = 4; i >= 1; i--) {
            for (int j = 4; j >= i; j--) {
                System.out.printf(" ");
            }

            for (int j = i; j >= 1; j--) {
                System.out.printf("<3");
            }

            System.out.println();
        }
    }
}
