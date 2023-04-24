package ru.semestr1.lab08;

import ru.semestr1.lab08.matrix.UsualMatrix;

import java.util.Arrays;

//
public class Main8 {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();


//        UsualMatrix m1 = new UsualMatrix(1000);
//        UsualMatrix m2 = new UsualMatrix(1000);
//        UsualMatrix m3;
//        ParallelMatrixProduct mProduct = new ParallelMatrixProduct(1);
//        for (int i = 0; i < 1000; i++) {
//            m1.setElement((int) (Math.random() * 1000), (int) (Math.random() * 1000), (int) (Math.random() * 1000));
//            m2.setElement((int) (Math.random() * 1000), (int) (Math.random() * 1000), (int) (Math.random() * 1000));
//        }
//        m3 = mProduct.multiply(m1,m2);
////        m3 = m1.product(m2);
//        System.out.println(m3);

        int array [] = new int[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        System.out.println(Arrays.toString(array));

        Object[] arrayObject = new Object[array.length];
        for (int i = 0; i < 1000; i++) {
            arrayObject[i] = array[i];
        }

        MergeSort.mergesort(arrayObject,4);

        System.out.println(Arrays.toString(arrayObject));

        System.out.println(System.currentTimeMillis() - time);
    }
}
