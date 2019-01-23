package com.oreilly.headfirst.design.chp2;


import java.util.Observable;
import java.util.Observer;

/**
 * @AUTHOR liuling
 * @DATE 2019/1/22 01:08
 * @PROJECT studydemo
 **/
public class CurrentConditionsDisplay implements Observer,DisplayElement {
    Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData){
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("current condition : " +temperature+" F degree and " + humidity + "% humidity");
    }
}
