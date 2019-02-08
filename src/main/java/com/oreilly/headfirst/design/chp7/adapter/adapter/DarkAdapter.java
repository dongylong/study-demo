package com.oreilly.headfirst.design.chp7.adapter.adapter;

import com.oreilly.headfirst.design.chp7.adapter.bean.Duck;
import com.oreilly.headfirst.design.chp7.adapter.bean.Turkey;

/**
 * @author dongyl
 * @date 12:51 1/27/19
 * @project study-demo
 */
public class DarkAdapter implements Turkey {
    Duck duck;

    public DarkAdapter(Duck duck) {
        this.duck = duck;
    }

    @Override
    public void gobble() {
        for (int i = 0; i < 2; i++) {
            duck.quack();
        }
    }

    @Override
    public void fly() {
        duck.fly();
    }
}
