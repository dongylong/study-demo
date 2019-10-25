package com.oreilly.headfirst.design.proxy;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019/10/21 09:57
 * @changeRecord
 */
public interface MyRemote  extends Remote {
    /**
     * @return
     * @throws RemoteException
     */
    String sayHello() throws RemoteException;

}
