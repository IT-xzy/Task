package com.myspring.ioc_zero;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author Arike
 * Create_at 2017/12/3 16:57
 */
@Component
public class SomeBeanFactory implements FactoryBean<SomeBean> {
    
    @Override
    public SomeBean getObject() throws Exception {
        return new SomeBean();
    }
    
    @Override
    public Class<?> getObjectType() {
        return SomeBean.class;
    }
    
    @Override
    public boolean isSingleton() {
        return true;
    }
}
