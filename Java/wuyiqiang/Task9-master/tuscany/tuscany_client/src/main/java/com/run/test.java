package com.run;

import com.service.Sca;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author Arike
 * Create_at 2018/2/8 16:18
 */
public class test {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Sca sca = (Sca) Naming.lookup("rmi://127.0.0.1:8888/Sca1");
        System.out.println(sca.idiom());
    }
}