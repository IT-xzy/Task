package com.suger.service.impl;

import com.suger.service.MultiplyService;
import org.oasisopen.sca.annotation.Service;

/**
 * @author suger
 * @date 2019/1/6 20:35
 */
public class MultiplyServiceImpl implements MultiplyService {
    @Override
    public double multiply(double n1, double n2) {
        return n1 * n2;
    }
}
