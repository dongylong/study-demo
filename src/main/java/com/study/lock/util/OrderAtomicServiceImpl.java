package com.study.lock.util;

import com.study.lock.service.OrderAtomicService;
import redis.clients.jedis.Jedis;

import java.util.concurrent.atomic.AtomicInteger;

public class OrderAtomicServiceImpl extends OrderAtomicService {
    static AtomicInteger num = new AtomicInteger();

    static Jedis jedis;

    static {
        jedis = new Jedis("localhost", 6379);
    }

    public static void main(String[] args) {

        jedis.getResource();
        jedis.incr();
    }
}
