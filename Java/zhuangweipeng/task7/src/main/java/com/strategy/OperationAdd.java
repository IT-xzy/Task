package com.strategy;

public class OperationAdd implements Strategy {
        @Override
        public int doOperation(int num1, int num2) {
            System.out.println("相加");
            return num1 + num2;
        }
    }

