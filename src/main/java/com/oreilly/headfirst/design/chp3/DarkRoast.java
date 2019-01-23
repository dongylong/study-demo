package com.oreilly.headfirst.design.chp3;

/**
 * @AUTHOR liuling
 * @DATE 2019/1/24 00:17
 * @PROJECT studydemo
 **/
public class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "DarkRoast";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
