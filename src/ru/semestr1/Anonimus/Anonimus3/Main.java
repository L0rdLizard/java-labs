package ru.semestr1.Anonimus.Anonimus3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("\u0422\u044b \u043f\u043e\u0439\u0434\u0435\u0448\u044c \u0432 \u041b\u0438\u0433\u0443?");
        System.out.println("\u041d\u0430\u043f\u0438\u0448\u0438 yes \u0438\u043b\u0438 no");

        String ar1;
        Scanner in = new Scanner(System.in); 
        ar1 = in.nextLine();

        if (ar1.equals("no")){
        System.out.println ("\u041d\u0443 \u0442\u044b \u0438 \u043f\u0438\u0441\u044c\u043a\u0430");
        } else if (ar1.equals("yes")){
        System.out.println ("\u0437\u0430\u0445\u043e\u0434\u0438 \u0432 \u041f\u043e\u0441\u0435\u043b\u0435\u043d\u0438\u0435 \u0414\u0435\u0442\u0438");

        return;
        }
    }
}