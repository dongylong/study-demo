package com;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author dongyl
 * @date 21:44 2019-02-10
 * @project study-demo
 */
public class TestFuture {
    static class Job<Object> implements Callable<Object>{

        @Override
        public Object call() throws Exception {
            return loadData();
        }
        private Object loadData() {
            return null;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask future = new FutureTask(new Job());
        new Thread(future).start();
        Object result = future.get();

    }
}

