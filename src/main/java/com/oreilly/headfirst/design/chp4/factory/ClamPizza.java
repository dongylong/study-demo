package com.oreilly.headfirst.design.chp4.factory;

import com.oreilly.headfirst.design.chp4.PizzaIngredientFactory;

/**
 * @AUTHOR liuling
 * @DATE 2019/1/26 10:18
 * @PROJECT studydemo
 **/
public class ClamPizza extends Pizza {

    PizzaIngredientFactory ingredientFactory;

    public ClamPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("prepareing :" + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        clams = ingredientFactory.createClam();
    }
}
