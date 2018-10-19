package com.jnshu.service.impl;

import com.jnshu.service.Calculator;

public class CalculatorImpl implements Calculator {
    @Override
    public double add(double n1, double n2) {
        return n1+n2;
    }
}
