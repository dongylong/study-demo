package com.thinkinjava.chp3;

/**
 * @author dongyl
 * @date 15:54 10/19/18
 * @project study-demo
 * 3.7.1
 */
public class EqualMethod2 {
    public static void main(String[] args) {
        Value v1 = new Value();
        Value v2 = new Value();
        v1.i=v2.i =100;

        System.out.println(v1.equals( v2));
        System.out.println(v1+"=v1,v2="+v2);
        System.out.println(v1.i+"=v1.i,v2.i="+v2.i);
    }
    static class Value{
        int i ;
    }
}
