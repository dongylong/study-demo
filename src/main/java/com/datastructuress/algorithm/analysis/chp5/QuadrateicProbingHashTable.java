package com.datastructuress.algorithm.analysis.chp5;

/**
 * AlgDemo
 * liuling
 * 2018/1/4
 * 探测散列表
 * 表大小形如4K+3的素数且使用的平方冲突解决方法为F(i)=±i2 (Math.pow(i,2))
 **/
public class QuadrateicProbingHashTable {
    private static final int DEFAULT_TABLE_SIZE = 11;
    private HashEntry[] array;
    private int currentSize;

    public QuadrateicProbingHashTable(int size) {
        allocateArray(size);
        makeEmpty();
    }

    public QuadrateicProbingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public void makeEmpty() {
        currentSize = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    public boolean contains(int x) {
        //实施对冲突的解决。
        int currentPos = findPos(x);
        return isActive(currentPos);
    }

    /**
     * 不能标准删除，因为相应的单元可能已经引起过冲突，元素绕过存在了别处。
     * 惰性删除 实际上不存在所谓的懒惰
     *
     * @param x
     */
    public void remove(int x) {

        int currentPos = findPos(x);
        if (isActive(currentPos)) {
            array[currentPos].isActive = false;
        }
    }

    /**
     * 散列表至少为该表中元素个数的两倍大，这样平方探测解决方案可以实现
     *
     * @param x
     */
    public void insert(int x) {
        int currentPos = findPos(x);
        if (isActive(currentPos)) {
            return;
        }
        array[currentPos] = new HashEntry(x, true);
        //rehash
        if (currentSize > array.length / 2) {
            rehash();
        }
    }

    /**
     * 1.null
     * 2.非null,且该项是活动的 isActive=true
     * 3.非null,且该项标记被删除 isActive=false
     */
    private static class HashEntry {
        public Integer element;
        public boolean isActive;

        public HashEntry(Integer e) {
            this(e, true);
        }

        public HashEntry(Integer e, boolean i) {
            element = e;
            isActive = i;
        }
    }

    private void allocateArray(int arraySize) {
        array = new HashEntry[nextPrime(arraySize)];
    }

    private boolean isActive(int currentPos) {
        return array[currentPos] != null && array[currentPos].isActive;

    }

    /**
     * 标记为删除的那些元素被认为还在表内。引起问题：该表可能提前过满。
     *
     * @param x
     * @return
     */
    private int findPos(Integer x) {
        int offSet = 1;
        int cerementPos = myhash(x);
        //while内顺序很重要。不能改变
        while (array[cerementPos] != null && !array[cerementPos].element.equals(x)) {
            //Compute ith probe
            cerementPos += offSet;
            /**
             * f(i)=f(i-1)+2*i-1 因此下一个要探测的单元离上一个被探测过的单元有一段距离，这个距离在连续探测中增2。
             * 如果越界，可通过减去TableSize 拉回到数组范围内。
             * 避免了看似需要的乘法和除法，速度快。
             */
            offSet += 2;
            if (cerementPos >= array.length) {
                cerementPos -= array.length;
            }
        }
        return cerementPos;
    }

    /**
     * x存在则什么都不做。
     * 若装填因子超过0.5则表是满的，需要将该散列表放大。称为再散裂(rehashing)
     */
    public void rehash() {

        HashEntry[] oldArray = array;
        allocateArray(nextPrime(2 * oldArray.length));
        currentSize = 0;
        for (int i = 0; i < oldArray.length; i++) {
            if (oldArray[i] != null && oldArray[i].isActive) {
                insert(oldArray[i].element);
            }
        }
    }


    public int myhash(Integer x) {

        //online code
        return 0;
    }

    public static int nextPrime(int x) {
        //online code

        return x;
    }

    public static boolean isPrime(int x) {
        //online code

        return true;
    }
}
