package com.oreilly.headfirst.design.chp1.bean;

import com.oreilly.headfirst.design.chp1.behavior.FlyBehavior;
import com.oreilly.headfirst.design.chp1.behavior.QuackBehavior;
import com.oreilly.headfirst.design.chp1.behavior.impl.FlyNoWay;
import com.oreilly.headfirst.design.chp1.behavior.impl.Quack;

public class ModelDuck extends Duck{
    //声明引用变量。
    FlyBehavior flyBehavior;
    //声明引用变量。
    QuackBehavior quackBehavior;

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    public void display(){
        System.out.println("i am a model duck");
    };

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

    @Override
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    @Override
    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
