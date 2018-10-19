package com.tuscany.demo.server;

/**
 * #Title: ISumImpl
 * #ProjectName task9_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/10/13-9:06
 */


public class ISumImpl implements ISum {
    @Override
    public Double add(Double a, Double b) {
        return a + b;
    }
}
