package com.oreilly.headfirst.design.combined.djview;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019/10/25 12:26
 * @changeRecord
 */
public class MallardDuck  implements Quackable {
    Observerable observerable;

    public MallardDuck() {
        this.observerable = new Observerable();
    }

    @Override
    public void quack() {
        System.out.println("Quark");
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observerable.registerObserver();
    }
}
