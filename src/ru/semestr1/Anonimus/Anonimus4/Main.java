package ru.semestr1.Anonimus.Anonimus4;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        int n = in.nextInt();
        in.close();

        if (n < 0) {
            System.out.println("Дурачёк, введи положительное число");
        } else {
            for (int i = 0; i < n; i++) {
                System.out.println("Я тебя люблю");
            }
        }
    }
}
