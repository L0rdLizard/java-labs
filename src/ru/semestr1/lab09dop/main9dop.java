package ru.semestr1.lab09dop;


import java.util.Scanner;

public class main9dop {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество компьютеров в кафе");
        int n = in.nextInt();
        System.out.println("Введите количество посетителей кафе");
        int m = in.nextInt();
        Cafe cafe = new Cafe(n);
        for (int i = 0; i < m; i++) {
            new Tourist(cafe, i).start();
        }
    }
}

class Cafe {
    private int n;
    private int count = 0;

    public Cafe(int n) {
        this.n = n;
    }

    public synchronized void comeIn(int id) {
        while (count == n) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
        System.out.println("Tourist " + id + " is online");
    }

    public synchronized void comeOut(int id, int time) {
        count--;
        System.out.println("Tourist " + id + " is done, having spent " + time + "min online");
        notifyAll();
    }
}

class Tourist extends Thread {
    private Cafe cafe;
    private int id;

    public Tourist(Cafe cafe, int id) {
        this.cafe = cafe;
        this.id = id;
    }

    @Override
    public void run() {
        int time = (int) (Math.random() * 105 + 15);
        cafe.comeIn(id);
        try {
            Thread.sleep(time * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cafe.comeOut(id, time);
    }
}

