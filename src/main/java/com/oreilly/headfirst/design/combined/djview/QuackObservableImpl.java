package com.oreilly.headfirst.design.combined.djview;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019/10/28 09:10
 * @changeRecord
 */
public class QuackObservableImpl implements QuackObservable {
    ArrayList observers = new ArrayList();
    QuackObservable duck;

    public QuackObservableImpl(QuackObservable duck) {
        this.duck = duck;
    }

    public QuackObservableImpl(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {
        Iterator iterator = observers.iterator();
        while (iterator.hasNext()){
            Observer observer = (Observer) iterator.next();
            observer.update(duck);
        }

    }
}
