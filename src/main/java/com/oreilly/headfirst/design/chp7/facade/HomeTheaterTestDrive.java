package com.oreilly.headfirst.design.chp7.facade;

/**
 * @author dongyl
 * @date 14:34 1/27/19
 * @project study-demo
 */
public class HomeTheaterTestDrive {
    public static void main(String[] args) {
        Amplifier amp = new Amplifier();
        Tuner tuner = new Tuner();
        DvdPlay dvdPlay = new DvdPlay();
        CdPlayer cdPlayer = new CdPlayer();
        Projector projector = new Projector();
        ThreaterLights lights = new ThreaterLights();
        Screen screen = new Screen();
        PopcornPopper popper = new PopcornPopper();
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(amp, tuner, dvdPlay, cdPlayer, projector, lights, screen, popper);
        homeTheaterFacade.watchMovie("Raiders of the Lost Ark");
        homeTheaterFacade.endMovie();

    }
}
