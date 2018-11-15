package com.thinkinjava.chp5.eight;

/**
 * @author dongyl
 * @date 11:13 10/22/18
 * @project study-demo
 * 5.8
 */
public class ArraysOfPrimitives {
    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2;
        int a3[];
        a2 = a1;
        for (int i = 0; i < a2.length; i++) {
            a2[i] = a2[i] + 1;
        }
        for (int i = 0; i < a1.length; i++) {
            System.out.println("a1[" + i + "]= " + a1[i]);
        }
    }
}
