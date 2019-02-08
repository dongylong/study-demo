package com.oreilly.headfirst.design.chp7.adapter.bean;

/**
 * @author dongyl
 * @date 12:42 1/27/19
 * @project study-demo
 */
public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println(" gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("i am flying a short distance");
    }
}
