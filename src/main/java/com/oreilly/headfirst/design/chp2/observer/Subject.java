package com.oreilly.headfirst.design.chp2.observer;

/**
 * @author dongyl
 * @date 23:43 1/19/19
 * @project study-demo
 */
public interface Subject {
    void registerObserver(Object o);
    void removeObserver(Object o);
    void notifyObserver();
}
