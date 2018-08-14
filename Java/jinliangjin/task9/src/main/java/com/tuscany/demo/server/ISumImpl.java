package com.tuscany.demo.server;

/**
 * @ClassName: ISumImpl
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/7/4 11:11
 * @Version: 1.0
 */
public class ISumImpl implements ISum {
    @Override
    public Double add(Double a, Double b) {
        return a + b;
    }
}
