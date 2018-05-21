package com.myspring.ioc.factory;

/**
 * @author Arike
 * Create_at 2017/11/28 18:11
 */
public class BeanImp1 implements IBean {
    //通过类本身构造器实例化
    public BeanImp1(){
        System.out.println("BeanImp1实例化");
    }
}
