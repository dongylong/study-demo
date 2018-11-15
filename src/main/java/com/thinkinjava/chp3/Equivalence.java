package com.thinkinjava.chp3;

/**
 * @author dongyl
 * @date 15:54 10/19/18
 * @project study-demo
 * 3.7.1
 */
public class Equivalence {
    public static void main(String[] args) {
        Integer n1 = new Integer(47);
        Integer n2 = new Integer(47);
        System.out.println(n1 == n2);
        System.out.println(n1 != n2);
        System.out.println(n1.equals( n2));
    }
}
