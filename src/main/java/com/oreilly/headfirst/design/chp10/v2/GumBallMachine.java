package com.oreilly.headfirst.design.chp10.v2;

import com.oreilly.headfirst.design.chp10.State;
import lombok.Data;

/**
 * @author dongyl
 * @date 14:49 2019-02-03
 * @project study-demo
 */
@Data
public class GumBallMachine {

    private State hasQuarterState;
    private State noQuarterState;
    private State soldState;
    private State soldOutState;

    private State state = soldOutState;
    int count = 0;

    public GumBallMachine(int numberGumballs) {
        soldOutState = new SoldOutState();
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void releaseBall() {
        System.out.println("a gumball comes rolling out the slot...");
        if (count != 0) {
            count -= 1;
        }
    }

}