package com.jnshu.service;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MainClient {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Calculator c = (Calculator) Naming.lookup("rmi://127.0.0.1:8088/CalculatorService");
        System.out.println(c.add(3123,1234));
    }
}

