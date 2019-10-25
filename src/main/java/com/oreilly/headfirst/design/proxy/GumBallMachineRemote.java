package com.oreilly.headfirst.design.proxy;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author dongyl
 * @date 21:45 2019-02-06
 * @project study-demo
 */
public interface GumBallMachineRemote extends Remote {

    /**
     * @return
     * @throws RemoteException
     */
    public int getCount() throws RemoteException;

    /**
     * @return
     * @throws RemoteException
     */
    public String getLocation() throws RemoteException;

    /**
     * @return
     * @throws RemoteException
     */
    public String getState() throws RemoteException;
}
