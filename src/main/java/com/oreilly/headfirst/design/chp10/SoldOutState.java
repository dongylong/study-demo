package com.oreilly.headfirst.design.chp10;

import com.oreilly.headfirst.design.chp10.bean.GumBallMachine;

/**
 * @author dongyl
 * @date 14:47 2019-02-03
 * @project study-demo
 */
public class SoldOutState implements State {
    GumBallMachine gumBallMachine;
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
        gumBallMachine.setState(gumBallMachine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("no gumball dispensed");
    }
}
