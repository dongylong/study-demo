package com.oreilly.headfirst.design.chp1.bean;

import com.oreilly.headfirst.design.chp1.behavior.impl.FlyRocketPowered;

/**
 * @AUTHOR liuling
 * @DATE 2019/1/19 00:02
 * @PROJECT studydemo
 **/
public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard  = new MallardDuck();
        mallard.performQuark();
        mallard.performFly();

        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
