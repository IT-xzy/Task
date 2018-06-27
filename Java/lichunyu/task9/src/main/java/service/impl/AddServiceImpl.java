package service.impl;

import service.AddService;

public class AddServiceImpl implements AddService {
    @Override
    public double add(double a, double b) {
        return a+b;
    }
}
