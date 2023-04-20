package ru.semestr1.lab08;
// void mergesort(Object array[], int treadNum)

    // написать реализацию алгоритма сортировки слиянием с использованием нескольких потоков
// в качестве параметра метод получает число потоков, которые будут использованы для сортировки

public class MergeSort {
    public static void mergesort(Object array[], int treadNum) {
        int chunkSize = (array.length + treadNum - 1) / treadNum;
        Thread[] threads = new Thread[treadNum];
        for (int i = 0; i < array.length; i += chunkSize) {
            int chunkRows = Math.min(chunkSize, array.length - i);
            int threadIndex = i / chunkSize;
            threads[threadIndex] = new Thread(new MergeSorter(array, i, chunkRows));
            threads[threadIndex].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                // handle exception
            }
        }
    }

    private static class MergeSorter implements Runnable {
        private final Object[] array;
        private final int startRow;
        private final int chunkRows;

        public MergeSorter(Object[] array, int startRow, int chunkRows) {
            this.array = array;
            this.startRow = startRow;
            this.chunkRows = chunkRows;
        }

        @Override
        public void run() {
            for (int i = startRow; i < startRow + chunkRows; i++) {
                for (int j = 0; j < array.length; j++) {
                    if (i < j) {
                        if (array[i].toString().compareTo(array[j].toString()) > 0) {
                            Object temp = array[i];
                            array[i] = array[j];
                            array[j] = temp;
                        }
                    }
                }
            }
        }
    }

}