package com;

import cn.jnshu.ssm.mapper.UserMapper;
import cn.jnshu.ssm.po.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMapperTest {
    private ApplicationContext applicationContext;

    //在setUp这个方法中得到spring容器
    @Before
    public void setUp() throws Exception{
        applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
    }
    //根据id查询信息
    @Test
    public void testFindUserById() throws Exception {
        UserMapper userMapper=(UserMapper)applicationContext.getBean("userMapper");

        //调用userDao的方法
        User user=userMapper.findUserById(1);
        System.out.println(user);
    }

    //添加用户
    @Test
    public void testInterUser() throws Exception {
        UserMapper userMapper=(UserMapper)applicationContext.getBean("userMapper");

        User user=new User();
        user.setId(2);
        user.setUsername("asd");

        //调用userDao的方法
        userMapper.insertUser(user);
//      System.out.println(user);
    }

    //删除用户

    @Test
    public void testDeleteUser() throws Exception {
        UserMapper userMapper=(UserMapper)applicationContext.getBean("userMapper");

        //调用userDao的方法
        userMapper.deleteUser(1);

    }

}
