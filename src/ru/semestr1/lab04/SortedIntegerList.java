package ru.semestr1.lab04;

import java.util.LinkedList;
import java.util.ListIterator;

public class SortedIntegerList {
    private LinkedList<Integer> list;
    boolean IsDublicates;

    public SortedIntegerList(boolean IsDublicates) {
        this.IsDublicates = IsDublicates;
        list = new LinkedList<Integer>();
    }

    public SortedIntegerList() {
        // this(true);
        this.IsDublicates = true;
    }
    
    public void add(int value){
        if (list.isEmpty()){
            list.add(value);
        }
        else{
            ListIterator<Integer> iterator = list.listIterator();
            while (iterator.hasNext()){
                
            }
        }
    }

    public void remove(int value){

    }
}
