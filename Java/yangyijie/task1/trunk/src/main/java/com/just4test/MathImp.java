package com.just4test;

/**
 * @author Arike
 * @time 2017/11/10 21:01
 */
public class MathImp implements IMath {
    public int sum(int... arr) {
        int getsum = 0;
        for (int i = 0; i < arr.length; i++) {
            getsum += arr[i];
        }
        return getsum;
    }
    
    public int div(int a, int b) {
        return a / b;
    }
}
