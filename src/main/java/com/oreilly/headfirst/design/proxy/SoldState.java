package com.oreilly.headfirst.design.proxy;

import com.oreilly.headfirst.design.chp10.bean.GumBallMachine;

/**
 * @author dongyl
 * @date 14:47 2019-02-03
 * @project study-demo
 */
public class SoldState implements State {
    GumBallMachine gumBallMachine;
    @Override
    public void insertQuarter() {
        System.out.println("pls wait,we are already giving you a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("sorry you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("turning twice doesn't get you another gumball");
    }

    @Override
    public void dispense() {
    }
}