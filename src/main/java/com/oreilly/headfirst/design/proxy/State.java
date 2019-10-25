package com.oreilly.headfirst.design.proxy;

import java.io.Serializable;

/**
 * @author dongyl
 * @date 14:46 2019-02-03
 * @project study-demo
 */
public interface State extends Serializable {
    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();

}
