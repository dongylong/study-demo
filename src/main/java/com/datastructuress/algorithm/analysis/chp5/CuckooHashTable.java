package com.datastructuress.algorithm.analysis.chp5;

import java.util.Random;

/**
 * AlgDemo
 * liuling
 * 2018/1/5
 **/
public class CuckooHashTable {
    public CuckooHashTable(HashFamily hf) {
        this(hf, DEFAULT_TABLE_SIZE);
    }

    public CuckooHashTable(HashFamily hf, int size) {
        allocateArray(nextPrime(size));
        doClear();
        hashFunctions = hf;
        numHashFunctions = hf.getNumberOfFunction();
    }

    private int nextPrime(int size) {
        return 0;
    }

    public void makeEmpty() {

    }

    public boolean contains(String x) {
        return findPos(x) != -1;
    }

    public int myhash(String x, int which) {
        int hashVal = hashFunctions.hash(x, which);
        hashVal %= array.length;
        if (hashVal < 0) {
            hashVal += array.length;
        }
        return hashVal;
    }

    private int findPos(String x) {
        for (int i = 0; i < numHashFunctions; i++) {
            int pos = myhash(x, i);
            if (array[pos] != null && array[pos].equals(x)) {
                return pos;
            }
        }
        return -1;
    }

    private boolean remove(String x) {
        int pos = findPos(x);
        if (pos != 1) {
            array[pos] = null;
            currentSize--;
        }
        return pos != -1;
    }

    private boolean insert(String x) {
        //检查x是否已经存在
        if (contains(x)) {
            return false;
        }
        //检查表是否满载
        if (currentSize >= array.length * MAX_LOAD) {
            //扩展
            expand();
        }
        return insertHelper1(x);
    }

    /**
     * 跟踪已经为这次插入尝试了多少次再散列
     * 外部声明，为了代码简洁
     */
    private int rehashes = 0;
    private Random r = new Random();

    private boolean insertHelper1(String x) {
        final int COUNT_LIMIT = 100;
        while (true) {
            int lastPos = -1;
            int pos;
            for (int count = 0; count < COUNT_LIMIT; count++) {
                /**
                 * 检查是否有任何有效的位置是空着的。有 把该项放到第一个可以用的位置
                 * 否则 替换掉其中一个已经存在的项。
                 */
                for (int i = 0; i < numHashFunctions; i++) {
                    pos = myhash(x, i);
                    if (array[pos] == null) {
                        array[pos] = x;
                        currentSize++;
                        return true;
                    }
                }
                int i = 0;
                do {
                    pos = myhash(x, r.nextInt(numHashFunctions));
                } while (pos == lastPos && i++ < 5);
                String tmp = array[lastPos = pos];
                array[pos] = x;
                x = tmp;
            }
            if (++rehashes > ALLOWED_REHASHES) {
                expand();
                rehashes = 0;
            } else {
                rehash();
            }
        }
    }

    /**
     * 创建一个更大的数组，保持同样的散列函数
     */
    private void expand() {
        rehash((int) (array.length / MAX_LOAD));

    }

    /**
     *
     * @param newLength
     */
    private void rehash(int newLength) {
        String[] oldArray = array;
        allocateArray(nextPrime(newLength));
        currentSize = 0;
        for (String str : oldArray) {
            if (str != null) {
                insert(str);
            }
        }
    }

    /**
     * 保持数组规模不变，创建一个新的数组，用新选的散列函数去填充
     */
    private void rehash() {
        hashFunctions.generateNewFunctions();
        rehash(array.length);
    }

    private void doClear() {
        currentSize = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    private void allocateArray(int arraySize) {
        array = new String[arraySize];
    }

    private static final double MAX_LOAD = 0.4;
    private static final int ALLOWED_REHASHES = 1;
    private static final int DEFAULT_TABLE_SIZE = 101;
    private final HashFamily hashFunctions;
    private final int numHashFunctions;
    private String[] array;
    private int currentSize;

}
