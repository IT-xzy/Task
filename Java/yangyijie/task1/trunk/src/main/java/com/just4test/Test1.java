package com.just4test;

/**
 * @author Arike
 * Create_at  2017/11/18 22:09
 */
public class Test1 {
    public static Test1 t1 = new Test1();
    public static Test1 t2 = new Test1();
    
    {
        System.out.println("构造块");
    }
    
    static {
        System.out.println("静态块");
    }
    
    public static void main(String[] args) {
        Test1 t = new Test1();
    }
}