package com.thinkinjava.chp5.eight;

import java.util.Arrays;

/**
 * @author dongyl
 * @date 11:22 10/22/18
 * @project study-demo
 */
public class ArrayInit {
    public static void main(String[] args) {
        Integer[] a = {
                new Integer(1),
                new Integer(2),
                3,//Autoboxing
        };
        Integer[] b = new Integer[]{
                new Integer(1),
                new Integer(2),
                3,//Autoboxing
        };
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
