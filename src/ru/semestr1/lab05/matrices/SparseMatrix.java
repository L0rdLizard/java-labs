package ru.semestr1.lab05.matrices;

import java.util.LinkedList;



public class SparseMatrix extends Matrix{
    protected LinkedList<SparseMatrixElement> matrix;
    protected int rows;
    protected int columns;

    public SparseMatrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        matrix = new LinkedList<SparseMatrixElement>();
    }

    public SparseMatrix(SparseMatrix matrix) {
        this.matrix = matrix.getMatrix();
        this.rows = matrix.getRows();
        this.columns = matrix.getColumns();
    }

    public SparseMatrix(int size){
        this(size, size);
    }

    protected SparseMatrix createMatrix(int rows, int columns) {
        return new SparseMatrix(rows, columns);
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getElement(int row, int column) {
        for (SparseMatrixElement element : matrix) {
            if (element.getRow() == row && element.getColumn() == column) {
                return element.getValue();
            }
        }
        return 0;
    }

    public LinkedList<SparseMatrixElement> getMatrix() {
        return matrix;
    }

    public void setElement(final int row, final int column, int value) {
        for (SparseMatrixElement element : matrix) {
            if (element.getRow() == row && element.getColumn() == column) {
                element.setValue(value);
                return;
            }
        }
        matrix.add(new SparseMatrixElement(row, column, value));
    }

    public SparseMatrix add(final SparseMatrix matrix){
        return (SparseMatrix) super.add(matrix);
    }

    public SparseMatrix product(final SparseMatrix matrix){
        return (SparseMatrix) super.product(matrix);
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
