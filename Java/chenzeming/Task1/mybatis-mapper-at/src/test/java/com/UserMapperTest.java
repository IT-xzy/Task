package com;

import cn.jnshu.ssm.mapper.UserMapper;
import cn.jnshu.ssm.po.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

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
        user.setId(1);
        user.setUsername("asd");

        //调用userDao的方法
        System.out.println(userMapper.insertUser(user));

    }

    //删除用户

    @Test
    public void testDeleteUser() throws Exception {
        UserMapper userMapper=(UserMapper)applicationContext.getBean("userMapper");

        //调用userDao的方法
        userMapper.deleteUser(1);

    }

    //查询全部用户
    @Test
    public void testSelectAll()throws Exception{
        UserMapper userMapper=(UserMapper)applicationContext.getBean("userMapper");
        List<User> user= userMapper.findAll();
        System.out.println(user);
    }

    //模糊查询用户
    @Test
    public void testFindUserName() throws Exception{
        UserMapper userMapper=(UserMapper)applicationContext.getBean("userMapper");
        List<User> user=userMapper.findUserName("庄");
        System.out.println(user);
    }


    //更改信息
    @Test
    public void  testUpdateUser() throws Exception{
        UserMapper userMapper=(UserMapper)applicationContext.getBean("userMapper");
        User user=new User();
        user.setId(5);
        user.setUsername("李四");
        userMapper.updateUser(user);
    }



}
