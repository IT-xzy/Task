package com.jnshu.zwp.impl;

import com.jnshu.zwp.dao.UserDao;
import com.jnshu.zwp.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class UserDaoImpl implements UserDao {
    public User findUserById(int id) throws Exception {
        String resource = "SqlMapperMybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        //---------------
        User user = session.selectOne("user.findUserById",id); //参数一：namespace.id
        //--------------
        session.close();
        return user;
    }

    public List<User> findAllUsers() throws Exception {
        String resource = "SqlMapperMybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        //---------------------
        List<User> users = session.selectList("user.findUserAll");
        //----------------------
        session.close();
        return users;
    }

    public void insertUser(User user) throws Exception {
        String resource = "SqlMapperMybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        //---------------------
        session.insert("user.insertUser", user);
        session.commit();   //增删改，一定一定要加上commit操作
        //----------------------
        session.close();
    }

    public void deleteUserById(int id) throws Exception {
        String resource = "SqlMapperMybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        //---------------------
        session.delete("user.deleteUserById", id);
        session.commit();   //增删改，一定一定要加上commit操作
        //----------------------
        session.close();
    }

    public void updateUserEmp(User user) throws Exception {
        String resource = "SqlMapperMybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        //---------------------
        session.update("user.updateUserEmp", user);
        session.commit();   //增删改，一定一定要加上commit操作
        //----------------------
        session.close();
    }
}

