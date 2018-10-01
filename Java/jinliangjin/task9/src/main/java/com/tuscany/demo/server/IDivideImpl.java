package com.tuscany.demo.server;

/**
 * @ClassName: IDivideImpl
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/7/4 11:10
 * @Version: 1.0
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
