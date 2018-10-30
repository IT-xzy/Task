package com.lihoo.ssm.service.impl;

import com.lihoo.ssm.service.RmiService;

/**
 * #Title: RmiServiceImpl
 * #ProjectName task6_index4
 * #Description: TODO
 * #author lihoo
 * #date 2018/10/12-13:29
 */


public class RmiServiceImpl implements RmiService {
    @Override
    public String doWork() {
        return "this message return from server";
    }

    @Override
    public int add(int a, int b) {
        return a+b;
    }
}
