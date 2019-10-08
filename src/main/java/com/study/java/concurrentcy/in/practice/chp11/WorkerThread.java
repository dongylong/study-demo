package com.study.java.concurrentcy.in.practice.chp11;

import java.util.concurrent.BlockingQueue;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019-06-10 09:32
 * @changeRecord
 */
public class WorkerThread extends Thread{
    private final BlockingQueue<Runnable> queue;

    public WorkerThread(BlockingQueue<Runnable> queue) {
        this.queue = queue;
    }
    @Override
    public void run(){
        while (true){
            try {
                Runnable task = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
                //线程退出
                break;
            }
        }
    }
}
