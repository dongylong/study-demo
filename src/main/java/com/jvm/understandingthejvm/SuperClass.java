package com.jvm.understandingthejvm;

/**
 * @author dongyl
 * @date 16:26 5/27/18
 * @project study-demo
 * 被动使用类字段演示一： *通过子类引用父类的静态字段，不会导致子类初始化
 **/

/**
 * 被动使用类字段演示一： *通过子类引用父类的静态字段，不会导致子类初始化
 **/


public class SuperClass {
    static {
        System.out.println("SuperClass init");
    }

    public static int value = 123;
}
