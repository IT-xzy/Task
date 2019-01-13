package com.suger.service.impl;

import com.suger.service.AddService;

/**
 * @author suger
 * @date 2019/1/7 10:01
 */
public class AddServiceImpl implements AddService {
    @Override
    public double add(double n1, double n2) {
        return n1+n2;
    }
}
