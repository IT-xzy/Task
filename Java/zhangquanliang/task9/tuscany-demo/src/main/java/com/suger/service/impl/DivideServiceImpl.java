package com.suger.service.impl;

import com.suger.service.DivideService;
import org.oasisopen.sca.annotation.Service;

/**
 * @author suger
 * @date 2019/1/7 10:02
 */
public class DivideServiceImpl implements DivideService {
    @Override
    public double divide(double n1, double n2) {
        return n1/n2;
    }
}
