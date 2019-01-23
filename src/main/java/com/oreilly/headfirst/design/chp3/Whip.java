package com.oreilly.headfirst.design.chp3;

/**
 * @AUTHOR liuling
 * @DATE 2019/1/24 00:11
 * @PROJECT studydemo
 **/
public class Whip extends CondimentDecorator {

    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return .1;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";

    }
}
