package com.oreilly.headfirst.design.chp8;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019-09-30 11:16
 * @changeRecord
 */
public class BeverageTestDrive {
    public static void main(String[] args) {
        TeaWithHook teaHook = new TeaWithHook();
        CoffeeWithHook coffeeHook = new CoffeeWithHook();
        System.out.println("\nMaking tea");

        teaHook.prepareRecipe();
        System.out.println("\nMaking coffee");
        coffeeHook.prepareRecipe();
    }
}
