package ru.semestr1.lab06;

import ru.semestr1.lab06.FormattedInput.FormattedInput;
//доп
public class Main6 {

    public static void main(String[] args) {
//        Object[] vals = FormattedInput.scanf("%d %s %c");
//        int i = (int) vals[0];
//        String s = (String) vals[1];
//        char c = (char) vals[2];
//        System.out.println("i = " + i + ", s = " + s + ", c = " + c);
//
//        String str = "я люблю гуап";
//        Object[] valsStr = FormattedInput.sscanf("%s %s %s", str);
//
//        String x = (String) valsStr[0];
//        String y = (String) valsStr[1];
//        String z = (String) valsStr[2];
//
//        System.out.println( x + " " + y + " " + z);

        String data = "19 May 2003";
        Object[] test = FormattedInput.sscanf("%d %s %d", data);
        int number = (Integer) test[0];
        String month = (String) test[1];
        int year = (Integer) test[2];

        System.out.println( month + " " + number + ", " + year);
    }
}
