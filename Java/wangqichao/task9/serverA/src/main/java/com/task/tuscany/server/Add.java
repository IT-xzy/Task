package com.task.tuscany.server;

import org.springframework.stereotype.Service;

@Service
public class Add implements IAdd{
    @Override
    public double add(double a, double b) {
        return a+b;
    }
}
