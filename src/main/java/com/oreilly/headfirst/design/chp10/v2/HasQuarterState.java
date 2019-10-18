package com.oreilly.headfirst.design.chp10.v2;

import com.oreilly.headfirst.design.chp10.State;

import java.util.Random;

/**
 * @author dongyl
 * @date 14:47 2019-02-03
 * @project study-demo
 */
public class HasQuarterState implements State {
    GumBallMachine gumBallMachine;

    Random randomWinner = new Random(System.currentTimeMillis());
    public HasQuarterState(GumBallMachine gumBallMachine) {
        this.gumBallMachine = gumBallMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("you can't insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("quarter returned");
        gumBallMachine.setState(gumBallMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("you turned...");
        gumBallMachine.setState(gumBallMachine.getSoldOutState());
    }
    @Override
    public void dispense() {
        System.out.println("no gumball dispensed");
    }
}
