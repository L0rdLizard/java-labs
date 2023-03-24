package ru.semestr1.lab05.matrices;

import java.util.*;

public class SparseMatrix2 extends Matrix{
    protected LinkedList<SparseMatrixElement2>[] matrix;
    protected int rows;
    protected int columns;


    public SparseMatrix2(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new LinkedList[rows];

        for (int i = 0; i < rows; i++) {
            matrix[i] = new LinkedList<>();
        }
    }

    public SparseMatrix2(int size){
        this(size, size);
    }

    protected SparseMatrix2 createMatrix(int rows, int columns) {
        return new SparseMatrix2(rows, columns);
    }
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getElement(int row, int column) {
        for (SparseMatrixElement2 element : matrix[row]) {
            if (element.column == column) {
                return element.value;
            }
        }
        return 0;
    }

    public void setElement(int rowIndex, int columnIndex, int value) {
        if (value == 0) {
            removeElement(rowIndex, columnIndex);
        } else {
            setValue(rowIndex, columnIndex, value);
        }
    }
    private void setValue(int row, int column, int value) {
        for (SparseMatrixElement2 element : matrix[row]) {
            if (element.column == column) {
                element.value = value;
                return;
            }
        }
        matrix[row].add(new SparseMatrixElement2(column, value));
    }

    private void removeElement(int row, int column) {
        Iterator<SparseMatrixElement2> iterator = matrix[row].iterator();
        while (iterator.hasNext()) {
            SparseMatrixElement2 element = iterator.next();
            if (element.column == column) {
                iterator.remove();
                return;
            }
        }
    }
    public SparseMatrix2 add(final SparseMatrix2 matrix){
        return (SparseMatrix2) super.add(matrix);
    }

    public SparseMatrix2 product(final SparseMatrix2 matrix){
        return (SparseMatrix2) super.product(matrix);
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

    private static class SparseMatrixElement2 {
        int column;
        int value;

        SparseMatrixElement2(int columnIndex, int value) {
            this.column = columnIndex;
            this.value = value;
        }
    }
}
