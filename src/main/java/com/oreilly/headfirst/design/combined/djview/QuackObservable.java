package com.oreilly.headfirst.design.combined.djview;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019/10/28 09:07
 * @changeRecord
 */
public interface QuackObservable {
    void registerObserver(Observer observer);
    void notifyObservers();

}
