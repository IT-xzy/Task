package com.xiaobo.demo.dto;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.xiaobo.demo.dto.User;
import com.xiaobo.demo.dao.UserDao;
import com.xiaobo.demo.dao.UserDaoImpl;

import java.io.IOException;
import java.io.Reader;
import java.io.InputStream ;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserDaoTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException{
        //创建sqlSessionFactory
        //MyBatis配置文件
        String resource = "mybatis-config.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂，传入MyBatis的配置信息
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void testSelectUserById() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //创建UserDao对象
//        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        //调用UserDao的方法，根据ID查找user
        User user = userDao.selectUserById(4);
        //打印客户信息
        System.out.println(user);
    }
    @Test
    public void testSelectUserByName() throws Exception{
        //创建UserDao对象
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        //调用UserDao的方法，根据ID查找user
        List<User> userList = userDao.selectUserByName("麻");
        //打印客户信息
        System.out.println(userList);
    }
    @Test
    public void testDeleteUserById() throws Exception{
        //创建UserDao对象
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        //调用UserDao的方法，根据ID查找user
        userDao.deleteUserById(2);
        //打印客户信息
        System.out.println("delete success");
    }
    @Test
    public void testInsertUser() throws Exception{
        //创建UserDao对象
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = new User();
        user.setName("王二麻子");
        user.setHope("麻婆豆腐");
        //调用UserDao的方法，根据ID查找user
        userDao.insertUser(user);
        //打印客户信息
        System.out.println("insert success");
    }
    @Test
    public void testUpdateUserById() throws Exception{
        //创建UserDao对象
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = new User();
        user.setId(11);
        user.setName("麻婆");
        user.setHope("真正的麻婆豆腐");
        //调用UserDao的方法，根据ID查找user
        userDao.updateUserById(user);
        //打印客户信息
        System.out.println("update success");
    }
}
