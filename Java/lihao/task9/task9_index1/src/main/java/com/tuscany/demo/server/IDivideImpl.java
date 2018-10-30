package com.tuscany.demo.server;

/**
 * #Title: IDivideImpl
 * #ProjectName task9_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/10/13-9:05
 */


public class IDivideImpl implements IDivide {
    @Override
    public Double divide(Double a, Double b) {
        if(b != 0){
            return a/b;
        }
        return 0d;
    }
}
