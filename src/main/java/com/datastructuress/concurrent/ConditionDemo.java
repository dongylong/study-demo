package com.datastructuress.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dongyl
 * @date 14:13 5/16/18
 * @project study-demo
 */
public class ConditionDemo {

    public static void main(String[] args) throws InterruptedException {
        Condition condition = new ReentrantLock().newCondition();
        condition.await();
        condition.signal();
    }
}
