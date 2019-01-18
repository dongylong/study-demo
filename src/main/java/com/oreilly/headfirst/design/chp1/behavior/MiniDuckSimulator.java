package com.oreilly.headfirst.design.chp1.behavior;

import com.oreilly.headfirst.design.chp1.bean.Duck;

/**
 * @AUTHOR liuling
 * @DATE 2019/1/17 11:28
 * @PROJECT studydemo
 **/
public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck millard = new MallardDuck();
        millard.performQuark();
        millard.performFly();
    }
}
