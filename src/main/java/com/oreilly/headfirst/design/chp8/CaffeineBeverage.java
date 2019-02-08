package com.oreilly.headfirst.design.chp8;

/**
 * @author dongyl
 * @date 06:50 1/29/19
 * @project study-demo
 */
public abstract class CaffeineBeverage {
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater() {
        System.out.println("Boliling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }
}
