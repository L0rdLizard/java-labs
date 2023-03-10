package ru.semestr1.lab01;

public class Int {
    private int value;

    public Int() {
        this.value = 0;
    }

    public Int(int value) {
        this.value = value;
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public void add(Int other) {
        this.value += other.value;
    }

    public void sub(Int other) {
        this.value -= other.value;
    }

    public void increment() {
        this.value++;
    }

    public void decrement() {
        this.value--;
    }
}
