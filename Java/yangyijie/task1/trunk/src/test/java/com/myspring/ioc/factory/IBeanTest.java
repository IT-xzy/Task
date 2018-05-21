package com.myspring.ioc.factory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Arike
 * Create_at 2017/11/28 18:15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/myspring/ioc/factory/IbeanSpring.xml")
public class IBeanTest {
    @Autowired
    ApplicationContext ctx;
    
    @Test
    public void constructorFactory() throws Exception {
        ctx.getBean("imp1", BeanImp1.class);
    }
    
    @Test
    public void staticFactory() throws Exception {
        ctx.getBean("imp2", IBean.class);
    }
    
    @Test
    public void factory() throws Exception {
        ctx.getBean("imp3", IBean.class);
    }
    
    @Test
    public void localSessionFactory() throws Exception {
        ctx.getBean("imp4", IBean.class);
    }
    
}