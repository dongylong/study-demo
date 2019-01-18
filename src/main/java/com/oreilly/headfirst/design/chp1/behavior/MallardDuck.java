package com.oreilly.headfirst.design.chp1.behavior;

import com.oreilly.headfirst.design.chp1.bean.Duck;

/**
 * @AUTHOR liuling
 * @DATE 2019/1/17 11:32
 * @PROJECT studydemo
 **/
public class MallardDuck extends Duck {
    @Override
    public void display() {
        performFly();
        performQuark();
    }
}
