package org.wyq.task.tuscany;

import org.springframework.stereotype.Component;
import org.wyq.task.service.BaseService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

@Component
public class Client {
    public BaseService getBaseService() throws RemoteException, NotBoundException, MalformedURLException {
        BaseService baseService = (BaseService) Naming.lookup("rmi://127.0.0.1:8888/Sca1");
        return baseService;
    }
}
