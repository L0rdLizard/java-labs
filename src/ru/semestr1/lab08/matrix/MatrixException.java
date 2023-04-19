package ru.semestr1.lab08.matrix;

class MatrixException extends RuntimeException {
    public MatrixException(String message) {
        super("MatrixException: " + message);
    }
}