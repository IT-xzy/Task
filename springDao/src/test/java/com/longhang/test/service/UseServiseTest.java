package com.longhang.test.service;

import com.longhang.test.dao.UseDao;
import com.longhang.test.dao.impl.UseDaoImpl;
import com.longhang.test.service.impl.UseServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseServiseTest
{
    private BeanFactory factory=null;
    @Before
    public void before()
    {
        factory =new ClassPathXmlApplicationContext("applicationContext.xml");

    }
    @Test //sping 框架调用.xml文件创建对象
    public void testSpring(){
        UseServiceImpl useService=(UseServiceImpl) factory.getBean("useService");
        useService.processMathod();
    }
    @Test // 自己调用new方法创建对象
    public  void test()
    {
        UseDaoImpl useDao=new UseDaoImpl();
        useDao.mathod();
        UseServiceImpl useService=new UseServiceImpl();
        useService.processMathod();
    }



}
