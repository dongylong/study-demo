package com.noriental.book3;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author dongyl
 * @date 14:10 2/20/18
 * @project study-demo
 */
public class ConcurrentStack<E> {
    AtomicReference<Node<E>> head = new AtomicReference<>();

    public void push(E item) {
        Node<E> newHead = new Node<E>(item);
        Node<E> oldHead;
        do {
            oldHead = head.get();
            newHead.next = oldHead;
        } while (!head.compareAndSet(oldHead, newHead));
    }

    public E pop() {
        Node<E> newHead;
        Node<E> oldHead;
        do {
            oldHead = head.get();
            if (oldHead == null) {
                return null;
            }
            newHead = oldHead.next;
        } while (!head.compareAndSet(oldHead, newHead));
        return oldHead.item;
    }

    static class Node<E> {
        final E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }
    }

}
