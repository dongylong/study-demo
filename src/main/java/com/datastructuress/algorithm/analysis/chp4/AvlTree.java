package com.datastructuress.algorithm.analysis.chp4;

/**
 * @author dongyl
 * @date 20:07 12/30/17
 * @project study-demo
 */
public class AvlTree {
    AvlNode root = new AvlNode();

    public AvlNode insert(Integer x, AvlNode t) {
        if (t == null) {
            return new AvlNode(x);
        }
        int compareResult = x.compareTo(t.getElement());
        if (compareResult < 0) {
            AvlNode newNode = insert(x, t.getLeft());
            t.setLeft(newNode);
            return t;
        } else if (compareResult > 0) {
            AvlNode newNode = insert(x, t.getRight());
            t.setRight(newNode);
        }
        return balance(t);
    }

    public AvlNode remove(Integer x, AvlNode t) {
        if (t == null) {
            return t;
        }
        int compareResult = x.compareTo(t.getElement());
        if (compareResult < 0) {
            t.setLeft(remove(x, t.getLeft()));
        } else if (compareResult > 0) {
            t.setRight(remove(x, t.getRight()));
        } else if (t.getLeft() != null && t.getRight() != null) {
            t.setElement(findMin(t.getRight()).getElement());
            t.setRight(remove(t.getElement(), t.getRight()));
        } else {
            t = t.getLeft() != null ? t.getLeft() : t.getRight();
        }
        return t;
    }


    private boolean isEmpty() {
        return root == null;
    }


    private AvlNode findMin(AvlNode t) {
        return new AvlNode();

    }

    private static final int ALLOWED_IMBALANCE = 1;


    public int height(AvlNode t) {
        return t == null ? -1 : t.getHeight();
    }

    public int height(BinaryNode t) {
        return t == null ? -1 : 1 + Math.max(height(t.getLeft()), height(t.getRight()));
    }

    private AvlNode balance(AvlNode t) {
        if (t == null) {
            return t;
        }
        if (height(t.getRight()) - height(t.getLeft()) > ALLOWED_IMBALANCE) {
            if (height(t.getRight()) >= height(t.getLeft())) {
                t = rotateWithLeftChild(t);
            } else {
                t = doubleWithLeftChild(t);
            }
        } else {
            t = doubleWithRightChild(t);
        }
        int height = Math.max(height(t.getLeft()), height(t.getRight())) + 1;
        t.setHeight(height);
        return t;
    }

    private AvlNode doubleWithRightChild(AvlNode t) {

        return new AvlNode();
    }

    private AvlNode doubleWithLeftChild(AvlNode k3) {
        k3.setLeft(rotateWithLeftChild(k3.getLeft()));
        return rotateWithLeftChild(k3);
    }

    private AvlNode rotateWithLeftChild(AvlNode k2) {
        AvlNode k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        k2.setHeight(Math.max(height(k2.getLeft()), height(k2.getRight())) + 1);
        k1.setHeight(Math.max(height(k1.getLeft()), k2.getHeight()) + 1);
        return k1;
    }
}
