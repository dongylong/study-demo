package com.study.lock;

import java.util.concurrent.CountDownLatch;

public class NoLockOrder {
    CountDownLatch countDownLatch = new CountDownLatch(1);

    
}
