package com.oreilly.headfirst.design.combined.djview;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019/10/28 09:18
 * @changeRecord
 */
public class Quackologist implements Observer {
    @Override
    public void update(QuackObservable duck) {
        System.out.println("Quackologist" + duck + "just quacked");
    }

}
