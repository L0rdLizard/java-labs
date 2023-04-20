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

    SortedIntegerList cartesianProduct(SortedIntegerList other) {
        SortedIntegerList result = new SortedIntegerList();
        ListIterator<Integer> iterator1 = this.list.listIterator();
        ListIterator<Integer> iterator2 = other.list.listIterator();
        while (iterator1.hasNext()) {
            while (iterator2.hasNext()) {
                result.add(iterator1.next() * iterator2.next());
            }
        }
        return result;
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


    // то же самое только без итератора
    public void CombSort2() {
        int gap = list.size();
        boolean swapped = true;
        while (gap > 1 || swapped) {
            if (gap > 1) {
                gap = (int) (gap / 1.247);
            }
            swapped = false;
            for (int i = 0; i < list.size() - gap; i++) {
                Integer current = list.get(i);
                Integer next = list.get(i + gap);
                if (current > next) {
                    list.set(i, next);
                    list.set(i + gap, current);
                    swapped = true;
                }
            }
        }
    }


}
