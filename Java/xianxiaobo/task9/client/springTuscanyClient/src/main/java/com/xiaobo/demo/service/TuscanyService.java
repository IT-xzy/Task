package com.xiaobo.demo.service;

import org.springframework.stereotype.Service;

import java.rmi.Naming;

@Service
public class TuscanyService {
    public ICalculator getCalculatorService(){
        try{
            System.out.println("calculator");
            return (ICalculator) Naming.lookup("//182.61.19.92:8099/CalculatorRMIService");
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
