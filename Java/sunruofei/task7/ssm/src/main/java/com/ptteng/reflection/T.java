package com.ptteng.reflection;

/**
 * @ClassName T
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/3/14  18:53
 * @Version 1.0
 **/
public class T {
    int i;
    String s;

    public T(){
        System.out.println(" T constructed");
    }

    public void m1P(int i){
        this.i = i;
    }
    public String getS(){
        return s;
    }
    public void mm (){
        System.out.println("m invoked");
    }
}
