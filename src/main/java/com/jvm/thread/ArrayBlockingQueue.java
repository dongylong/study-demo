package com.jvm.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dongyl
 * @date 17:01 6/4/18
 * @project study-demo
 */
public class ArrayBlockingQueue<T> {

    private Lock lock = new ReentrantLock();
    private Object[] item = new Object[4];
    /**
     * 初始化时，默认值为0,count 定义为队列中元素的数目
     **/
    private int startIndex, endIndex, count;
    /**
     * Condition for waiting puts
     **/
    private Condition notFull = lock.newCondition();
    /**
     * Condition for waiting takes
     **/
    private Condition notEmpty = lock.newCondition();

    public void add(T t) {
        lock.lock();
        try {
            System.out.println("存放值" + t);
            while (count == item.length) {
                try {
                    System.out.println("队列已满，阻塞put线程");
                    notFull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            item[startIndex++] = t;
            count++;
            if (startIndex == item.length) {
                startIndex = 0;
            }
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T take() {
        lock.lock();//获取锁不能写在try块中，如果发生异常，锁会被释放
        try {
            while (count == 0) {
                try {
                    System.out.println("队列空了，阻塞take线程");
                    notEmpty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = (T) item[endIndex++];
            System.out.println("取值" + t);
            count--;
            if (endIndex == item.length) {
                endIndex = 0;
            }
            notFull.signal();
            return t;
        } finally {
            lock.unlock();
        }
    }
}
