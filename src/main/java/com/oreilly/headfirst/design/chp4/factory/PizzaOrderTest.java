package com.oreilly.headfirst.design.chp4.factory;

import com.oreilly.headfirst.design.chp4.bean.PizzaTypeEnum;
import org.junit.jupiter.api.Test;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019-09-17 10:04
 * @changeRecord
 */
public class PizzaOrderTest {
    @Test
    public void OrderInNY(){
        PizzaStore nyPizzaStore = new NYPizzaStore();
        nyPizzaStore.orderPizza(PizzaTypeEnum.CHEESE.getValue());

    }
}
