package ru.semestr1.lab05.matrices;

public class SquareMatrix extends UsualMatrix {
    public SquareMatrix(int size) {
        super(size, size);
    }

    public SquareMatrix(UsualMatrix matrix) {
        super(matrix);
        if (matrix.getRows() != matrix.getColumns()) {
            throw new MatrixException("Matrix is not square");
        }
    }

    public SquareMatrix (SquareMatrix matrix) {
        super(matrix);
    }

    public SquareMatrix add(final SquareMatrix matrix) {
        return (SquareMatrix) super.add(matrix);
    }

    public SquareMatrix product(final SquareMatrix matrix) {
        return (SquareMatrix) super.product(matrix);
    }

}
