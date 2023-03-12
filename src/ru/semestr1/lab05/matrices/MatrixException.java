package ru.semestr1.lab05.matrices;

class MatrixException extends RuntimeException {
    public MatrixException(String message) {
        super("MatrixException: " + message);
    }
}
