package com.designpattern.build;

import java.util.ArrayList;

/**
 * @author dongyl
 * @date 19:55 1/9/19
 * @project study-demo
 */
public abstract class CarModel {
    private ArrayList<String> sequence = new ArrayList<>();
    protected abstract void start();
    protected abstract void stop();
    protected abstract void alarm();
    protected abstract void engineBoom();
//    final static String CAR_START = "start";
//    final static String CAR_STOP = "stop";
//    final static String CAR_ALARM = "alarm";
//    final static String CAR_ENGINE_BOOM = "boom";
    final public void run(){
        for (int i = 0; i < this.sequence.size(); i++) {
            String actionName = sequence.get(i);
            if(CarStateEnum.CAR_START.getCode().equalsIgnoreCase(actionName)){
                this.start();
            }else if(CarStateEnum.CAR_STOP.getCode().equalsIgnoreCase(actionName)){
                this.stop();
            }else if(CarStateEnum.CAR_ALARM.getCode().equalsIgnoreCase(actionName)){
                this.alarm();
            }else if(CarStateEnum.CAR_ENGINE_BOOM.getCode().equalsIgnoreCase(actionName)){
                this.engineBoom();
            }
        }
    }

    final public void setSequence(ArrayList<String> sequence) {
        this.sequence = sequence;
    }
}
