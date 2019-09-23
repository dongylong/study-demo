package com.oreilly.headfirst.design.chp11;


import com.oreilly.headfirst.design.chp10.bean.GumBallMachine;

/**
 * @author dongyl
 * @date 14:47 2019-02-03
 * @project study-demo
 */
public class NoQuarterState implements State {
    GumBallMachine gumBallMachine;

    public NoQuarterState(GumBallMachine gumBallMachine) {
        this.gumBallMachine = gumBallMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You inserted a quarter");
        gumBallMachine.setState(gumBallMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("you haven't inserted a quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned,but there's no quarter");

    }

    @Override
    public void dispense() {
        System.out.println("you need to pay first");
    }
}
