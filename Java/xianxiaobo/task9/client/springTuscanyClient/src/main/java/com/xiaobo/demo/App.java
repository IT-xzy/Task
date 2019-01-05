package com.xiaobo.demo;

import com.xiaobo.demo.service.ICalculator;

import java.rmi.Naming;

public class App {
    public static void main(String[] args) throws Exception {
        ICalculator c= (ICalculator) Naming.lookup("//182.61.19.92:8099/CalculatorRMIService");
        System.out.println(c.add(4, 2));
    }
}
