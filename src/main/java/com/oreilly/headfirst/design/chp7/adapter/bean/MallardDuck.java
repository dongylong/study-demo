package com.oreilly.headfirst.design.chp7.adapter.bean;

/**
 * @author dongyl
 * @date 12:41 1/27/19
 * @project study-demo
 */
public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("i am quack");
    }

    @Override
    public void fly() {
        System.out.println("i am flying");

    }
}
