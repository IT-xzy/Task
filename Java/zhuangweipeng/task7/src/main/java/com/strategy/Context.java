package com.strategy;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
        System.out.println("初始化strategy");
    }
    public int execteStrategy(int num1, int num2) {
        //System.out.println("execteStrategy"+execteStrategy(10,5));
        return strategy.doOperation(num1, num2);

    }

}

