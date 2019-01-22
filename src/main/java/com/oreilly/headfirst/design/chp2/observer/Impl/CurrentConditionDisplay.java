package com.oreilly.headfirst.design.chp2.observer.Impl;

import com.oreilly.headfirst.design.chp2.observer.DisplayElement;
import com.oreilly.headfirst.design.chp2.observer.Observer;
import com.oreilly.headfirst.design.chp2.observer.Subject;

/**
 * @author dongyl
 * @date 00:00 1/20/19
 * @project study-demo
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {
    private float tmp;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("current conditions: " + tmp
                + "F degree and " + humidity + "% humidity");
    }

    @Override
    public void update(float tmp, float humidity, float pressure) {

    }
}
