package com.jvm.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dongyl
 * @date 17:32 6/6/18
 * @project study-demo
 */
public class BQ<T> {
    final ReentrantLock lock = new ReentrantLock();
    final Condition notEmpty = lock.newCondition();
    final Condition notFull = lock.newCondition();
    Object[] item = new Object[4];
    int startIndex, endIndex, count;

    private void input(T t) {
        lock.lock();
        try {
            System.out.println("t: " + t);
            while (count == item.length) {
                System.out.println("队列满，阻塞");
                notFull.await();
            }
            item[startIndex++] = t;

            if (count == item.length) {
                startIndex = 0;
            }
            notEmpty.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    private void output(){

    }

}
