package com.oreilly.headfirst.design.chp2;

import com.oreilly.headfirst.design.chp2.observer.Impl.CurrentConditionDisplay;
import com.oreilly.headfirst.design.chp2.observer.Impl.WeatherDate;

/**
 * @author dongyl
 * @date 00:04 1/20/19
 * @project study-demo
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherDate weatherDate = new WeatherDate();

        CurrentConditionDisplay currentDisplay = new CurrentConditionDisplay(weatherDate);
//        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherDate);
//        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherDate);
        weatherDate.setMeasurements(80,65,30.4f);
        weatherDate.setMeasurements(82,70,29.2f);
        weatherDate.setMeasurements(78,90,29.2f);
    }
}
