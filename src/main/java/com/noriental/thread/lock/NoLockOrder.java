package com.noriental.thread.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NoLockOrder {
    public static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {
                public void run() {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("ThreadName: " + Thread.currentThread().getName());
                }
            });
            countDownLatch.countDown();
            executorService.shutdown();
        }
    }
}
