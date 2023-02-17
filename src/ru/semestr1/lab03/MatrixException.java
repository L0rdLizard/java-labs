package ru.semestr1.lab03;


class MatrixException extends RuntimeException {
  public MatrixException(String message) {
    super("MatrixException: " + message);
  }
}