package com.myspring.ioc.factory;

/**
 * @author Arike
 * Create_at 2017/11/28 18:31
 */
public class BeanImp3Factory {
    //通过实例工厂方式获取BeanImp3实例化对象
    public BeanImp3 getBeanImp3() {
        return new BeanImp3();
    }
}
