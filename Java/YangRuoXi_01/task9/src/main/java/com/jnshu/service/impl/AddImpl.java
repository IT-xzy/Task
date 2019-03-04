package com.jnshu.service.impl;

import com.jnshu.service.Add;

public class AddImpl implements Add {
    @Override
    public Integer add(Integer i1, Integer i2) {
        return i1 + i2;
    }
}
