package com.algorithms.chp6;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019-08-09 10:01
 * @changeRecord
 */
public class BTreeSET<Key extends Comparable<Key>> {
    private Page root = new Page(true);

    public BTreeSET(Key sentinel) {
        add(sentinel);
    }

    private boolean contains(Key key) {
        return contains(root, key);
    }

    private boolean contains(Page h, Key key) {
        if (h.isExTernal()) {
            return h.contains(key);
        }
        return contains(h.next(key), key);
    }

    private void add(Key key) {
        add(root, key);
        if (root.isFull()) {
            Page leftHalf = root;
            Page rightHalf = root.split();
            root = new Page(false);
            root.add(leftHalf);
            root.add(rightHalf);

        }
    }

    private void add(Page h, Key key) {
        add();
    }
}
