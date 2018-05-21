package com.myspring.ioc.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author Arike
 * Create_at 2017/11/28 18:39
 */

public class BeanImp4SessionFactory implements FactoryBean<BeanImp4> {
    
    @Override
    public BeanImp4 getObject() throws Exception {
        return new BeanImp4();
    }
    
    @Override
    public Class<?> getObjectType() {
        return BeanImp4.class;
    }
    
    @Override
    public boolean isSingleton() {
        return true;
    }
}
