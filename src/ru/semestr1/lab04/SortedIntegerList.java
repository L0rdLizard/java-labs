package ru.semestr1.lab04;
import java.util.LinkedList;
import java.util.ListIterator;

public class SortedIntegerList {
    private LinkedList<Integer> list;
    boolean allowDublicates;

    public SortedIntegerList(boolean allowDublicates) {
        this.allowDublicates = allowDublicates;
        list = new LinkedList<Integer>();
    }

    public SortedIntegerList() {
        this(true);
        // this.allowDublicates = true;
    }
    
    public void add(int value)
    {
        if (list.isEmpty())
        {
            list.add(value);
        }
        else
        {
            ListIterator<Integer> iterator = list.listIterator();
            while (iterator.hasNext())
            {
                Integer current = iterator.next();

                if (current > value)
                {
                  iterator.previous();
                  iterator.add(value);
                  return;
                }
                if (current == value && !allowDublicates) {
                  return;
                }
            }
            iterator.add(value);
        }
    }

    public void remove(int value){
        if (list.isEmpty())
        {
            return;
        }
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext())
        {
            Integer current = iterator.next();
            if (current == value)
            {
                iterator.remove();
                return;
            }
        }
    }

    public boolean equals(SortedIntegerList other) {
        if (this.list.size() != other.list.size()) {
            return false;
        }
        ListIterator<Integer> iterator1 = this.list.listIterator();
        ListIterator<Integer> iterator2 = other.list.listIterator();
        while (iterator1.hasNext()) {
            if (iterator1.next() != iterator2.next()) {
                return false;
            }
        }
        return true;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext())
        {
            sb.append(iterator.next());
            if (iterator.hasNext())
            {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
