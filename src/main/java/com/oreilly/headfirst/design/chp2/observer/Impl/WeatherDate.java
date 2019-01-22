package com.oreilly.headfirst.design.chp2.observer.Impl;

import com.oreilly.headfirst.design.chp2.observer.Observer;
import com.oreilly.headfirst.design.chp2.observer.Subject;

import java.util.ArrayList;

/**
 * @author dongyl
 * @date 23:47 1/19/19
 * @project study-demo
 */
public class WeatherDate implements Subject {
    private ArrayList<Observer> observers;
    private float tmp;
    private float humidity;
    private float pressure;

    @Override
    public void registerObserver(Object o) {
        observers = new ArrayList();
    }

    @Override
    public void removeObserver(Object o) {
        int i = observers.indexOf(0);
        if(i>=0){
            observers.remove(i);
        }
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = observers.get(i);
            observer.update(tmp,humidity,pressure);
        }
    }
    public void measurementsChanged(){
        notifyObserver();
    }

    public void  setMeasurements(float tmp, float humidity, float pressure) {
        this.tmp = tmp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
    //other WeatherData的其他方法
}
