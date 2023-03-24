package ru.semestr1.lab05;

import ru.semestr1.lab05.matrices.SparseMatrix2;

public class Main5 {
    public static void main(String[] args) {

        SparseMatrix2 m1 = new SparseMatrix2(16);
        SparseMatrix2 m2 = new SparseMatrix2(16);

        for (int i = 0; i < 1000; i++) {
//            m1.setElement((int) (Math.random() * 1000), (int) (Math.random() * 1000), (int) (Math.random() * 1000));
//            m2.setElement((int) (Math.random() * 1000), (int) (Math.random() * 1000), (int) (Math.random() * 1000));
            m1.setElement((int) (Math.random() * 16), (int) (Math.random() * 16), (int) (Math.random() * 9));
            m2.setElement((int) (Math.random() * 16), (int) (Math.random() * 16), (int) (Math.random() * 9));
        }
        System.out.println(m1);
        System.out.println(m2);
        m1 = m1.add(m2);
//        m1 = m1.product(m2);
        System.out.println(m1);


    }
}
