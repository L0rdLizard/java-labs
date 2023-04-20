package ru.semestr1.lab05;

import ru.semestr1.lab05.matrices.SparseMatrix2;
import ru.semestr1.lab05.matrices.SquareMatrix;
import ru.semestr1.lab05.matrices.UsualMatrix;

public class Main5 {
    public static void main(String[] args) {

//         SparseMatrix2 sparse1 = new SparseMatrix2(1000);
//         SparseMatrix2 sparse2 = new SparseMatrix2(1000);
//         UsualMatrix usual1 = new UsualMatrix(1000);
//         UsualMatrix usual2 = new UsualMatrix(1000);
//         double num1;
//         double num2;
//         double num3;
//         for (int i = 0; i < 1000; i++) {
//              m1.setElement((int) (Math.random() * 1000), (int) (Math.random() * 1000),
//                      (int) (Math.random() * 1000));
//              m2.setElement((int) (Math.random() * 1000), (int) (Math.random() * 1000),
//                      (int) (Math.random() * 1000));
//             num1 = Math.random() * 1000;
//             num2 = Math.random() * 1000;
//             num3 = Math.random() * 1000;
//             sparse1.setElement((int) num1, (int) num2, (int) num3);
//             sparse2.setElement((int) num1, (int) num2, (int) num3);
//             usual1.setElement((int) num1, (int) num2, (int) num3);
//             usual2.setElement((int) num1, (int) num2, (int) num3);
        // }
        // SparseMatrix2 resultSparse = sparse1.product(sparse2);
        // UsualMatrix resultUsual = usual1.product(usual2);
        // System.out.println(resultSparse);
        // System.out.println();
        // System.out.println();
        // System.out.println();
        // System.out.println(resultUsual);
        //
        // SparseMatrix2 m4 = m1.product(m2);
        // System.out.println(m4);

        // UsualMatrix m1 = new UsualMatrix(3);
        // SquareMatrix m2 = new SquareMatrix(3);
        // for (int i = 0; i < 9; i++) {
        // m1.setElement((int) (Math.random() * 3), (int) (Math.random() * 3), (int)
        // (Math.random() * 9));
        // m2.setElement((int) (Math.random() * 3), (int) (Math.random() * 3), (int)
        // (Math.random() * 9));
        // }
        // System.out.println(m1);
        // System.out.println(m2);
        // UsualMatrix m3 = m1.add(m2);
        // System.out.println(m3);
        // UsualMatrix m4 = m1.product(m2);
        // System.out.println(m4);


        // UsualMatrix m1 = new UsualMatrix(3);
        // SquareMatrix m2 = new SquareMatrix(3);
        // m1.setElement(0, 0, 1);
        // m1.setElement(0, 1, 1);

        // m2.setElement(1, 0, 1);
        // m2.setElement(1, 1, 1);

        // UsualMatrix m3 = m1.add(m2);
        // System.out.println(m3);


        SparseMatrix2 m1 = new SparseMatrix2(3);
        SparseMatrix2 m2 = new SparseMatrix2(4);
        m1.setElement(0, 0, 1);
        m1.setElement(1, 1, 1);
        m2.setElement(2, 2, 1);
        System.out.println(m1.add(m2));
    }
}
