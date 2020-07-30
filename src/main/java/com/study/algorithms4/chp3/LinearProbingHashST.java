package com.study.algorithms4.chp3;

import org.omg.CORBA.Object;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2020/7/21 18:49
 * @changeRecord
 */
public class LinearProbingHashST<Key, Value> {
    /**
     * 符号表中键值队的总数
     */
    private int N;
    /**
     * 线性探测表的大小
     */
    private int M = 16;
    /**
     * 键
     */
    private Key[] keys;
    /**
     * 值
     */
    private Value[] vals;

    public LinearProbingHashST() {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0X7fffffff) % M;
    }

    private void resize() {

    }

    private void put(Key key, Value val) {
        //将M增倍
        if (N > M / 2) {
            resize(2 * M);
        }
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                keys[i] = key;
                vals[i] = val;
                N++;
            }
        }
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }

    private void resize(int i) {

    }

    /**
     * 基于线性探测的散列表的删除操作
     *
     * @param key
     */
    public void delete(Key key) {
        if (!contains(key)) {
            return;
        }
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % M;
        }
        keys[i] = null;
        vals[i] = null;
        i = (i + 1) % M;
        while (keys[i] != null) {
            Key keyToRedo = keys[i];
            Value valToRedo = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(keyToRedo, valToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N == M / 8) {
            resize(M / 2);
        }
    }

    private boolean contains(Key key) {
        return false;
    }
}
