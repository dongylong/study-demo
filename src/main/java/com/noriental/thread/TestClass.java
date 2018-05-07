package com.noriental.thread;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dongyl
 * @date 11:57 1/27/18
 * @project study-demo
 */
public class TestClass {

    @Test
    public void exchagerTest() {
        final Exchanger<List<Integer>> exchanger = new Exchanger<>();
        new Thread(() -> {
            List<Integer> l = new ArrayList<>(2);
            l.add(1);
            l.add(2);
            try {
                l = exchanger.exchange(l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Threadl:" + l);
        }).start();
        new Thread(() -> {
            List<Integer> l = new ArrayList<>(2);
            l.add(4);
            l.add(5);
            try {
                l = exchanger.exchange(l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread2:" + l);
        }).start();
    }

    private HashMap<String, Integer> hashMap = new HashMap<>();
    private ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();

    public synchronized void add(String key, Thread thread) {
        Integer val = hashMap.get(key);
        if (val == null) {
            hashMap.put(key, 1);
        } else {
            hashMap.put(key, val + 1);
        }
        System.out.println(hashMap.get(key) + "..add.." + thread.getName());
    }

    public void add1(String key, Thread thread) {
        Integer val = concurrentHashMap.get(key);
        if (val == null) {
            concurrentHashMap.put(key, 1);
        } else {
            concurrentHashMap.put(key, val + 1);
        }
        System.out.println(concurrentHashMap.get(key) + "..add1.." + thread.getName());

    }

    @Test
    public void test() {
//        new Thread(() -> add("key1")).start();
//        new Thread(() -> add("key1")).start();
//        new Thread(() -> add("key1")).start();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(
                    () -> {
//                        add1("key1", Thread.currentThread());
                        add("key1", Thread.currentThread());
                    }
            );
            executorService.execute(thread);
        }
    }

    @Test
    public void typeTest(){
        double dble = Math.random();
        BigDecimal bigDecimal = BigDecimal.valueOf(0.5432877);
        System.out.println(bigDecimal);
        BigDecimal l = bigDecimal.setScale(6, RoundingMode.DOWN);
        System.out.println(l);
    }
}
