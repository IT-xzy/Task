package com.test.rmi2;

import java.rmi.Remote;

public interface IHello extends Remote {
    public String sayHello(String name) throws java.rmi.RemoteException;
}
