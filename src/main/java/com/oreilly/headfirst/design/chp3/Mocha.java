package com.oreilly.headfirst.design.chp3;

/**
 * @AUTHOR liuling
 * @DATE 2019/1/24 00:07
 * @PROJECT studydemo
 **/
public class Mocha extends CondimentDecorator{
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+", Mocha";
    }

    public double cost(){
        return .20 +beverage.cost();
    }
}
