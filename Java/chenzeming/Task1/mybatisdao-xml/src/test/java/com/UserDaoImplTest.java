package com;

import cn.jnshu.ssm.dao.UserDao;
import cn.jnshu.ssm.po.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoImplTest {

    private ApplicationContext applicationContext;



    //在setUp这个方法中得到spring容器

    @Before
    public void setUp() throws Exception{
        applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
    }

    @Test
    public void testFindUserById() throws Exception {
        UserDao userDao= (UserDao) applicationContext.getBean("userDao");

        //调用userDao的方法
       User user=userDao.findUserById(1);
       System.out.println(user);
    }

    //添加用户
    @Test
    public void testInsterUser() throws Exception {
        UserDao userDao=(UserDao) applicationContext.getBean("userDao");

        User user=new User();
        user.setId(11);
        user.setUsername("asd");

        //调用userDao的方法
        userDao.insertUser(user);
//      System.out.println(user);
    }

    //删除用户

    @Test
    public void testDeleteUser() throws Exception {
        UserDao userDao=(UserDao) applicationContext.getBean("userDao");
        //调用userDao的方法
        userDao.deleteUser(11);

    }


}
