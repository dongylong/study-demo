package com.oreilly.headfirst.design.chp7.adapter.test;

import com.oreilly.headfirst.design.chp7.adapter.bean.Duck;
import com.oreilly.headfirst.design.chp7.adapter.bean.MallardDuck;
import com.oreilly.headfirst.design.chp7.adapter.bean.WildTurkey;
import com.oreilly.headfirst.design.chp7.adapter.adapter.TurkeyAdapter;

/**
 * @author dongyl
 * @date 12:46 1/27/19
 * @project study-demo
 */
public class DuckTestDrive {
    public static void main(String[] args) {
        MallardDuck duck = new MallardDuck();
        WildTurkey wildTurkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(wildTurkey);
        System.out.println("the turkey says...");
        wildTurkey.gobble();
        wildTurkey.fly();
        System.out.println("the duck says....");
        testDuck(duck);
        System.out.println("the turkeyAdapter says....");
        testDuck(turkeyAdapter);
    }

    private static void testDuck(Duck turkeyAdapter) {
        turkeyAdapter.quack();
        turkeyAdapter.fly();
    }

}
