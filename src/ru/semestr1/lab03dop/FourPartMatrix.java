package ru.semestr1.lab03dop;

// Создать класс FourPartMatrix, расширяющий класс SquareMatrix
// Вторая четвертинка равна четвертой, первая четвертинка равна третьей
// Добавить MatrixSumException, MatrixProductException

public class FourPartMatrix extends SquareMatrix {
  private SquareMatrix up, down;

  public FourPartMatrix() {
    this(2);
  }

  public FourPartMatrix(int size) {
    if (size < 2 || size % 2 != 0) {
      throw new MatrixException("Size must be greater than 1");
    }
    this.rows = size;
    this.columns = size;
    this.up = new SquareMatrix(size / 2);
    this.down = new SquareMatrix(size / 2);
  }

  // get element
  public int getElement(int row, int column) {
    if (row < 0 || row >= this.rows || column < 0 || column >= this.columns) {
      throw new MatrixException("Index out of range");
    }

    if (row < this.rows / 2) {
      return this.up.getElement(row, column % (this.columns / 2));
    } else {
      return this.down.getElement(row - (this.rows / 2), column % (this.columns / 2));
    }
  }

  public void setElement(int row, int column, int value) {
    if (row < 0 || row >= this.rows || column < 0 || column >= this.columns) {
      throw new MatrixException("Index out of range");
    }

    if (row < this.rows / 2) {
      this.up.setElement(row, column % (this.columns / 2), value);
    } else {
      this.down.setElement(row - (this.rows / 2), column % (this.columns / 2), value);
    }
  }

}
