package com.noriental.book3;

import java.util.Random;
import java.util.Stack;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dongyl
 * @date 14:16 2/20/18
 * @project study-demo
 */
public class StackBenchMark {

    private Stack<String> stack = new Stack<>();
    private ConcurrentStack<String> concurrentStack = new ConcurrentStack<>();
    private static final int THREAD_COUNT = 300;
    private CountDownLatch latch = new CountDownLatch(THREAD_COUNT);
    private CyclicBarrier barrier = new CyclicBarrier(THREAD_COUNT);

    public static void main(String[] args) throws InterruptedException {
        StackBenchMark benchMark = new StackBenchMark();
        benchMark.run();
    }

    private void run() throws InterruptedException {
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(new StackBenchMarkTask()).start();
        }
        latch.await();
        System.out.println("Stack consume Time : " + (System.currentTimeMillis() - beginTime + " ms"));
        latch = new CountDownLatch(THREAD_COUNT);
        barrier = new CyclicBarrier(THREAD_COUNT);
        beginTime = System.currentTimeMillis();
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(new ConcurrentStackBenchMarkTask()).start();
        }
        latch.await();
        System.out.println("Stack consume Time : " + (System.currentTimeMillis() - beginTime + " ms"));
    }
    class StackBenchMarkTask implements Runnable{

        @Override
        public void run() {
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {
                stack.push(Thread.currentThread().getName());
                stack.pop();
            }
            latch.countDown();
        }
    }
    class ConcurrentStackBenchMarkTask implements Runnable{

        @Override
        public void run() {
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {
                concurrentStack.push(Thread.currentThread().getName());
                concurrentStack.pop();
            }
            latch.countDown();
        }
    }
    static class Handler{
        private static final Handler self = new Handler();
        private final Random random = new Random();
        private int lockCount = 10;
        private Lock[] locks = new Lock[lockCount];

        public Handler() {
            for (int i = 0; i < lockCount; i++) {
                locks[i] = new ReentrantLock();
            }
        }
        public static Handler getInstance(){
            return self;
        }
        public void handler(int id){
            int mod = id%lockCount;
            try {
                try {
                    Thread.sleep(random.nextInt(5));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                locks[mod].lock();
                try {
                    Thread.sleep(random.nextInt(5));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }finally {
                locks[mod].unlock();
            }
        }
    }
}
