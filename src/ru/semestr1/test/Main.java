package ru.semestr1.test;

import java.util.Scanner;

public class Main{ //я писька и я daa
    public static void main(String[] args) { 
        int yes = 0;
        int no = 0;

        System.out.println("Все привет, меня зовут Анастасия Гетц, и сегодня замечательный день для того чтобы вы увидели все мои навыки программирования. Type 'yes' or 'no'");
        String ar1;
        Scanner in = new Scanner(System.in);
        ar1 = in.nextLine();
        System.out.println(ar1); 
        if (ar1.equals("yes")) yes++;
        if (ar1.equals("no")) no++;
        System.out.println(); 


        System.out.println("Мне, конечно помогал мой любимка Максим, но он чисто иногда запятую ставил в конце..ничего критичного. Type 'yes' or 'no'"); //мииии
        String ar2;
        ar2 = in.nextLine();
        if (ar2.equals("yes")) yes++;
        if (ar2.equals("no")) no++;
        System.out.println(); 

        System.out.println("Type 'yes' or 'no'");
        String ar3; 
        ar3 = in.nextLine();
        if (ar3.equals("yes")) yes++;
        if (ar3.equals("no")) no++;
        System.out.println();

        System.out.println("Type 'yes' or 'no'");
        String ar4;
        ar4 = in.nextLine();
        if (ar4.equals("yes")) yes++;
        if (ar4.equals("no")) no++;
        System.out.println();

        System.out.println("Type 'yes' or 'no'");
        String ar5;
        ar5 = in.nextLine();
        if (ar5.equals("yes")) yes++;
        if (ar5.equals("no")) no++;
        System.out.println();
        
        System.out.println(yes);
        System.out.println(no);
        in.close();
        return;
    }

}
