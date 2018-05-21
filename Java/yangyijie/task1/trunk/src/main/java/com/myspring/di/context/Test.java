package com.myspring.di.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Arike
 * Create_at 2017/12/1 12:53
 */
public class Test {
    public static void main(String[] args)throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/myspring/di/context/mybatis-spring.xml");
        StudentMapper sm = (StudentMapper) ctx.getBean("studentDao");
        System.out.println(sm.getStudentById(81L));
    }
}
