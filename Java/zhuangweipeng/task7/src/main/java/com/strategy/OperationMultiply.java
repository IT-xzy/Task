package com.strategy;

public class OperationMultiply implements Strategy{

    @Override
    public int doOperation(int num1, int num2) {
        System.out.println("相乘");
        return num1 * num2;
    }
}
