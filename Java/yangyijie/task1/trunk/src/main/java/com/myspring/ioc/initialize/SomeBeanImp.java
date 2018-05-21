package com.myspring.ioc.initialize;

/**
 * @author Arike
 * Create_at 2017/11/28 15:30
 */
public class SomeBeanImp implements ISomebean {
    //用于测试bean初始化的时机,生成Beanfactory并不会初始化bean类,在使用的时候才会初始化.
    {
        System.out.println("bean初始化加载");
    }
}
