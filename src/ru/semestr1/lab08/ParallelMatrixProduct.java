package ru.semestr1.lab08;

import ru.semestr1.lab08.matrix.*;

// Реализовать класс ParallelMatrixProduct для многопоточного умножения матриц UsualMatrix. В конструкторе класс получает число потоков, которые будут использованы для перемножения (число потоков может быть меньше, чем число строк у первой матрицы).

public class ParallelMatrixProduct {
    private final Thread[] threads;

    public ParallelMatrixProduct(int threadsCount) {
        this.threads = new Thread[threadsCount];
    }

    public ParallelMatrixProduct() {
        this.threads = new Thread[Runtime.getRuntime().availableProcessors()];
        System.out.println("Number of threads: " + threads.length);
    }

    public UsualMatrix multiply(UsualMatrix firstMatrix, UsualMatrix secondMatrix) {
        int rows = firstMatrix.getRows();
        int columns = secondMatrix.getColumns();
        UsualMatrix result = new UsualMatrix(rows, columns);

        // int chunkSize = (rows + threads.length - 1) / threads.length;
        // for (int i = 0; i < rows; i += chunkSize) {
        //     int chunkRows = Math.min(chunkSize, rows - i);
        //     int threadIndex = i / chunkSize;
        //     threads[threadIndex] = new Thread(new MatrixMultiplier(firstMatrix, secondMatrix, result, i, chunkRows));
        //     threads[threadIndex].start();
        // }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                // handle exception
            }
        }

        return result;
    }

    // private record MatrixMultiplier(UsualMatrix firstMatrix,
    //                                 UsualMatrix secondMatrix,
    //                                 UsualMatrix result,
    //                                 int startRow,
    //                                 int chunkRows) implements Runnable {

    //     @Override
    //     public void run() {
    //         for (int i = startRow; i < startRow + chunkRows; i++) {
    //             for (int j = 0; j < secondMatrix.getColumns(); j++) {
    //                 int sum = 0;
    //                 for (int k = 0; k < firstMatrix.getColumns(); k++) {
    //                     sum += firstMatrix.getElement(i, k) * secondMatrix.getElement(k, j);
    //                 }
    //                 result.setElement(i, j, sum);
    //             }
    //         }
    //     }
    // }
}