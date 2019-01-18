package com.oreilly.headfirst.design.chp1.behavior.impl;

import com.oreilly.headfirst.design.chp1.behavior.QuackBehavior;

/**
 * @AUTHOR liuling
 * @DATE 2019/1/17 11:24
 * @PROJECT studydemo
 **/
public class Squack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("s quack");
    }
}
