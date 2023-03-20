package ru.semestr1.lab03dop;

public class PartMatrix extends Matrix {
    Matrix part;
    //левая и правая половина матрицы всегда равны и отзеркалены
    
    public PartMatrix(int rows, int columns) {
        if (rows < 2 || columns < 2 || rows % 2 != 0 || columns % 2 != 0) {
            throw new MatrixException("Size must be greater than 1");
        }
        this.rows = rows;
        this.columns = columns;
        this.part = new Matrix(rows, columns / 2);
    }

    public PartMatrix(int size) {
        this(size, size);
    }

    public void setElement(int row, int column, int value) {
        if (row < 0 || row >= this.rows || column < 0 || column >= this.columns) {
            throw new MatrixException("Index out of range");
        }
        if (column < this.columns / 2) {
            this.part.setElement(row, column, value);
        } else {
            this.part.setElement(row, this.columns - column - 1, value);
        }
    }

    public int getElement(int row, int column) {
        if (row < 0 || row >= this.rows || column < 0 || column >= this.columns) {
            throw new MatrixException("Index out of range");
        }
        if (column < this.columns / 2) {
            return this.part.getElement(row, column);
        } else {
            return this.part.getElement(row, this.columns - column - 1);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                result.append(this.getElement(i, j)).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
