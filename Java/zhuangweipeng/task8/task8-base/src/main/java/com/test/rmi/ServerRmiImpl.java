package com.test.rmi;

public class ServerRmiImpl implements ServerRmiI{
    public String sayHi(String name) {//throws RemoteException
        return "Hello"+name;
    }
}
