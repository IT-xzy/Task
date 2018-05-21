package com.myspring.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Arike
 * Create_at 2017/11/28 10:07
 */
//告诉JVM,spring测试是运行在JVM上
@RunWith(SpringJUnit4ClassRunner.class)
//告诉spring去什么地方寻找配置.
@ContextConfiguration("classpath:com/myspring/demo/IHello.xml")
public class IHelloTest {
    @Test
    public void say() throws Exception {
        IHello he = new HelloImp();
        he.say();
    }
    
    @Test
    //老测试方法.
    public void springSay() throws Exception {
        IHello he =null;
        Resource resource = new ClassPathResource("Springcon.xml");
        BeanFactory bean = new XmlBeanFactory(resource);
       //通过bean名称查找
        //IHello he = (HelloImp) bean.getBean("helloImp");
        //通过类型去找
        //通过bean名称+类型去找
        he = bean.getBean("helloImp2", HelloImp.class);
        he.say();
    }
   
    //以下是用spring测试的方式
    //自动去配置文件中匹配,需要匹配那个就用哪个bean的id.
    @Autowired
    IHello helloImp2;
    @Autowired
    IHello baoda1;
    @Test
    public void springTest()throws Exception{
       //aoda1.say();
        helloImp2.say();
    }
}