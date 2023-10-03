package ru.semestr1.lab08dop;

import ru.semestr1.lab01.Int;

import java.util.Arrays;
import java.util.Comparator;
public class Main8dop {
    public static void main(String[] args) {


//        int array [] = new int[1000];
//        for (int i = 0; i < 1000; i++) {
//            array[i] = (int) (Math.random() * 1000);
//        }
//        System.out.println(Arrays.toString(array));
//
//        Object[] arrayObject = new Object[array.length];
//        for (int i = 0; i < 1000; i++) {
//            arrayObject[i] = array[i];
//        }
//
//        MergeSort.mergesort(arrayObject,1);
//
//        System.out.println(Arrays.toString(arrayObject));

        Integer[] array = new Integer[10000];
        for (int i = 0; i < 10000; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        long time = System.currentTimeMillis();

        MergeSort.mergesort(array, 4, Comparator.naturalOrder());

        System.out.println(System.currentTimeMillis() - time);

//        System.out.println(Arrays.toString(array));

    }
}
