package com.oreilly.headfirst.design.chp11;


import com.oreilly.headfirst.design.chp10.bean.GumBallMachine;

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
        for (int i = 0; i < location.length; i++) {
            try {
                GumBallMachineRemote remote = new GumBallMachineRemote();
                GumBallMachine gumBallMachine = new GumBallMachine(remote);
                GumballMonitor monitor = new GumballMonitor(gumBallMachine);
                monitor.report();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
