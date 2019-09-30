package com.oreilly.headfirst.design.chp6;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019-09-26 09:39
 * @changeRecord
 */
public class StereoOnWithCDCommand implements Command{
    Stereo stereo;
    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }
}
