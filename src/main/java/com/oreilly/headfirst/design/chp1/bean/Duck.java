package com.oreilly.headfirst.design.chp1.bean;

import com.oreilly.headfirst.design.chp1.behavior.FlyBehavior;
import com.oreilly.headfirst.design.chp1.behavior.QuackBehavior;

public abstract class Duck {
    //声明引用变量。
    FlyBehavior flyBehavior;
    //声明引用变量。
    QuackBehavior quackBehavior;

    public Duck() {
    }

    public abstract void display();

    public void performFly() {
        //委托给行为类
        flyBehavior.fly();
    }

    public void performQuark() {
        //委托给行为类
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("All ducks folat,even decoys!");
    }
}
