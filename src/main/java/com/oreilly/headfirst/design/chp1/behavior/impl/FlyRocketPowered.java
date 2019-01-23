package com.oreilly.headfirst.design.chp1.behavior.impl;

import com.oreilly.headfirst.design.chp1.behavior.FlyBehavior;

/**
 * @AUTHOR liuling
 * @DATE 2019/1/19 00:01
 * @PROJECT studydemo
 **/
public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("i am flying with a rocket");
    }
}
