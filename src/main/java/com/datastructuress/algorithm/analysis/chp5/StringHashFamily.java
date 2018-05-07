package com.datastructuress.algorithm.analysis.chp5;

import java.util.Random;

/**
 * @author dongyl
 * @date 23:56 1/5/18
 * @project study-demo
 * 处理简单字符串的散列函数
 */
public class StringHashFamily implements HashFamily {
    private final int[] MULTIPLIERS;
    private final Random r = new Random();

    public StringHashFamily(int d) {
        MULTIPLIERS = new int[d];
        generateNewFunctions();
    }

    @Override
    public int hash(String x, int which) {
        final int multiplier = MULTIPLIERS[which];
        int hashVal = 0;
        for (int i = 0; i < x.length(); i++) {
            hashVal = multiplier * hashVal + x.charAt(i);
        }
        return 0;
    }

    @Override
    public int getNumberOfFunction() {
        return MULTIPLIERS.length;
    }

    @Override
    public void generateNewFunctions() {
        for (int i = 0; i < MULTIPLIERS.length; i++) {
            MULTIPLIERS[i] = r.nextInt();
        }
    }
}
