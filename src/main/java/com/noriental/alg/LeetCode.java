package com.noriental.alg;

import org.junit.Test;

/**
 * @author dongyl
 * @date 17:26 11/1/17
 * @project public-svr
 */
public class LeetCode {

    @Test
    public void test() {
        int[] aa = new int[]{1, 2, 2, 3, 3, 3};
        int i = singleNumber(aa, aa.length);
        System.out.println("i:" + i);
    }


    int singleNumber(int a[], int n) {
        int ones = 0;
        int twos = 0;
        int xThrees = 0;
        for (int i = 0; i < n; ++i) {
            //按位或
            twos |= (ones & a[i]);
            //表示异或赋值,相同取0，不同取1
            ones ^= a[i];
            //按位取反
            xThrees = ~(ones & twos);
            ones &= xThrees;
            twos &= xThrees;
            System.out.println("i: " + i + " , a[" + i + "] : " + a[i] + " ,ones : " + ones + " , twos : " + twos + " , xThrees : " + xThrees);
        }
        return ones;
    }
}
