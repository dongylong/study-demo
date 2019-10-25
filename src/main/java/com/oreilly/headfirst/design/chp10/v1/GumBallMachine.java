package com.oreilly.headfirst.design.chp10.v1;

import com.oreilly.headfirst.design.proxy.GumBallMachineRemote;

/**
 * @author dongyl
 * @date 14:49 2019-02-03
 * @project study-demo
 */
public class GumBallMachine {
    private int state = SOLD_OUT;
    private int count = 0;
    private static final int SOLD_OUT = 0;
    private static final int NO_QUARTER = 1;
    private static final int HAS_QUARTER = 2;
    private static final int SOLD = 3;

    public GumBallMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = NO_QUARTER;
        }
    }

    public GumBallMachine(GumBallMachineRemote remote) {

    }

    public void insertQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("you can't insert another quarter");
        } else if (state == SOLD_OUT) {
            System.out.println("SOLD_OUT");
        } else if (state == SOLD) {
            System.out.println("please wait ,we are already giving you a gumball");
        } else if (state == NO_QUARTER) {
            state = HAS_QUARTER;
            System.out.println("you insert a quarter");
        }
    }

    public void turnCrank() {
    }

    public void releaseBall() {
    }
}