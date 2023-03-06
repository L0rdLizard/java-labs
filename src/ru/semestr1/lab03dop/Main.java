package ru.semestr1.lab03dop;

public class Main {
    public static void main(String[] args) {

        SquareMatrix mtest1 = new SquareMatrix(3);
        System.out.println("Test Squarematrix");
        System.out.println(mtest1);

        Matrix mtest2 = new Matrix(3);
        System.out.println("Test matrix");
        System.out.println(mtest2);

        SquareMatrix matrix1 = new SquareMatrix(2);
        SquareMatrix matrix2 = new SquareMatrix(2);

        matrix1.setElement(0, 0, 1);
        matrix1.setElement(0, 1, 1);
        matrix1.setElement(1, 0, 1);
        matrix1.setElement(1, 1, 1);

        matrix2.setElement(0, 0, 2);
        matrix2.setElement(0, 1, 2);
        matrix2.setElement(1, 0, 2);
        matrix2.setElement(1, 1, 2);

        System.out.println("matrix1");
        System.out.println(matrix1);

        System.out.println("matrix2");
        System.out.println(matrix2);

        SquareMatrix matrix3 = matrix1.sum(matrix2);

        System.out.println("matrix3 = matrix 1 + matrix 2");
        System.out.println(matrix3);

        SquareMatrix matrix4 = matrix1;
        System.out.println("matrix 4");
        System.out.println(matrix4);

        System.out.println("matrix 1 equals matrix 2: " + matrix1.equals(matrix2));
        System.out.println("matrix 1 equals matrix 4: " + matrix1.equals(matrix4));

        System.out.println();

        SquareMatrix matrix5 = new SquareMatrix(3);
        SquareMatrix matrix6 = new SquareMatrix(5);

        try {
            SquareMatrix matrix7 = matrix5.sum(matrix6);
            System.out.println(matrix7);
        } catch (MatrixException e) {
            System.out.println(e.getMessage());
        }

        try {
            SquareMatrix matrix7 = matrix5.sum(matrix5);
            System.out.println(matrix7.getElement(100, 50));
        } catch (MatrixException e) {
            System.out.println(e.getMessage());
        }
    }
}
