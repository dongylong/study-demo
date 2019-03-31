package com.bigdata.total;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dongyl
 * @date 12:38 2019-02-09
 * @project study-demo
 */
public class CountTotal {
    int count = 0;

    static class Job implements Runnable {
        private CountDownLatch countDownLatch;
        private CountTotal countTotal;

        public Job(CountTotal countTotal, CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
            this.countTotal = countTotal;
        }

        @Override
        public void run() {
            countTotal.count++;
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1500);
        CountTotal countTotal = new CountTotal();
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

