package com.datastructuress.algTest.tree;

import java.util.Comparator;

/**
 * @author dongyl
 * @date 14:35 12/28/17
 * @project push-all
 */
public class BinarySearchTree1 {

    private BinaryNode root;
    private Comparator<Integer> cmp;

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

    public BinarySearchTree1() {
        this(null);
    }

    public BinarySearchTree1(Comparator<Integer> c) {
        root = null;
        cmp = c;
    }

    private int myCompare(Integer lhs, Integer rhs) {
        if (cmp != null) {
            return cmp.compare(lhs, rhs);
        } else {
            return lhs.compareTo(rhs);
        }
    }

    private boolean contains(int x, BinaryNode t) {
        if (t == null) {
            return false;
        }
        int compareResult = myCompare(x, t.element);
        if (compareResult < 0) {
            return contains(compareResult, t.left);
        } else if (compareResult > 0) {
            return contains(compareResult, t.right);
        } else {
            return contains(compareResult, t.right);
        }
    }
}
