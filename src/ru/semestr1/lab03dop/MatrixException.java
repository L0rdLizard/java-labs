package ru.semestr1.lab03dop;


class MatrixException extends RuntimeException {
  public MatrixException(String message) {
    super("MatrixException: " + message);
  }
}

class SumMatrixException extends MatrixException {
  public SumMatrixException(String message) {
    super("SumMatrixException: " + message);
  }
}

class ProductMatrixException extends MatrixException {
  public ProductMatrixException(String message) {
    super("ProductMatrixException: " + message);
  }
}

