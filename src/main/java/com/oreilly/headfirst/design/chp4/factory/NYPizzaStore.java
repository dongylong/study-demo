package com.oreilly.headfirst.design.chp4.factory;

import com.oreilly.headfirst.design.chp4.bean.PizzaTypeEnum;

/**
 * @AUTHOR liuling
 * @DATE 2019/1/26 10:22
 * @PROJECT studydemo
 **/
public class NYPizzaStore extends PizzaStore{

    @Override
    Pizza createPizza(String type) {
        PizzaTypeEnum pizzaTypeEnum = PizzaTypeEnum.findByType(type);
        Pizza pizza = null;
        switch (pizzaTypeEnum){
            case CHEESE:
                pizza = new NYStyleCheesePizza();
                break;
            case PEPPERPNI:
                pizza = new NYStylePepperpniPizza();
                break;
            case CLAM:
                pizza = new NYStyleClamPizza();
                break;
            case VEGGIE:
                pizza = new NYStyleVeggiePizza();
                break;
            default:
                break;
        }
        return pizza;
    }
}
