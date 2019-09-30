package com.oreilly.headfirst.design.chp10.bean;

import com.oreilly.headfirst.design.chp11.GumBallMachineRemote;
import lombok.Data;

/**
 * @author dongyl
 * @date 14:49 2019-02-03
 * @project study-demo
 */
public class GumBallMachine {
    private int state;
    private int hasQuarterState;
    private int noQuarterState;
    private int soldState;
    private int soldOutState;
    private int winnerState;
    private int count;
    private int location;

    public GumBallMachine(int i) {

    }

    public GumBallMachine(GumBallMachineRemote remote) {

    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getHasQuarterState() {
        return hasQuarterState;
    }

    public void setHasQuarterState(int hasQuarterState) {
        this.hasQuarterState = hasQuarterState;
    }

    public int getNoQuarterState() {
        return noQuarterState;
    }

    public void setNoQuarterState(int noQuarterState) {
        this.noQuarterState = noQuarterState;
    }

    public int getSoldState() {
        return soldState;
    }

    public void setSoldState(int soldState) {
        this.soldState = soldState;
    }

    public int getSoldOutState() {
        return soldOutState;
    }

    public void setSoldOutState(int soldOutState) {
        this.soldOutState = soldOutState;
    }

    public int getWinnerState() {
        return winnerState;
    }

    public void setWinnerState(int winnerState) {
        this.winnerState = winnerState;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public void insertQuarter() {
    }

    public void turnCrank() {
    }

    public void releaseBall() {
    }
}