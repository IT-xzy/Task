package com.springAOP2;

import org.springframework.stereotype.Component;

@Component
public class MyMath2 {
    //增
    public int add(int n1,int n2){
        int result=n1+n2;
        System.out.println(n1+"+"+n2+"="+result);
        return result;
    }
    public int del(int n1,int n2){
        int result=n1-n2;
        System.out.println(n1+"-"+n2+"="+result);
        return result;
    }
}
