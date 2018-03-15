package com.myspring.di.properties;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Arike
 * Create_at 2017/11/29 18:11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/myspring/di/properties/StudentSpring.xml")


public class IStudentTest {
    private Logger logger = Logger.getLogger(IStudentTest.class);

    @Autowired
    ApplicationContext ctx;
   
    @Test
    public void BeanProperties()throws Exception {
        //下面生成IOC容器的方法是不是用Spring的方式,使用了Spring就使用注解.
       /* ApplicationContext ctx = new ClassPathXmlApplicationContext("classpth:com/myspring/di/properties/StudentSpring.xml");*/
        logger.info(ctx.getBean("student1",IStudent.class));
    }
    
    @Test
    public void BeanConstractor()throws Exception {
        logger.info(ctx.getBean("student2",IStudent.class));
    }
    
    @Test
    public void BeanReferenceImpl()throws Exception {
        ctx.getBean("student3",StudentReferenceImpl.class).studentUtil.run();
    }
    @Test
    public void ConnectionBean()throws Exception {
        logger.info(ctx.getBean("connection",ConnectionBean.class));
    }
}