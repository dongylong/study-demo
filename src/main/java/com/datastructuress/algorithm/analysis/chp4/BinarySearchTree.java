package com.datastructuress.algorithm.analysis.chp4;

/**
 * @author dongyl
 * @date 10:23 12/30/17
 * @project study-demo
 */
public class BinarySearchTree {
    private BinaryNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return isEmpty(root);
    }

    public boolean isEmpty(BinaryNode t) {
        return t == null;
    }

    public void insert(Integer x) {
        root = insert(x, root);
    }

    private BinaryNode insert(Integer x, BinaryNode t) {
        if (t == null) {
            return new BinaryNode(x);
        }
        int compareResult = x.compareTo(t.getElement());
        if (compareResult < 0) {
            t.setLeft(insert(x, t.getLeft()));
        } else if (compareResult > 0) {
            t.setRight(insert(x, t.getRight()));
        } else {

        }
        return t;

    }

    public boolean contains(Integer x) {
        return contains(x, root);
    }

    public Integer findMin() {
        if (isEmpty()) {
            return null;
        }
        return findMin(root).getElement();
    }

    private BinaryNode findMin(BinaryNode t) {
        if (isEmpty(t)) {
            return null;
        } else if (t.getLeft() == null) {
            return t;
        }
        return findMin(t);
    }

    public Integer findMax() {
        if (isEmpty()) {
            return null;
        }
        return findMax(root).getElement();
    }

    private BinaryNode findMax(BinaryNode t) {
        if (isEmpty(t)) {
            return null;
        } else if (t.getRight() == null) {
            return t;
        }
        return findMax(t.getRight());
    }

    private BinaryNode findMaxWhile(BinaryNode t) {
        if (t != null) {
            while (t.getRight() != null) {
                t = t.getRight();
            }
        }
        return t;
    }

    public void remove(Integer x) {
        root = remove(x, root);
    }

    private BinaryNode remove(Integer x, BinaryNode t) {
        if (isEmpty(t)) {
            return null;
        }
        int compareResult = x.compareTo(t.getElement());
        if (compareResult < 0) {
            remove(x, t.getLeft());
        } else if (compareResult > 0) {
            remove(x, t.getRight());
        } else if (!isEmpty(t.getLeft()) && !isEmpty(t.getRight())) {
            Integer element = findMin(t.getRight()).getElement();
            t.setElement(element);
            BinaryNode delNode = remove(t.getElement(), t.getRight());
            t.setRight(delNode);
        } else {
            t = isEmpty(t.getLeft()) ? t.getLeft() : t.getRight();

        }

        return t;

    }

    private void printTree() {
        printTree(root);
    }

    private void printTree(BinaryNode t) {
        if (t != null) {
            printTree(t.getLeft());
            System.out.println(t.getElement());
            printTree(t.getRight());

        }
    }

    private boolean contains(Integer x, BinaryNode t) {
        if (t == null) {
            return false;
        }

        int compareResult = x.compareTo(t.getElement());

        if (compareResult < 0) {
            contains(x, t.getLeft());
        } else if (compareResult > 0) {
            contains(x, t.getRight());
        } else {
            return true;
        }
        return false;
    }
}
