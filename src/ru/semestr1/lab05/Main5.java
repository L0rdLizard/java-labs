package ru.semestr1.lab05;

// import ru.semestr1.lab01.Int;
import ru.semestr1.lab05.matrices.SparseMatrix;
import ru.semestr1.lab05.matrices.UsualMatrix;
// import java.lang.Math;

public class Main5 {
    public static void main(String[] args) {

        SparseMatrix m1 = new SparseMatrix(1000);
        SparseMatrix m2 = new SparseMatrix(1000);

        for (int i = 0; i < 1000; i++) {
            m1.setElement((int) (Math.random() * 1000), (int) (Math.random() * 1000), (int) (Math.random() * 1000));
            m2.setElement((int) (Math.random() * 1000), (int) (Math.random() * 1000), (int) (Math.random() * 1000));
        }
        m1 = m1.add(m2);
//        m1 = m1.product(m2);
        System.out.println(m1);


    }
}
