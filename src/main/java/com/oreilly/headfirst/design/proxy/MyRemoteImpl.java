package com.oreilly.headfirst.design.proxy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019/10/21 09:57
 * @changeRecord
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

    public MyRemoteImpl() throws RemoteException {
        try {
            MyRemote service = new MyRemoteImpl();
            Naming.rebind("RemoteHello", service);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            MyRemote service1 = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public MyRemoteImpl(int port) throws RemoteException {
        super(port);
    }

    public MyRemoteImpl(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    /**
     * @return
     * @throws RemoteException
     */
    @Override
    public String sayHello() throws RemoteException {
        return "Server says : 'Hey!'";
    }

}
