package com.just4test;

/**
 * @author Arike
 * @time 2017/11/10 20:58
 */
public interface IMath {
    /**
     * 定义一个加法
     * @param arr  需要相加的可变参数
     * @return 和
     */
    int sum(int...arr);
    
    /**
     * 定义除法运算
     * @param a  被除数
     * @param b  除数
     * @return   商
     */
    int div(int a, int b);
    
}
