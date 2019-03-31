package com.oreilly.headfirst.design.chp4;

import com.oreilly.headfirst.design.chp4.bean.*;

/**
 * @AUTHOR liuling
 * @DATE 2019/1/26 08:29
 * @PROJECT studydemo
 **/
public interface PizzaIngredientFactory {
    Dough createDough();

    Sauce createSauce();

    Cheese createCheese();

    Veggies[] createVeggies();

    Pepperoni createPepperoni();

    Clams createClam();
}
