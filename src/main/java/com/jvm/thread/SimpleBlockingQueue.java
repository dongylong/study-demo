package com.jvm.thread;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/***
 * @author dongyl
 * 一个简单的阻塞队列
 * @date 11:23 5/31/18
 * @project study-demo
 * <p>
 * <p>
 * class SimpleBlockingQueue<E> {
 * /***
 * 默认的队列容量
 **/

class SimpleBlockingQueue<E> {
    /***
     * 默认的队列容量
     **/
    private static final int DEFAULT_CAPACITY = 128;

    /**
     * 存储队列元素的数组
     **/
    private E[] queue;

    /**
     * 队列初始容量
     **/
    private int capacity;

    /**
     * 队列中元素个数
     **/
    private int size;

    /**
     * 队头索引
     **/
    private int head;

    /**
     * 队尾索引
     **/
    private int tail;

    /**
     * 显示锁
     **/
    private Lock lock = new ReentrantLock();

    /**
     * 条件谓词：size<capacity
     **/
    private Condition notFull = lock.newCondition();

    /**
     * 条件谓词：size>0
     **/
    private Condition notEmpty = lock.newCondition();

    public SimpleBlockingQueue() {
        this(DEFAULT_CAPACITY);
    }

    public SimpleBlockingQueue(int capacity) {
        this.capacity = capacity;
        queue = (E[]) new Object[capacity];
    }

    /***
     * 用传递的集合的元素作为队列 的初始元素
     *
     * @param c
     * @param capacity
     **/
    public SimpleBlockingQueue(Collection<E> c, int capacity) {
        this(capacity);

        // 如果传入的初始容量小于集合的大小 ，则抛出异常
        if (capacity < c.size()) {
            throw new IllegalArgumentException("");
        }

        Iterator<E> iter = c.iterator();
        while (iter.hasNext()) {
            queue[tail++] = iter.next();
            ++size;
        }
    }

    /***
     * 添加一个元素到队尾，如果队列已满，该方法将阻塞
     *
     * @param element
     * @throws InterruptedException
     **/
    public void put(E element) throws InterruptedException {
        lock.lock();
        try {
            while (size >= capacity) {
                notFull.await();
            }
            queue[tail] = element;
            if (++tail == capacity) {
                tail = 0;
            }
            ++size;
            notEmpty.signal();

        } finally {
            lock.unlock();
        }
    }

    /***
     * 从队头移除一个元素，并返回该元素，如果队列 为空，将阻塞直到有元素 为止
     *
     * @return
     * @throws InterruptedException
     **/
    public E take() throws InterruptedException {
        lock.lock();
        try {
            while (size == 0) {
                notEmpty.await();
            }
            E value = queue[head];
            queue[head] = null;
            if (++head == capacity) {
                head = 0;
            }
            --size;
            notFull.signal();
            return value;
        } finally {
            lock.unlock();
        }
    }
}