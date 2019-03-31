package com.bigdata.total;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dongyl
 * @date 12:38 2019-02-09
 * @project study-demo
 */
public class AtomicCountTotal {
    AtomicInteger count = new AtomicInteger(0);

    static class Job implements Runnable {
        private CountDownLatch countDownLatch;
        private AtomicCountTotal countTotal;

        public Job(AtomicCountTotal countTotal, CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
            this.countTotal = countTotal;
        }

        @Override
        public void run() {
            boolean isSuccess = false;
            while (isSuccess) {
                int countValue = countTotal.count.get();
                isSuccess = countTotal.count.compareAndSet(countValue, countValue + 1);
            }
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1500);
        AtomicCountTotal countTotal = new AtomicCountTotal();
        int cpuAvailable = Runtime.getRuntime().availableProcessors();
        ExecutorService ex = Executors.newFixedThreadPool(cpuAvailable);
        for (int i = 0; i < 1500; i++) {
            ex.execute(new Job(countTotal, countDownLatch));
        }
        countDownLatch.await();
        System.out.println(countTotal.count);
        ex.shutdown();
    }
}

