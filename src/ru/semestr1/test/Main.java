package ru.semestr1.test;

import java.util.Scanner;

public class Main{ //я писька и я daa
    public static void main(String[] args) {

    
        System.out.println("Я лепешка? Type 'yes' or 'no'");
        String ar1;
        Scanner in = new Scanner(System.in);
        ar1 = in.nextLine();
        System.out.println(); 


        System.out.println("Ти меня лбюбишь? Type 'yes' or 'no'");
        String ar2;
        ar2 = in.nextLine();
        System.out.println(); 

        in.close();
        return;
    }

}
