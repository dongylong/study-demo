package com.datastructuress;

import java.util.LinkedList;

public class MyHashMap {
    public MyHashMap() {
    }

    LinkedList[] list = new LinkedList[500];
    int length = list.length;
    int size;

    private Object getVal(Object key) {
        int hash = Math.abs(key.hashCode() % length);
        if (list[hash] != null) {
            LinkedList l = list[hash];
            int len = l.size();
            for (int i = 0; i < len; i++) {
                Node tmp = (Node) l.get(i);
                if (tmp.key == key) {
                    return tmp.val;
                }
            }
        }
        return null;
    }

    private void put(Object key, Object value) {
        int hash = Math.abs(key.hashCode() % length);
        Node n = new Node(key, value);
        if (list[hash] == null) {
            LinkedList l = new LinkedList();
            l.add(n);
            list[hash] = l;
            size++;
        } else {
            LinkedList l = list[hash];
            int len = l.size();
            for (int i = 0; i < len; i++) {
                Node tmp = (Node) l.get(i);
                if (tmp.key == key) {
                    tmp.val = value;
                }
            }
        }
    }

    private class Node {
        Object key;
        Object val;

        public Node(Object key, Object val) {
            this.key = key;
            this.val = val;
        }
    }
}
