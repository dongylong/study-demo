package com.datastructuress.algorithm.analysis.chp6;

/**
 * @author dongyl
 * @date 21:57 1/26/18
 * @project study-demo
 */
public class BinomialQueue<AnyType extends Comparable<? super AnyType>> {
    public BinomialQueue() {
    }

    public BinomialQueue(AnyType item) {

    }

    public void merge(BinomialQueue<AnyType> rhs) {
        if (this == rhs) {
            return;
        }
        currentSize = rhs.currentSize;
        if (currentSize > capacity()) {
            int maxLength = Math.max(theTrees.length, rhs.theTrees.length);
            expandTheTrees(maxLength + 1);
        }
        Node<AnyType> carry = null;
        for (int i = 0,j=1; i < currentSize; i++,j*=2) {
            Node<AnyType> t1 = theTrees[i];
        }
    }

    public void insert(AnyType x) {
        merge(new BinomialQueue<>(x));
    }

    public AnyType findMin() {

        return null;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void makeEmpty() {
    }


    private static final int DEFAULT_TREES = 1;
    private int currentSize;
    Node<AnyType>[] theTrees;


    private class Node<AnyType> {
        AnyType element;
        Node<AnyType> leftChild;
        Node<AnyType> nextSibling;

        Node(AnyType theElement) {
            this(theElement, null, null);
        }

        Node(AnyType theElement, Node<AnyType> lt, Node<AnyType> nt) {
            element = theElement;
            leftChild = lt;
            nextSibling = nt;
        }
    }

    private void expandTheTrees(int newNumtrees) {

    }

    /**
     * return the result of merging equal-sized t1 and t2
     *
     * @param t1
     * @param t2
     * @return
     */
    private Node<AnyType> combineTrees(Node<AnyType> t1, Node<AnyType> t2) {
        if (t1.element.compareTo(t2.element) > 0) {
            return combineTrees(t2, t1);
        }
        t2.nextSibling = t1.leftChild;
        t1.leftChild = t2;
        return t1;
    }

    private int capacity() {
        return (1 << theTrees.length) - 1;
    }

    private int findMinIndex() {

        return 0;
    }

}
