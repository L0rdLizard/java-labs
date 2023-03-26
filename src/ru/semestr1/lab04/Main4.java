package ru.semestr1.lab04;

public class Main4 {
    public static void main(String[] args) {
        // SortedIntegerList list = new SortedIntegerList(false);
        // list.remove(6);
        // list.add(1);
        // list.add(2);
        // list.add(6);
        // list.add(4);
        // list.add(5);
        // list.add(6);
        // System.out.println(list);
        // list.remove(6);
        // System.out.println(list);
        SortedIntegerList list1 = new SortedIntegerList(true);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        SortedIntegerList list2 = list1;

        boolean test = list1.equals(list2);
        System.out.println(test);

        SortedIntegerList listresult = list1.cartesianProduct(list2);
        System.out.println(listresult);

//        list1.add(4);
//        list1.add(5);

//        SortedIntegerList list2 = list1;
//
//        System.out.println(listresult);
//        System.out.println(list1);
//        System.out.println(list2);
//
//        SortedIntegerList listresult = list1.cartesianProduct(list2);
    }
}
