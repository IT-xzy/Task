package com.client;

import java.rmi.Remote;
public interface ServerRmiI extends Remote{
    public String sayHi(String name) throws java.rmi.RemoteException;
}
