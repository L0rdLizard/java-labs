package ru.semestr1.lab06.FormattedInput;

import java.util.Scanner;

public class FormattedInput {
    public static Object[] scanf(String format) {
        return readFromScanner(new Scanner(System.in), format);
    }

    public static Object[] sscanf(String format, String in) {
        return readFromScanner(new Scanner(in), format);
    }


    private static Object[] readFromScanner(Scanner scanner, String format) {
        Object[] result = new Object[format.length()];
        int currentIndex = 0;
        for (int i = 0; i < format.length(); i++) {
            char c = format.charAt(i);
            if (c == '%') {
                char specifier = format.charAt(i + 1);
                switch (specifier) {
                    case 'd':
                        while (!scanner.hasNextInt()) {
                            scanner.next();
                        }
                        result[currentIndex] = scanner.nextInt();
                        break;
                    case 'f':
                        while (!scanner.hasNextDouble()) {
                            scanner.next();
                        }
                        result[currentIndex] = scanner.nextDouble();
                        break;
                    case 's':
                        while (!scanner.hasNext()) {
                            scanner.next();
                        }
                        result[currentIndex] = scanner.next();
                        break;
                    case 'c':
                        while (!scanner.hasNext()) {
                            scanner.next();
                        }
                        result[currentIndex] = scanner.next().charAt(0);
                        break;
                }
                currentIndex++;
                i++;
            }
        }
        return result;
    }
}
