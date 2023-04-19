package ru.semestr1.lab08.matrix;

public interface IMatrix {
    int getRows();
    int getColumns();
    int getElement(int row, int column);
    void setElement(int row, int column, int value);
    String toString();
    boolean equals(Object obj);
}
