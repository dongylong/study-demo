package com.study.java.concurrentcy.in.practice.chp3;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019-06-04 18:52
 * @changeRecord
 */
public class OneValueCache {
    private BigInteger lastNumber;
    private BigInteger[] lastFactors;

    public OneValueCache(BigInteger i, BigInteger[] factors) {
        this.lastNumber = i;
        this.lastFactors = Arrays.copyOf(factors, factors.length);
    }

    public BigInteger[] getFactors(BigInteger i) {
        if (lastNumber == null || !lastNumber.equals(i)) {
            return null;
        } else {
            return Arrays.copyOf(lastFactors, lastFactors.length);
        }
    }

}
