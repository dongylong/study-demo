package com.noriental.alg.list;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author dongyl
 * @date 10:16 12/28/17
 * @project push-all
 */
public class MyArrayList implements Iterable<Integer> {
    private static final int CAPACITY_NUM = 10;

    private int theSize;
    private int[] theItems;

    public int getTheSize() {
        return theSize;
    }

    public void setTheSize(int theSize) {
        this.theSize = theSize;
    }

    public int[] getTheItems() {
        return theItems;
    }

    public void setTheItems(int[] theItems) {
        this.theItems = theItems;
    }

    public MyArrayList() {
        if (theSize != 0 || theItems != null) {
            clear();
        }
    }

    public int find(int idx) {
        if (idx < 0 || idx >= theSize) {
            return 0;
        } else {
            return theItems[idx];
        }
    }

    private void clear() {
        setTheSize(0);
        ensureCapacity(CAPACITY_NUM);
    }

    private void ensureCapacity(int newCapacityNum) {
        int[] old = theItems;
        if (newCapacityNum < getTheSize()) {
            theItems = new int[theItems.length + CAPACITY_NUM];
        } else {
            theItems = new int[CAPACITY_NUM];
        }
        if (old != null) {
            for (int i = 0; i < old.length; i++) {
                theItems[i] = old[i];
            }
        }
    }

    public boolean add(int x) {
        add(getTheSize(), x);
        return true;
    }

    public void add(int idx, int x) {

        if (getTheItems() == null || getTheItems().length >= getTheSize()) {
            ensureCapacity(CAPACITY_NUM);
        }
        for (int i = getTheSize() - 1; i > idx; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[idx] = x;
    }

    public void remove(int idx) {

        if (idx > theSize) {
            return;
        } else {
            for (int i = idx; i < theSize - 1; i++) {
                theItems[i] = theItems[i + 1];
            }
        }
        theSize--;
    }

    public void display() {
        for (int i = 0; i < theSize - 1; i++) {
            System.out.print(theItems[i] + " ");
        }
        System.out.println();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new ArrayListIterator();
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {

    }

    @Override
    public Spliterator<Integer> spliterator() {
        return null;
    }

    private class ArrayListIterator implements Iterator<Integer> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < getTheSize();
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                return theItems[current];
            }else{
                throw new java.util.NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }

        @Override
        public void forEachRemaining(Consumer<? super Integer> action) {

        }
    }
}
