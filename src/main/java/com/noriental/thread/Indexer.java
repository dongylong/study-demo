package com.noriental.thread;

import java.io.File;
import java.util.concurrent.BlockingQueue;

public class Indexer implements Runnable {
    private final BlockingQueue<File> queue;

    public Indexer(BlockingQueue<File> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true ){
//            indexFile(queue.take());
        }

    }
}
