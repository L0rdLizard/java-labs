package ru.semestr1.lab2;

import java.util.Arrays;

public class Matrix {
    private int[][] matrix;
    private int size;

    public Matrix() {
        this.size = 0;
        this.matrix = new int[0][0];
    }

    public Matrix(int size) {
        this.size = size;
        this.matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            this.matrix[i][i] = 1;
        }
    }

    // public Matrix(Matrix other) {
    //     this.size = other.size;
    //     this.matrix = new int[this.size][this.size];
    //     for (int i = 0; i < this.size; i++) {
    //         for (int j = 0; j < this.size; j++) {
    //             this.matrix[i][j] = other.matrix[i][j];
    //         }
    //     }
    // }

    public void setElement(int row, int col, int value) {
        this.matrix[row][col] = value;
    }

    public int getElement(int row, int col) {
        return this.matrix[row][col];
    }

    public Matrix sum(Matrix other) {
        Matrix result = new Matrix(this.size);
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                result.setElement(i, j, this.getElement(i, j) + other.getElement(i, j));
            }
        }
        return result;
    }

    public Matrix product(Matrix other) {
        Matrix result;
        result = new Matrix(this.size);
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                result.setElement(i, j, 0);
            }
        }
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                for (int k = 0; k < this.size; k++) {
                    // result.setElement(i, j, result.getElement(i, j) + this.getElement(i, k) * other.getElement(k, j));
                    result.matrix[i][j] += this.matrix[i][k] * other.matrix[k][j];
                }
            }
        }
        return result;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int[] row : this.matrix) {
            builder.append(Arrays.toString(row));
            builder.append("\n");
        }

        return builder.toString();
    }

}
