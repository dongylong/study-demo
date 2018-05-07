package com.noriental.thread;

import org.junit.Test;

import java.util.concurrent.*;

public class ThreadTest {

    @Test
    public void futureTaskTest() {
        FutureTask<String> newTask = new FutureTask<>(() -> {
            System.out.println("call");
            return "ss";
        });
        String xx = null;
        try {
//            xx = newTask.get();
            xx = newTask.get(2,TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println(xx);
    }

    private String findById() {
        System.out.println("findById");
        return "ss";

    }

    @Test
    public void semaphoreTest(){
        Semaphore semaphore=new Semaphore(5);
        semaphore.tryAcquire();
    }
    private static final Exchanger<String> EXCHANGE = new Exchanger<>();
    private static ExecutorService THREADPOOL = Executors.newFixedThreadPool(2);

    public static ExecutorService newCachedThreadPool() {

        return new ThreadPoolExecutor(
                0,
                Integer.MAX_VALUE,
                60L,
                TimeUnit.SECONDS,
                new SynchronousQueue<>());
    }

    @Test
    public void ExchangeTest() {
        THREADPOOL.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String a = "bank trade A";
                    EXCHANGE.exchange(a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        THREADPOOL.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String b = "bank trade B";
                    String a = EXCHANGE.exchange(b);
                    System.out.println("a.equals(b) " + a.equals(b) + " A input:" + a + " B input: " + b);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }
    //    public static void startIndexing(File[] roots){
//        BlockingQueue<File> queue = new LinkedBlockingDeque<File>(BOUND);
//        FileFilter filter = new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                return false;
//            }
//        };
//        for (File root :roots){
//            new Thread(new FileCrawler(queue,filter,root)).start();
//        }
//        for(int i = 0 ;i <N_CONSUMERS;i++){
//            new Thread(new Indexer(queue)).start();
//        }
//    }

    @Test
    public void CountDownLatchTest() throws InterruptedException {
        CountDownLatch c = new CountDownLatch(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("c.getCount():" + c.getCount());
                System.out.println(1);
                c.countDown();
                System.out.println("c.getCount():" + c.getCount());
                System.out.println(2);
                c.countDown();
                System.out.println("c.getCount():" + c.getCount());

            }
        }).start();
        c.await();
        System.out.println(3);
    }

    @Test
    public void cyclicBarrierTest() {
        CyclicBarrier c = new CyclicBarrier(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }).start();
        try {
            c.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }
}