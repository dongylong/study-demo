package com.study.jvm;

public class ClassLoader {

    public static int tmp = 1;

    static {
        tmp = 2;
        System.out.println("static tmp :" + tmp);
    }

    public static void main(String[] args) {
        int tmp = 3;
        System.out.println("main tmp : " + tmp);
    }
}
