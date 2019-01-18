package com.oreilly.headfirst.design.chp1.behavior.impl;

import com.oreilly.headfirst.design.chp1.behavior.FlyBehavior;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("flying with wings");
    }
}
