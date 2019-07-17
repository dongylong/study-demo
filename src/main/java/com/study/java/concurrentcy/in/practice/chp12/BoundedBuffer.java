package com.study.java.concurrentcy.in.practice.chp12;

import junit.framework.TestCase;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.Semaphore;

/**
 * @author dongyl
 * @version 1.0
 * @title 基于信号量有界缓存
 * @description
 * @created 2019-06-11 09:23
 * @changeRecord
 */
@ThreadSafe
public class BoundedBuffer<E> {
    private final Semaphore availableItems;
    private final Semaphore availableSpace;

    @GuardedBy("this")
    private final E[] items;

    @GuardedBy("this")
    private int putPosition = 0;

    @GuardedBy("this")
    private int takePosition = 0;

    public BoundedBuffer(int capacity) {
        availableItems = new Semaphore(0);
        availableSpace = new Semaphore(capacity);
        items = (E[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return availableItems.availablePermits() == 0;
    }

    public boolean isFull() {
        return availableSpace.availablePermits() == 0;
    }

    public void put(E x) throws InterruptedException {
        availableSpace.acquire();
        doInsert(x);
        availableSpace.release();
    }


    public E take() throws InterruptedException {
        availableItems.acquire();
        E item = deExtract();
        availableItems.release();
        return item;
    }


    private synchronized void doInsert(E x) {
        int i = putPosition;
        items[i] = x;
        putPosition = (++i == items.length) ? 0 : i;
    }

    private synchronized E deExtract() {
        int i = putPosition;
        E x = items[i];
        items[i] = null;
        takePosition = (++i == items.length) ? 0 : i;
        return x;
    }
}
class BoundedBufferTest extends TestCase {
    void testIsEmptyWhenConstructed(){
        BoundedBuffer<Integer> bb = new BoundedBuffer<Integer>(10);
        assertTrue(bb.isEmpty());
        assertFalse(bb.isFull());
    }
    void testIsFullAfterPuts() throws InterruptedException {
        int capacity  =10;
        BoundedBuffer<Integer> bb = new BoundedBuffer<Integer>(capacity);
        for (int i = 0; i < capacity; i++) {
            bb.put(i);
        }
        assertTrue(bb.isFull());
        assertFalse(bb.isEmpty());
    }
    void testTakeBlocksWhenEmoty(){
        int capacity  =10;
        final BoundedBuffer<Integer> bb = new BoundedBuffer<Integer>(capacity);
        Thread takeer = new Thread(){
            @Override
            public void run(){
                try {
                    int unused = bb.take();
                    //执行错误
                    fail();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        int LOCKUP_DETECT_TIMEPOOUT = 10;
        try{
            takeer.start();
            Thread.sleep(LOCKUP_DETECT_TIMEPOOUT);
            takeer.interrupt();
            takeer.join(LOCKUP_DETECT_TIMEPOOUT);
            assertFalse(takeer.isAlive());
        } catch (InterruptedException e) {
            e.printStackTrace();
            fail();
        }
    }
}
