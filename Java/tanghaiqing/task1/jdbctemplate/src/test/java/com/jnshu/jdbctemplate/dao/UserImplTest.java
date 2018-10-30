package com.jnshu.jdbctemplate.dao;

import com.jnshu.jdbctemplate.pojo.User;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class UserImplTest {
    ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
    UserDao userDao = (UserImpl) context.getBean("userImpl");
    @Before
    private User beFore(){
        return new User();
    }
    @Test
    void insert() {
        User user =new User();
        user.setName("tanghaiqing");
        user.setAge(20);
        user.setGender("men");
        user.setSalary(0000);
        System.out.println(userDao.insert(user));
        //断言
    }
    @Test
    void delect() {
        beFore().setId(10);
        System.out.println(userDao.delect(beFore()));
    }
    @Test

    void updata() {
        beFore().setId(7);
        beFore().setName("tanghaiqing");
        beFore().setAge(21);
        beFore().setGender("men");
        beFore().setSalary(-20000);
        System.out.println(userDao.updata(beFore()));
    }
    @Test
    void getAll() {
        System.out.println( userDao.getAll());
    }



}