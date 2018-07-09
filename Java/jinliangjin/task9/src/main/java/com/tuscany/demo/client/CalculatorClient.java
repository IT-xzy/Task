package com.tuscany.demo.client;

import com.tuscany.demo.server.ICalculator;
import com.tuscany.demo.server.ICalculatorImpl;

/**
 * @ClassName: CalculatorClient
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/7/4 11:20
 * @Version: 1.0
 */
public class CalculatorClient {
    public static void main(String[] args) {
        SCADomain domain = SCADomain.newInstance("calculator.composite");
        ICalculator c = domain.getService(ICalculatorImpl.class, "CalculatorServiceComponent");
    }
}
