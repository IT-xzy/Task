package com.suger.service.impl;

import com.suger.service.SubtractService;
import org.oasisopen.sca.annotation.Service;

/**
 * @author suger
 * @date 2019/1/6 20:37
 */
public class SubtractServiceImpl implements SubtractService {

    @Override
    public double subtract(double n1, double n2) {
        return n1-n2;
    }
}
