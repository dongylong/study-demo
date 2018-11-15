package com.thinkinjava.chp21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dongyl
 * @date 18:03 10/25/18
 * @project study-demo
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Object xx;
                    synchronized (this){

                   }
                }
            });
            executorService.shutdown();
        }
    }

}
