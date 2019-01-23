package com.oreilly.headfirst.design.chp1.bean;

import com.oreilly.headfirst.design.chp1.bean.Duck;
import com.oreilly.headfirst.design.chp1.behavior.impl.FlyWithWings;
import com.oreilly.headfirst.design.chp1.behavior.impl.Quack;

/**
 * @AUTHOR liuling
 * @DATE 2019/1/17 11:32
 * @PROJECT studydemo
 **/
public class MallardDuck extends Duck {
    @Override
    public void display() {
        System.out.println("i am a real mallard duck");
    }

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }
}
