package com.oreilly.headfirst.design.chp8;

/**
 * @author dongyl
 * @date 06:53 1/29/19
 * @project study-demo
 */
public class Tea extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding lemon");
    }
}
