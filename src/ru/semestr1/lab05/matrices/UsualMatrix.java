package ru.semestr1.lab05.matrices;

public class UsualMatrix extends Matrix {
    protected int matrix[][];
    protected int rows;
    protected int columns;

    public UsualMatrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        matrix = new int[rows][columns];
    }

    public UsualMatrix(int size){
        this(size, size);
    }

    public UsualMatrix(UsualMatrix matrix) {
        this.matrix = matrix.getMatrix();
        this.rows = matrix.getRows();
        this.columns = matrix.getColumns();
    }

    protected UsualMatrix createMatrix(int rows, int columns) {
        return new UsualMatrix(rows, columns);
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
        matrix[row][column] = value;
    }

    public UsualMatrix add(final UsualMatrix matrix){
        return (UsualMatrix) super.add(matrix);
    }

    public UsualMatrix product(final UsualMatrix matrix){
        return (UsualMatrix) super.product(matrix);
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
