package ru.semestr1.lab08;

import ru.semestr1.lab08.matrix.UsualMatrix;

public class Main8 {
    public static void main(String[] args) {
        UsualMatrix m1 = new UsualMatrix(100);
        UsualMatrix m2 = new UsualMatrix(100);
        UsualMatrix m3;
        ParallelMatrixProduct mProduct = new ParallelMatrixProduct();
        for (int i = 0; i < 1000; i++) {
            m1.setElement((int) (Math.random() * 100), (int) (Math.random() * 100), (int) (Math.random() * 100));
            m2.setElement((int) (Math.random() * 100), (int) (Math.random() * 100), (int) (Math.random() * 100));
        }
        m3 = mProduct.multiply(m1,m2);
        System.out.println(m3);
    }
}
