package com.oreilly.headfirst.design.proxy;


import com.oreilly.headfirst.design.chp10.bean.GumBallMachine;

import java.rmi.Naming;

/**
 * @author dongyl
 * @date 22:05 2019-02-05
 * @project study-demo
 */
public class GumballMachineTestDrive {
    public static void main(String[] args) {
        String[] location = {
                "localhost/gumballmachine",
                "127.0.0.1/gumballmachine",
                ""
        };
        GumballMonitor[] monitor = new GumballMonitor[location.length];

        for (int i = 0; i < location.length; i++) {
            try {
                GumBallMachineRemote remote = (GumBallMachineRemote) Naming.lookup(location[i]);//new GumBallMachineRemote();
                GumBallMachine gumBallMachine = new GumBallMachine(remote);
                monitor[i] = new GumballMonitor(remote);
                System.out.println(monitor[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < location.length; i++) {
            monitor[i].report();
        }
    }
}