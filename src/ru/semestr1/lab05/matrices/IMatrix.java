package ru.semestr1.lab05.matrices;

public interface IMatrix {
    int getRows();
    int getColumns();
    int getElement(int row, int column);
    void setElement(int row, int column, int value);
    String toString();
    boolean equals(Object obj);
}
