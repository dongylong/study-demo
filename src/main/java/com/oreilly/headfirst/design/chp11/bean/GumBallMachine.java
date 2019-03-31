//package com.oreilly.headfirst.design.chp11.bean;
//
//import com.oreilly.headfirst.design.chp11.GumBallMachineRemote;
//
//import java.rmi.RemoteException;
//import java.rmi.server.RMIClientSocketFactory;
//import java.rmi.server.RMIServerSocketFactory;
//import java.rmi.server.UnicastRemoteObject;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * @author dongyl
// * @date 14:49 2019-02-03
// * @project study-demo
// */
//public class GumBallMachine extends UnicastRemoteObject implements GumBallMachineRemote {
//
//    protected GumBallMachine() throws RemoteException {
//    }
//
//    protected GumBallMachine(int port) throws RemoteException {
//        super(port);
//    }
//
//    protected GumBallMachine(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
//        super(port, csf, ssf);
//    }
//
//    public static void main(String[] args) {
//        Set<String> setTest = new HashSet<>();
//        setTest.add("test");
//        String xx = "123";
//        setTest.contains(xx);
//    }
//}
//
