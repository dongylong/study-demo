package com.oreilly.headfirst.design.chp4.test;

import com.oreilly.headfirst.design.chp4.bean.PizzaTypeEnum;
import com.oreilly.headfirst.design.chp4.factory.NYPizzaStore;
import com.oreilly.headfirst.design.chp4.factory.Pizza;
import com.oreilly.headfirst.design.chp4.factory.PizzaStore;
import org.junit.jupiter.api.Test;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019-09-23 10:05
 * @changeRecord
 */
public class testFactory {
    @Test
    public void factory(){
        PizzaStore nyPizzaStore = new NYPizzaStore();
        nyPizzaStore.orderPizza(PizzaTypeEnum.CHEESE.getValue());
    }
}
