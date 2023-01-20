package ru.semestr1.lab1;

public class Int {
    private int value;

    public Int() {
        this.value = 0;
    }

    public Int(int value) {
        this.value = value;
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

    public void tostring() {
        System.out.println(this.value);
    }
}
