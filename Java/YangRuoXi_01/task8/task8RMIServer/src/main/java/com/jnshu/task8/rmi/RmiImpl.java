package com.jnshu.task8.rmi;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

public class RmiImpl extends UnicastRemoteObject implements Hello {

    public RmiImpl() throws RemoteException{
    }

    public RmiImpl(int port) throws RemoteException {
        super(port);
    }

    public RmiImpl(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    @Override
    public String helloWorld() throws RemoteException {
        return "Hello World!";
    }

    @Override
    public String getPersonaInfo(Map<String, Object> infoMap) throws RemoteException {
        return "name : " + infoMap.get("name") + " age : " + infoMap.get("age");
    }
}
