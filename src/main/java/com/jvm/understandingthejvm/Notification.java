package com.jvm.understandingthejvm;

/**
 * @author dongyl
 * @date 16:30 5/27/18
 * @project study-demo
 */


public class Notification {

    public static void main(String[] args) {
        /**
         * 非主动使用类字段演示
         */
//        System.out.println(SubClass.value);
//        /** *被动使用类字段演示二： *通过数组定义来引用类，不会触发此类的初始化 **/
//        SuperClass[] superClass = new SuperClass[10];
//        System.out.println(superClass);
        //        SubClass subClass = new SubClass();
/**
 * 非主动使用类字段演示
 */
        String constClass = ConstClass.HELLO_WORLD;
        System.out.println(constClass);
    }
}
