package com.strategy;

public class OperationSubstract implements Strategy{
    @Override
    public int doOperation(int num1,int num2){
        System.out.println("相减");
        return num1-num2;
    }
}
