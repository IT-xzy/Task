package com.jnshu.task8.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface Hello extends Remote{
    public String helloWorld()throws RemoteException;

    public String getPersonaInfo(Map<String ,Object > infoMap) throws RemoteException;
}
