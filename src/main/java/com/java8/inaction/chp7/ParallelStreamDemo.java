package com.java8.inaction.chp7;

import java.util.stream.Stream;

/**
 * @author dongyl
 * @date 10:23 11/15/18
 * @project shop-operation
 */
public class ParallelStreamDemo {
    /**
     * 7.1 BinaryOperator 1-n规约流
     * @param n
     * @return
     */
    private static long sequentialSum(long n){
        return Stream.iterate(
                //生成自然数无限流
                1L, i -> i + 1)
                //限制到前n个数
                .limit(n)
                //对所有数字求和来归纳流
                .reduce(0L, Long::sum);
    }

    /**
     * 7.1.1 并行流，函数规约
     * @param n
     * @return
     */
    private static long parallelSum(long n){
        return Stream.iterate(
                //生成自然数无限流
                1L, i -> i + 1)
                //限制到前n个数
                .limit(n)
                //将流转换成并行流
                .parallel()
                //对所有数字求和来归纳流
                .reduce(0L, Long::sum);
    }
}
