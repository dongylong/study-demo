package com.oreilly.headfirst.design.chp3;

/**
 * @AUTHOR liuling
 * @DATE 2019/1/24 00:05
 * @PROJECT studydemo
 **/
public abstract class CondimentDecorator extends Beverage {
    @Override
    public double cost() {
        return 0;
    }

    public abstract String getDescription();
}
