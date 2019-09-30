package com.oreilly.headfirst.design.chp8;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019-09-30 11:04
 * @changeRecord
 */
public abstract class CaffeineBeverageWithHook {
    void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    abstract void brew();

    void boilWater() {
        System.out.println("Boiling water");
    }

    abstract void pourInCup();

    abstract void addCondiments();

    boolean customerWantsCondiments() {
        return true;
    }
}
