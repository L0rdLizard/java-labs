package ru.semestr1.Anonimus.Anonimus1;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main{ 
    public static void main(String[] args) throws InterruptedException { 
        int yes = 0;
        int no = 0;

        System.out.println("Все привет, меня зовут Анастасия Гетц, и сегодня замечательный день для того чтобы вы увидели все мои навыки программирования. Type 'yes' or 'no'");
        String ar1;
        Scanner in = new Scanner(System.in); 
        ar1 = in.nextLine();
        if (ar1.equals("yes")) yes++;
        if (ar1.equals("no")) no++;
        System.out.println(); 


        System.out.println("Мне, конечно помогал мой любимка Максим, но он чисто иногда запятую ставил в конце..ничего критичного. Type 'yes' or 'no'"); //мииии
        String ar2;
        ar2 = in.nextLine();
        if (ar2.equals("yes")) yes++;
        if (ar2.equals("no")) no++;
        System.out.println(); 

        System.out.println("Наверное, ты знаешь зачем мы тут собрались Type 'yes' or 'no'");
        String ar3; 
        ar3 = in.nextLine();
        if (ar3.equals("yes")) yes++;
        if (ar3.equals("no")) no++;
        System.out.println();

        System.out.println("Если нет, то ты сейчас быстро поймешь это. А если да, то ты догадливая лепешка умничка ;) Type 'yes' or 'no'");
        String ar4;
        ar4 = in.nextLine();
        if (ar4.equals("yes")) yes++;
        if (ar4.equals("no")) no++;
        System.out.println();

        System.out.println("Хихихи, конечно же я пришла сказать тебе как сильно я тебя люблю! Type 'yes' or 'no'"); // ;) ^^ :<> '.' 
        String ar5;
        ar5 = in.nextLine();
        if (ar5.equals("yes")) yes++;
        if (ar5.equals("no")) no++;
        System.out.println();
        
        System.out.println("Этот код может сохранится ещё у тебя несколько лет, будет мило снова его открыть и поумиляться"); // все включай ВКЛЮЧАЙ!!!!!!!!!!!!!!!!
        System.out.println("Я люблю тебя!"); //уууууууууууууууууууууууууууууууууууууууууууууууууууууууууууу включай гворю
        System.out.println("Ти мок сокровище и я тебя очень и очень ценю! <33 (тут мог бы быть вывод чердечка, но я так не умею)");

        System.out.println(yes);
        System.out.println(no);
        in.close();

        final int N = 10;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= 4 * N; j++) {
                double d1 = Math.sqrt(Math.pow(i - N, 2) + Math.pow(j - N, 2));
                double d2 = Math.sqrt(Math.pow(i - N, 2) + Math.pow(j - 3 * N, 2));

                if (d1 < N + 0.5 || d2 < N + 0.5) {
                    System.out.print('*');
                    TimeUnit.MILLISECONDS.sleep(1);
                } else {
                    System.out.print(' ');
                }
            }
            System.out.print(System.lineSeparator());
        }

        for (int i = 1; i < 2 * N; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(' ');
            }

            for (int j = 0; j < 4 * N + 1 - 2 * i; j++) {
                System.out.print('*');
                TimeUnit.MILLISECONDS.sleep(1);
            }

            System.out.print(System.lineSeparator());
        }

        return; 
    }

}
