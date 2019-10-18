package com.oreilly.headfirst.design.chp10;

/**
 * @author dongyl
 * @date 14:46 2019-02-03
 * @project study-demo
 */
public interface State {
    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();
}
