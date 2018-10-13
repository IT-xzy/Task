package com.tuscany.demo.client;

import com.tuscany.demo.server.ICalculator;
import com.tuscany.demo.server.ICalculatorImpl;

/**
 * #Title: CalculatorClient
 * #ProjectName task9_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/10/13-8:58
 */


public class CalculatorClient {
    public static void main(String[] args) {
        SCADomain domain = SCADomain.newInstance("calculator.composite");
        ICalculator c = domain.getService(ICalculatorImpl.class, "CalculatorServiceComponent");
    }
}
