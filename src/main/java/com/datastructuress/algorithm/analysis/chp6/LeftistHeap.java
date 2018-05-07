package com.datastructuress.algorithm.analysis.chp6;

/**
 * @author dongyl
 * @date 21:34 1/26/18
 * @project study-demo
 */
public class LeftistHeap<AnyType extends Comparable<? super AnyType>> {
    private class Node<Anytype> {
        AnyType element;
        Node<AnyType> left;
        Node<AnyType> right;
        int npl;

        public Node(AnyType theElement) {
            this(theElement, null, null);
        }

        public Node(AnyType theElement, Node<AnyType> lt, Node<AnyType> rt) {
            element = theElement;
            left = lt;
            right = rt;
            npl = 0;
        }
    }

    private Node<AnyType> root;

    public LeftistHeap() {
        root = null;
    }

    public LeftistHeap(Node<AnyType> root) {
        this.root = root;
    }

    public void merge(LeftistHeap<AnyType> rhs) {
        if (this == rhs) {
            return;
        }
        root = merge(root, rhs.root);
        rhs.root = null;
    }

    public void insert(AnyType x) {
        root = merge(new Node<>(x), root);
    }

    public AnyType findMin() {

        return null;
    }

    public AnyType deleteMin() {
        if(isEmpty()){
//            throw
        }
        AnyType minItem = root.element;
        root = merge(root.left,root.right);
        return minItem;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void makeEmpty() {
        root = null;
    }

    private Node<AnyType> merge(Node<AnyType> h1, Node<AnyType> h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }
        if (h1.element.compareTo(h2.element) < 0) {
            return merge1(h1, h2);
        } else {
            return merge1(h2, h1);
        }
    }

    private Node<AnyType> merge1(Node<AnyType> h1, Node<AnyType> h2) {
        if (h1.left == null) {
            h1.left = h2;
        } else {
            h1.right = merge(h1.right, h2);
            if (h1.left.npl < h1.right.npl) {
                swapChildren(h1);
            }
            h1.npl = h1.right.npl + 1;
        }
        return h1;
    }

    private void swapChildren(Node<AnyType> t) {

    }
}
