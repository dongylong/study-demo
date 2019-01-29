package com.oreilly.headfirst.design.chp8;

/**
 * @author dongyl
 * @date 06:54 1/29/19
 * @project study-demo
 */
public class Coffee extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("dripping coffee throught filter");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }
}
