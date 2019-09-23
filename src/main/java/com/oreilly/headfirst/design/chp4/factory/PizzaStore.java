package com.oreilly.headfirst.design.chp4.factory;

/**
 * @AUTHOR liuling
 * @DATE 2019-02-08 08:41
 * @PROJECT studydemo
 **/
public abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    /**
     * @param type 
     * @return
     */
    abstract Pizza createPizza(String type);

}
