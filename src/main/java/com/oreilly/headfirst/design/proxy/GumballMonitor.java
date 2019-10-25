package com.oreilly.headfirst.design.proxy;

import com.oreilly.headfirst.design.chp10.bean.GumBallMachine;

import java.rmi.RemoteException;

/**
 * @author dongyl
 * @date 22:33 2019-02-05
 * @project study-demo
 */
public class GumballMonitor {
    GumBallMachine gumBallMachine;

    public GumballMonitor(GumBallMachine gumBallMachine) {
        this.gumBallMachine = gumBallMachine;
    }

    public void report(){
        System.out.println("Gumball machine :"+gumBallMachine.getLocation());
        System.out.println("current inventory:"+gumBallMachine.getCount() + " gumballs");
        System.out.println("Gumball machine state :"+gumBallMachine.getState());
    }


    GumBallMachineRemote machineRemote;

    public GumballMonitor(GumBallMachineRemote machineRemote) {
        this.machineRemote = machineRemote;
    }

    public void reportRemote(){
        try {
            System.out.println("Gumball machine :"+machineRemote.getLocation());
            System.out.println("current inventory:"+machineRemote.getCount() + " gumballs");
            System.out.println("Gumball machine state :"+machineRemote.getState());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

