package com.task;

import com.task.tuscany.server.ICalculator;
import com.task.tuscany.server.IHelloWorld;

import java.rmi.Naming;

public class CalculatorClient {
    public static void main(String[] args) throws Exception{
        ICalculator c= (ICalculator) Naming.lookup("//127.0.0.1:8099/CalculatorRMIService");
        System.out.println(c.add(1, 2));

        IHelloWorld h=(IHelloWorld)Naming.lookup("//127.0.0.1:8099/HelloWorldRMIService");
        System.out.println(h.sayHello("spring"));
    }
}
