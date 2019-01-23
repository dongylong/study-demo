package com.oreilly.headfirst.design.chp3;

/**
 * @AUTHOR liuling
 * @DATE 2019/1/24 00:03
 * @PROJECT studydemo
 **/
public abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }
    public abstract double cost();
}
