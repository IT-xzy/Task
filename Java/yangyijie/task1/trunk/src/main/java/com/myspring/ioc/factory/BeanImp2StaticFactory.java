package com.myspring.ioc.factory;

/**
 * @author Arike
 * Create_at 2017/11/28 18:21
 */
public class BeanImp2StaticFactory {
    //私有静态工厂的构造
    private BeanImp2StaticFactory() {}
    //提供公开静态的工厂方法获取BeanImp3对象.
    public static BeanImp2 getBeanImp2() {
        return new BeanImp2();
    }
}
