package com.lihoo.jnshu;

import com.lihoo.jnshu.service.IBaseService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class BaseServiceTest
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IBaseService ibs = (IBaseService) context.getBean("baseRmiService");
        System.out.println("baseRmiService启动...");
    }
}
