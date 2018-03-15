package com.myspring.ioc.initialize;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author Arike
 * Create_at 2017/11/28 15:32
 */
public class ISomebeanTest {
    @Test
    //测试使用Beanfactory获取bean初始化时机
    public void testBeanfactory() throws Exception {
        Resource resource = new ClassPathResource("springcon.xml");
        //获取到Factory对象时并不会初始话bean类.
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        //在获取到bean对象的时候才会初始化.
        ISomebean isb = beanFactory.getBean("some1", SomeBeanImp.class);
    }
    @Test
    //测试使用ApplicationContext获取bean的初始化时机
    public void testApplicationContext()throws Exception {
        //生成ApplicationContext对象就会直接初始化所有bean
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/myspring/ioc/initialize/ISomeBean.xml");
        //因为在配置中设置some1为延迟初始化了,所以要在获取bean的时候才会初始化.
        //ctx.getBean("some1", SomeBeanImp.class);
    }
}