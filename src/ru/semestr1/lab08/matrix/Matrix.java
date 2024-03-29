package ru.semestr1.lab08.matrix;

public abstract class Matrix implements IMatrix {
    protected abstract ru.semestr1.lab05.matrices.Matrix createMatrix(int rows, int cols);

    public ru.semestr1.lab05.matrices.Matrix add(ru.semestr1.lab05.matrices.Matrix other) {

        if (this.getRows() != other.getRows() || this.getColumns() != other.getColumns()) {
            throw new MatrixException("Matrices sizes are not equal");
        }

        ru.semestr1.lab05.matrices.Matrix result = createMatrix(getRows(), getColumns());
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                result.setElement(i, j, getElement(i, j) + other.getElement(i, j));
            }
        }
        return result;
    }

    public ru.semestr1.lab05.matrices.Matrix product(ru.semestr1.lab05.matrices.Matrix other) {
        if (this.getRows() != other.getRows() || this.getColumns() != other.getColumns()) {
            throw new MatrixException("Matrices sizes are not equal");
        }

        ru.semestr1.lab05.matrices.Matrix result = createMatrix(this.getRows(), other.getColumns());

        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < other.getColumns(); j++) {
                int sum = 0;
                for (int k = 0; k < getColumns(); k++) {
                    sum += getElement(i, k) * other.getElement(k, j);
                }
                result.setElement(i, j, sum);
            }
        }
        return result;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                result.append(this.getElement(j, i)).append(" ");
            }
            result.append("\n");
        }

        return result.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        ru.semestr1.lab05.matrices.Matrix matrix = (ru.semestr1.lab05.matrices.Matrix) obj;

        if (this.getRows() != matrix.getRows() || this.getColumns() != matrix.getColumns()) {
            return false;
        }

        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                if (this.getElement(i, j) != matrix.getElement(j, i)) {
                    return false;
                }
            }
        }

        return true;
    }
}
