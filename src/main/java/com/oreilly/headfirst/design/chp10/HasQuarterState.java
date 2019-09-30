package com.oreilly.headfirst.design.chp10;

import com.oreilly.headfirst.design.chp10.bean.GumBallMachine;

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
        int winner = randomWinner.nextInt(10);
        if(winner ==0
        && gumBallMachine.getCount() >1) {
            gumBallMachine.setState(gumBallMachine.getWinnerState());
        }else{
            gumBallMachine.setState(gumBallMachine.getSoldState());

        }
    }

    @Override
    public void dispense() {
        System.out.println("no gumball dispensed");
    }
}
