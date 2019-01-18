package com.oreilly.headfirst.design.chp1.behavior.impl;

import com.oreilly.headfirst.design.chp1.behavior.FlyBehavior;

/**
 * 行为实现
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("can not fly");
    }
}
