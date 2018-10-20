package com.lihoo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args)
            throws RemoteException, NotBoundException, MalformedURLException {
        CalculatorService calculatorService = (CalculatorService) Naming.lookup("//127.0.0.1:9999/CalculatorRMIService");
        System.out.println("客户端调用输出");
        System.out.println(calculatorService.add(12,38));
        System.out.println(calculatorService.subtract(19,84));
        System.out.println(calculatorService.multiply(4,22));
        System.out.println(calculatorService.divide(50,2));
    }
}
