package com.datastructuress.algorithm.analysis.chp5;

import java.util.LinkedList;
import java.util.List;

/**
 * SeparateChainingHashTable
 * liuling
 * 2018/1/2
 **/
public class SeparateChainingHashTable {

    private static final int DEFAULT_TABLE_SIZE = 10;
    private List[] theLists;
    private int currentSize;

    public SeparateChainingHashTable(int size) {
        theLists = new LinkedList[nextPrime(size)];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList<>();
        }
    }

    public SeparateChainingHashTable() {

        this(DEFAULT_TABLE_SIZE);
    }

    public void insert(int x) {

        List whichList = theLists[myhash(x)];
        if (!whichList.contains(x)) {
            whichList.add(x);
            if (++currentSize > theLists.length) {
                rehash();
            }

        }

    }

    public void remove(int x) {
        List whichList = theLists[myhash(x)];
        for (int i = 0; i < whichList.size(); i++) {
            if (whichList.contains(x)) {
                whichList.remove(x);
                currentSize--;
            }
        }
    }

    public boolean contains(int x) {
        List whichList = theLists[myhash(x)];
        return whichList.contains(x);
    }

    public void makeEmpty() {

        for (int i = 0; i < theLists.length; i++) {
            theLists[i].clear();
        }
        currentSize = 0;
    }

    public void rehash() {
        List[] oldLists = theLists;
        theLists = new List[nextPrime(2 * theLists.length)];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList();
        }
        currentSize = 0;
        for (int i = 0; i < oldLists.length; i++) {
            for (Object item : oldLists[i]) {
                insert((int) item);
            }
        }
    }

    public int myhash(Integer x) {
        int hashVal = x.hashCode();
        hashVal %= theLists.length;
        if (hashVal < 0) {
            hashVal += theLists.length;
        }
        return hashVal;
    }

    public static int nextPrime(int x) {

        return x;
    }

    public static boolean isPrime(int x) {

        return true;
    }
}
