package com.noriental.alg.tree;

/**
 * @author dongyl
 * @date 14:35 12/28/17
 * @project push-all
 */
public class BinarySearchTree {

    private static class BinaryNode {
        int element;
        BinaryNode left;
        BinaryNode right;

        public BinaryNode(int theElement) {
            this(theElement, null, null);
        }

        public BinaryNode(int theElement, BinaryNode lt, BinaryNode rt) {
            element = theElement;
            left = lt;
            right = rt;
        }
    }

    private BinaryNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(int x) {
        return contains(x, root);
    }

    int findMin() {
        if (isEmpty()) {
            return 0;
        }
        return findMin(root).element;
    }

    int findMax() {
        if (isEmpty()) {
            return 0;
        }
        return findMax(root).element;
    }

    void insert(int x) {
        root = insert(x, root);
    }

    void remove(int x) {
        root = remove(x, root);
    }

    void printTree() {
        if (isEmpty()) {
            System.out.println("Tree is Empty");
        } else {
            printTree(root);
        }
    }

    private boolean contains(Integer x, BinaryNode t) {
        if (t == null) {
            return false;
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            return contains(compareResult, t.left);
        } else if (compareResult > 0) {

            return contains(compareResult, t.right);
        } else {
            return contains(compareResult, t.right);
        }
    }

    private int height(BinaryNode t) {
        if (t == null) {
            return -1;
        } else {
            return 1 + Math.max(height(t.left), height(t.right));
        }

    }

    private void printTree(BinaryNode t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

    private BinaryNode remove(Integer x, BinaryNode t) {
        if (t == null) {
            return null;
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = remove(x, t.left);
        } else if (compareResult > 0) {
            t.right = remove(x, t.right);
        } else if (t.left != null && t.right != null) {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else {
            t = t.left != null ? t.left : t.right;
        }
        return t;

    }

    private BinaryNode insert(Integer x, BinaryNode t) {
        if (t == null) {
            return new BinaryNode(x, null, null);
        }

        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = insert(x, t.left);
        } else if (compareResult > 0) {
            t.right = insert(x, t.right);
        } else {

        }
        return t;
    }

    private BinaryNode findMax(BinaryNode t) {
        if (t == null) {
            return null;
        } else if (t.right == null) {
            return t;
        } else {
            return findMax(t.right);
        }
    }

    private BinaryNode findMin(BinaryNode t) {
        if (t == null) {
            return null;
        } else if (t.left == null) {
            return t;
        } else {
            return findMin(t.left);
        }

    }


}
