package com.noriental.thread;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.*;

/**
 * @author dongyl
 */
public class ThreadTest {
    private static int cpuCore = Runtime.getRuntime().availableProcessors();
    private static final Exchanger<String> EXCHANGE = new Exchanger<>();
    private static ExecutorService THREAD_POOL = new ThreadPoolExecutor(
            cpuCore,
            Integer.MAX_VALUE,
            60L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(),
            new ThreadPoolExecutor.DiscardOldestPolicy());

    @Test
    public void futureTaskTest() {
        FutureTask<String> newTask = new FutureTask<>(() -> {
            System.out.println("call");
            return "ss";
        });
        String xx = null;
        try {
//            xx = newTask.get();
            xx = newTask.get(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println(xx);
    }

    @Test
    public void semaphoreTest() {
        //Semaphore是计数信号量 控制同一时间只有3个线程运行
        Semaphore semaphore = new Semaphore(3);
        semaphore.tryAcquire();
    }

    @Test
    public void ExchangeTest() {
        THREAD_POOL.execute(() -> {
            try {
                String a = "bank trade A";
                EXCHANGE.exchange(a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        THREAD_POOL.execute(() -> {
            try {
                String b = "bank trade B";
                String a = EXCHANGE.exchange(b);
                System.out.println("a.equals(b) " + a.equals(b) + " A input:" + a + " B input: " + b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }

    public static void startIndexing(File[] roots) {
        BlockingQueue<File> queue = new LinkedBlockingDeque<File>(5);
        FileFilter filter = pathname -> false;
        for (File root : roots) {
            new Thread(new FileCrawler(queue, filter, root)).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(new Indexer(queue)).start();
        }
    }

    @Test
    public void CountDownLatchTest() throws InterruptedException {
        CountDownLatch c = new CountDownLatch(1);
        THREAD_POOL.execute(() -> {
            System.out.println("1、c.getCount():" + c.getCount());
            c.countDown();
            System.out.println("2、c.getCount():" + c.getCount());
            c.countDown();
            System.out.println("3、c.getCount():" + c.getCount());
        });
        c.await();
        System.out.println(3);
    }

    @Test
    public void cyclicBarrierTest() {
        CyclicBarrier c = new CyclicBarrier(2);
        THREAD_POOL.execute(() -> {
            try {
                c.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(1);

        });
        try {
            c.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }
}