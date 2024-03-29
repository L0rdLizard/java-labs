package ru.semestr1.lab05.matrices;

public class SparseMatrixElement{
    private final int row;
    private final int column;
    private int value;

    public SparseMatrixElement(final int row, final int column, int value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
