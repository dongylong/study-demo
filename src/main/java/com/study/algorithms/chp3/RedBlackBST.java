package com.study.algorithms.chp3;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2020/5/25 09:35
 * @changeRecord
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color = RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = x;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = x;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
        return;
    }

    private int size(Node node) {
        return 0;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLACK;
    }

    public Node put(Node h, Key key, Value val) {
        if (h == null) {
            return new Node(key, val, 1, RED);
        }
        int cpm = key.compareTo(h.key);
        if (cpm < 0) {
            h.left = put(h.left, key, val);
        } else if (cpm > 0) {
            h.right = put(h.right, key, val);
        } else {
            h.value = val;
        }
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && !isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && !isRed(h.right)) {
            flipColors(h);
        }
        h.N = size(h.left) + size(h.right) + 1;
        return null;
    }

    private class Node {
        private Key key;
        private Value value;
        private boolean color;
        private Node right;
        private Node left;
        private int N;

        public Node(Key key, Value val, int N, boolean color) {
            this.key = key;
            this.value = val;
            this.N = N;
            this.color = color;
        }

        public Node() {

        }
    }
}
