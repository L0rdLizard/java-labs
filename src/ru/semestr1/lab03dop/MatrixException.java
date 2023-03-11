package ru.semestr1.lab03dop;

class MatrixException extends RuntimeException {
    public MatrixException(String message) {
        super("MatrixException: " + message);
    }
}

class SumMatrixException extends RuntimeException {
    
    public SumMatrixException(String message) {
        super("SumMatrixException: " + message);
    }
}

class ProductMatrixException extends RuntimeException {
    public ProductMatrixException(String message) {
        super("ProductMatrixException: " + message);
    }
}
