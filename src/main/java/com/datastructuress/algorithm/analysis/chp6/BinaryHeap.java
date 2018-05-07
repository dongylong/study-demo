package com.datastructuress.algorithm.analysis.chp6;

/**
 * @author dongyl
 * @date 21:11 1/26/18
 * @project study-demo
 */
public class BinaryHeap {
    private static final int DEFAULT_CAPACITY = 10;
    private int currentSize;
    private Integer[] array;

    public BinaryHeap() {

    }

    public BinaryHeap(int catacity) {
        currentSize = catacity;
    }

    public BinaryHeap(Integer[] items) {
        currentSize = items.length;
        array = (Integer[]) new Comparable[(currentSize + 2) * 11 / 10];
        int i = 1;
        for (Integer item : items) {
            array[i++] = item;
        }
        buildHeap();
    }

    public void insert(Integer x) {
        if (currentSize == array.length - 1) {
            enlargeArray(array.length * 2 + 1);
            int hole = ++currentSize;
            for (array[0] = x; x.compareTo(array[hole / 2]) < 0; hole /= 2) {
                array[hole] = array[hole / 2];
            }
            array[hole] = x;
        }

    }

    public Integer findMin() {
        return 0;
    }

    public Integer deleteMin() {
        if (isEmpty()) {
//            throw new UnderflowException();
        }
        Integer minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);
        return minItem;
    }

    public boolean isEmpty() {
        return false;
    }

    public void makeEmpty() {
    }

    private void percolateDown(int hole) {
        int child = 0;
        Integer tmp = array[hole];
        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            if (child != currentSize && array[child + 1].compareTo(array[child]) < 0) {
                child++;
            }
            if (array[child].compareTo(tmp) < 0) {
                array[hole] = array[child];
            } else {
                break;
            }
        }
        array[hole] = tmp;
    }

    private void buildHeap() {
        for (int i = currentSize; i > 0; i--) {
            percolateDown(i);
        }
    }

    private void enlargeArray(int newSize) {
    }
}
