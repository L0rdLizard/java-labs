package ru.semestr1.lab04;

public class Main4 {
    public static void main(String[] args) {
        SortedIntegerList list = new SortedIntegerList();
        list.remove(6);
        list.add(1);
        list.add(2);
        list.add(6);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(list);
        list.remove(6);
        System.out.println(list);
    }
}
