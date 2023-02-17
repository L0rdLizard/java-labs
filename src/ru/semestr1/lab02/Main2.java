package ru.semestr1.lab02;

public class Main2 {
    public static void main(String[] args) {
        Matrix inputMatrix = new Matrix(2);

        inputMatrix.setElement(0, 0, 1);
        inputMatrix.setElement(0, 1, 1);
        inputMatrix.setElement(1, 0, 1);
        inputMatrix.setElement(1, 1, 0);

        System.out.println("Power 1:");
        System.out.println(inputMatrix);
        
        Matrix matrix = inputMatrix;
        for (int i = 2; i <= 10; i++) {
            System.out.println("Power " + i + ":");

            // System.out.println("input matrix:");
            // System.out.println(inputMatrix);
            // System.out.println("matrix:");
            // System.out.println(matrix);

            matrix = matrix.product(inputMatrix);
            System.out.println(matrix);
        }

        Matrix test = new Matrix(3);
        System.out.println("test = ");
        System.out.println(test);

        Matrix a = new Matrix(3);
        a.setElement(0, 1, 1);
        a.setElement(0, 2, 1);
        a.setElement(1, 0, 1);
        a.setElement(1, 2, 1);
        a.setElement(2, 1, 1);
        
        System.out.println("a = ");
        System.out.println(a);

        Matrix b = new Matrix(3);
        b.setElement(0, 1, 1);
        b.setElement(1, 0, 2);
        b.setElement(1, 2, 3);
        b.setElement(2, 1, 1);
        System.out.println("b = ");
        System.out.println(b);
        System.out.println();

        Matrix c = a.sum(b);
        System.out.println("c = a + b = ");
        System.out.println(c);
        System.out.println();

        Matrix d = a.product(b);
        System.out.println("d = a * b = ");
        System.out.println(d);
        System.out.println();
    }
}
