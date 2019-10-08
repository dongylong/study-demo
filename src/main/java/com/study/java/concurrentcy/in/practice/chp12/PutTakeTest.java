package com.study.java.concurrentcy.in.practice.chp12;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static junit.framework.TestCase.assertEquals;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019-06-11 09:54
 * @changeRecord
 */
public class PutTakeTest {
    private static final ExecutorService pool = Executors.newCachedThreadPool();
    private final AtomicInteger putSum = new AtomicInteger(0);
    private final AtomicInteger takeSum = new AtomicInteger(0);
    private final CyclicBarrier barrier;
    private final BoundedBuffer<Integer> bb;
    private final int nTrials;
    private final int nPairs;

    public static void main(String[] args) {
        new PutTakeTest(10,10,100000).test();
        pool.shutdown();
    }
    PutTakeTest(int capacity, int nTrials, int nPairs) {
        this.bb = new BoundedBuffer<Integer>(capacity);
        this.nTrials = nTrials;
        this.nPairs = nPairs;
        this.barrier = new CyclicBarrier(nPairs * 2 + 1);
    }

    void test() {
        for (int i = 0; i < nPairs; i++) {
            pool.execute(new Producer());
            pool.execute(new Consumer());
        }
        try {
            barrier.wait();
            barrier.wait();
            assertEquals(putSum.get(), takeSum.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private class Producer implements Runnable {
        public void run() {
            int seed = (this.hashCode() ^ (int)System.nanoTime());
            int sum = 0;
            try {
                barrier.wait();
                for (int i = nPairs; i >0 ; --i) {
                    bb.put(seed);
                    sum+=seed;
                    seed = xorShift(seed);
                }
                putSum.getAndAdd(sum);
                barrier.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    private class Consumer implements Runnable {
        public void run() {
            try {
                barrier.wait();
                int sum = 0;
                for (int i = nPairs; i >0 ; --i) {
                    sum+= bb.take();
                }
                takeSum.getAndAdd(sum);
                barrier.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
