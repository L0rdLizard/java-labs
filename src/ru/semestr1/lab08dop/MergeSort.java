package ru.semestr1.lab08dop;
import java.util.Comparator;
public class MergeSort {
    public static <T> void mergesort(T[] array, int treadNum, Comparator<T> comparator) {
        int chunkSize = (array.length + treadNum - 1) / treadNum;
        Thread[] threads = new Thread[treadNum];
        for (int i = 0; i < array.length; i += chunkSize) {
            int chunkRows = Math.min(chunkSize, array.length - i);
            int threadIndex = i / chunkSize;
            threads[threadIndex] = new Thread(new MergeSorter<>(array, comparator , i, chunkRows));
            threads[threadIndex].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                //
            }
        }
    }



    private static  class MergeSorter <T> implements Runnable {
        private final T[] array;
        private final int startRow;
        private final int chunkRows;
        private final Comparator<T> comporator;

        public MergeSorter(T[] array, Comparator<T> comparator, int startRow, int chunkRows) {
            this.array = array;
            this.startRow = startRow;
            this.chunkRows = chunkRows;
            this.comporator = comparator;
        }

        @Override
        public void run() {
            for (int i = startRow; i < startRow + chunkRows; i++) {
                for (int j = 0; j < array.length; j++) {
                    if (i < j) {
                        if (comporator.compare(array[i], array[j]) > 0) {
                            T temp = array[i];
                            array[i] = array[j];
                            array[j] = temp;
                        }
                    }
                }
            }
        }
    }
}
