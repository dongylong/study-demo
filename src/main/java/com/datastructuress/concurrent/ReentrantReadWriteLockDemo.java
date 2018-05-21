package com.datastructuress.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author dongyl
 * @date 10:48 5/16/18
 * @project study-demo
 */
public class ReentrantReadWriteLockDemo {
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
    private static CountDownLatch countDownLatch = new CountDownLatch(102);
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(102);
    private static Map<String, String> maps = new HashMap<>();

    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            new Thread(new ReadThread()).start();
        }
        for (int i = 0; i < 100; i++) {
            new Thread(new WriteThread()).start();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - beginTime);
    }

    private static class ReadThread implements Runnable {
        @Override
        public void run() {
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                readLock.lock();
                maps.get("1");
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                readLock.unlock();
            }
            countDownLatch.countDown();
        }
    }

    private static class WriteThread implements Runnable {
        @Override
        public void run() {
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                writeLock.lock();
                maps.put("1", "2");
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                writeLock.unlock();
            }
            countDownLatch.countDown();
        }
    }
}
