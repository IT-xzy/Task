package com.mybatis_spring.controller;

import com.mybatis_spring.bean.Student;
import com.mybatis_spring.dao.IStudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Arike
 * Create_at 2017/12/5 20:54
 */
public class add {
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/mybatis_spring/dao/mybaits-spring.xml");
        IStudentDao dao = ctx.getBean("studentDao",IStudentDao.class);
        dao.insertStudent(new Student(100L, 100L, "何人", "4456", "火星", 100L, "盲人技校", "Java001", "www.baidu.com", "一二三似物流", "杨以杰", "翻墙过来的"));
    }
}
