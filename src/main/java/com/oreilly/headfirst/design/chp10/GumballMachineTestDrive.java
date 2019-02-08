package com.oreilly.headfirst.design.chp10;

import com.oreilly.headfirst.design.chp10.bean.GumBallMachine;

/**
 * @author dongyl
 * @date 22:05 2019-02-05
 * @project study-demo
 */
public class GumballMachineTestDrive {
    public static void main(String[] args) {
        GumBallMachine gumBallMachine = new GumBallMachine(5);
        System.out.println(gumBallMachine);
        gumBallMachine.insertQuarter();
        gumBallMachine.turnCrank();
        System.out.println(gumBallMachine);
        gumBallMachine.insertQuarter();
        gumBallMachine.turnCrank();
        gumBallMachine.insertQuarter();
        gumBallMachine.turnCrank();
    }
}
