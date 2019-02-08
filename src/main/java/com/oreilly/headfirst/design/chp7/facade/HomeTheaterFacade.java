package com.oreilly.headfirst.design.chp7.facade;

/**
 * @author dongyl
 * @date 14:25 1/27/19
 * @project study-demo
 */
public class HomeTheaterFacade {
    Amplifier amp;
    Tuner tuner;
    DvdPlay dvdPlay;
    CdPlayer cdPlayer;
    Projector projector;
    ThreaterLights lights;
    Screen screen;
    PopcornPopper popper;

    public HomeTheaterFacade(Amplifier amp, Tuner tuner, DvdPlay dvdPlay, CdPlayer cdPlayer, Projector projector, ThreaterLights lights, Screen screen, PopcornPopper popper) {
        this.amp = amp;
        this.tuner = tuner;
        this.dvdPlay = dvdPlay;
        this.cdPlayer = cdPlayer;
        this.projector = projector;
        this.lights = lights;
        this.screen = screen;
        this.popper = popper;
    }
    public  void watchMovie(String movie){
        System.out.println("get ready to watch a movie...");
        popper.on();
        popper.pop();
        lights.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setDvd(dvdPlay);
        amp.setSurroundSound();
        amp.setVolumn(5);
        dvdPlay.on();
        dvdPlay.play(movie);
    }
    public void endMovie(){
        System.out.println("Shutting movie theater down ..");
        popper.off();
        lights.on();
        screen.up();
        projector.off();
        amp.off();
        dvdPlay.stop();
        dvdPlay.eject();
        dvdPlay.off();
    }
}
