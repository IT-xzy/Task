package com.jnshu.service.impl;

import com.jnshu.service.Time;

public class TimeImpl implements Time {
    @Override
    public Integer time(Integer i1, Integer i2) {
        return i1 * i2;
    }
}
