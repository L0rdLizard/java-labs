package ru.semestr1.lab08;

import ru.semestr1.lab08.matrix.UsualMatrix;

import java.util.Arrays;

//
public class Main8 {
    public static void main(String[] args) {


//        UsualMatrix m1 = new UsualMatrix(1000);
//        UsualMatrix m2 = new UsualMatrix(1000);
//        UsualMatrix m3;
//        ParallelMatrixProduct mProduct = new ParallelMatrixProduct(4);
//        for (int i = 0; i < 1000; i++) {
//            m1.setElement((int) (Math.random() * 1000), (int) (Math.random() * 1000), (int) (Math.random() * 1000));
//            m2.setElement((int) (Math.random() * 1000), (int) (Math.random() * 1000), (int) (Math.random() * 1000));
//        }
//        long time = System.currentTimeMillis();
//
//        m3 = mProduct.multiply(m1,m2);
//
//        System.out.println(System.currentTimeMillis() - time);

//        UsualMatrix matrix1 = new UsualMatrix(10);
//        UsualMatrix matrix2 = new UsualMatrix(10);
//        UsualMatrix matrixResult;
//        ParallelMatrixProduct mProduct = new ParallelMatrixProduct(4);
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                matrix1.setElement(i, j, (int) (Math.random() * 1000));
//                matrix2.setElement(i, j, (int) (Math.random() * 1000));
//            }
//        }
//        long time = System.currentTimeMillis();
//
//        matrixResult = mProduct.multiply(matrix1, matrix2);
//        matrixResult = mProduct.multiply(matrix1, matrix2);
//        matrixResult = mProduct.multiply(matrix1, matrix2);
//        matrixResult = mProduct.multiply(matrix1, matrix2);
//
//        System.out.println(System.currentTimeMillis() - time);
//        System.out.println(matrix1);
//        System.out.println(matrix2);

//        m3 = m1.product(m2);
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
        long time = System.currentTimeMillis();

        MergeSort.mergesort(arrayObject,4);

        System.out.println(System.currentTimeMillis() - time);

        System.out.println(Arrays.toString(arrayObject));

    }
}
