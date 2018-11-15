package com.datastructuress.uitil;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<T> {
    final ReentrantLock lock = new ReentrantLock();
    Condition notEmpty = lock.newCondition();
    Condition notFull = lock.newCondition();
    Object[] item = new Object[4];
    int startIndex;
    int endIndex;
    int count;

    private T take() {
        lock.lock();
        try {


            while (count == 0) {
                try {
                    System.out.println("queue is empty");
                    notEmpty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = (T) item[endIndex++];
            count--;
            if (endIndex == item.length) {
                endIndex = 0;
            }
            notFull.signal();
            return t;
        }finally {
            lock.unlock();
        }
    }
    private void put(T t) {
        lock.lock();
        try {
            try {
                System.out.println("t: " + t);
                while (count == item.length) {
                    System.out.println("item is full");
                    notFull.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
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
}
