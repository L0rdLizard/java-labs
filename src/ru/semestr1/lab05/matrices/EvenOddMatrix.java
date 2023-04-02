package ru.semestr1.lab05.matrices;

public class EvenOddMatrix extends Matrix{
    //при аргументе true - матрица может хранить только чётные значения, при false - нечётные
    protected boolean even;
    protected int matrix[][];
    protected int rows;
    protected int columns;

    public EvenOddMatrix(int rows, int columns, boolean even) {
        this.rows = rows;
        this.columns = columns;
        this.even = even;
        matrix = new int[rows][columns];
    }

    public EvenOddMatrix(int size, boolean even){
        this(size, size, even);
    }


    protected EvenOddMatrix createMatrix(int rows, int columns) {
        return new EvenOddMatrix(rows, columns, even);
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getElement(int row, int column) {
        return matrix[row][column];
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setElement(final int row, final int column, int value) {
        if (even) {
            if (value % 2 == 0) {
                matrix[row][column] = value;
            } else {
                throw new MatrixException("Matrix can contain only even values");
            }
        } else {
            if (value % 2 != 0) {
                matrix[row][column] = value;
            } else {
                throw new MatrixException("Matrix can contain only odd values");
            }
        }
    }

    public EvenOddMatrix add(final EvenOddMatrix matrix){
        return (EvenOddMatrix) super.add(matrix);
    }

    public EvenOddMatrix product(final EvenOddMatrix matrix){
        return (EvenOddMatrix) super.product(matrix);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                result.append(this.getElement(j, i)).append(" ");
            }
            result.append("\n");
        }

        return result.toString();
    }
}
