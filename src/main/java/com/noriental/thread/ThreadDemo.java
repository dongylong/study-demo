package com.noriental.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.PausableThreadPool;

import java.lang.invoke.MethodHandles;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dongyl
 * @date 18:52 1/8/18
 * @project study-demo
 */
public class ThreadDemo {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    Lock lock = new ReentrantLock();

    public static void main(String[] args) {
    }
//    @Test
//    public void futureTaskTest() throws ExecutionException, InterruptedException, TimeoutException {
//
//        FutureTask<String> newTask = new FutureTask<>(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                return findById();
//            }
//        });
//        String xx = newTask.get();
////        String xx = newTask.get(1,TimeUnit.SECONDS);
//        System.out.println(xx);
//
//    }
//
//    private String findById() throws InterruptedException {
//        return "ss";
//    }

    public void threadPool() {
        int cpuCore = Runtime.getRuntime().availableProcessors();
        PausableThreadPool threadPool = new PausableThreadPool(
                cpuCore + 1,
                cpuCore + 1,
                2,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 100000; i++) {
            set.add(i);
        }

        for (int i : set) {
            threadPool.execute(() -> {
                System.out.println("i: " + i);
                if (i == 10) {
                    logger.info("i:" + i);
                    threadPool.pause();
                }
            });
        }
    }
}
