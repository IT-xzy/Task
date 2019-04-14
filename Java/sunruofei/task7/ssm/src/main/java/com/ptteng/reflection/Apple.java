package com.ptteng.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @ClassName Apple
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/3/14  21:54
 * @Version 1.0
 **/
public class Apple {

    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static void main(String[] args) throws Exception{
        //正常的调用
        Apple apple = new Apple();
        apple.setPrice(5);
        System.out.println("Apple Price:" + apple.getPrice());

        //使用反射调用
        Class clz = Class.forName("com.ptteng.reflection.Apple");
        Method setPriceMethod = clz.getMethod("setPrice", int.class);
        Constructor appleConstructor = clz.getConstructor();
        Object appleObj = appleConstructor.newInstance();
        setPriceMethod.invoke(appleObj, 14);
        Method getPriceMethod = clz.getMethod("getPrice");
        System.out.println("Apple Price:" + getPriceMethod.invoke(appleObj));
        //上面两段代码的执行结果，其实是完全一样的。但是其思路完全不一样，
        // 第一段代码在未运行时就已经确定了要运行的类（Apple），
        // 而第二段代码则是在运行时通过字符串值才得知要运行的类（com.ptteng.reflection.Apple）。
    }
}
