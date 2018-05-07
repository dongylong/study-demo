package com.datastructuress.algTest.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author dongyl
 * @date 10:16 12/28/17
 * @project push-all
 */
public class MyLinkedList implements Iterable<Integer> {
    private int theSize;
    int modCount = 0;
    Node beginMarker;
    Node endMarker;

    private static class Node {
        private Node pre;
        private Node next;
        private int val;

        public Node(int val, Node pre, Node next) {
            this.pre = pre;
            this.next = next;
            this.val = val;
        }
    }

    public MyLinkedList() {
        clear();
    }

    private void clear() {
        beginMarker = new Node(0, null, null);
        endMarker = new Node(0, beginMarker, null);
        beginMarker.next = endMarker.pre;
        theSize = 0;
        modCount++;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(int idx, int x) {
        addBefore(getNode(idx), x);
    }


    public int set(int idx, int newValue) {
        Node p = getNode(idx);
        int old = p.val;
        p.val = newValue;
        return old;
    }

    public int remove(int idx) {
        Node p = getNode(idx);
        return remove(p);
    }

    public int remove(Node p) {
        p.next.pre = p.pre;
        p.pre.next = p.next;

        theSize--;
        modCount--;
        return p.val;
    }

    private void addBefore(Node preNode, int x) {
        Node newNode = new Node(x, preNode.pre, preNode);
        newNode.pre.next = newNode;
        preNode.pre = newNode;
        theSize++;
        modCount++;
    }

    private Node getNode(int idx) {
        Node node = null;
        if (idx < 0 || idx > size()) {
            throw new IndexOutOfBoundsException();
        }
        if (idx < size() / 2) {
            node = beginMarker.next;
            for (int i = 0; i < idx; i++) {
                node = node.next;
            }
        }
        return node;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new LinkedListIterator();
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {

    }

    @Override
    public Spliterator<Integer> spliterator() {
        return null;
    }

    private class LinkedListIterator implements Iterator<Integer> {
        private Node current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public Integer next() {
            if (expectedModCount != modCount) {
                throw new java.util.ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int nextItem = current.val;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        @Override
        public void remove() {
            if (expectedModCount != modCount) {
                throw new java.util.ConcurrentModificationException();
            }
            if(!okToRemove){
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove(current);
            okToRemove = false;
            expectedModCount++;

        }

        @Override
        public void forEachRemaining(Consumer<? super Integer> action) {

        }
    }
}
