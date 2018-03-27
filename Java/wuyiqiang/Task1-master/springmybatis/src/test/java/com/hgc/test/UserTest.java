package com.hgc.test;

import com.hgc.dao.UserDao;
import com.hgc.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class UserTest {
    public static void main(String[] args) {
        SqlSession session = getSqlSessionFactory().openSession();
        try {
            /*
            User user = session.selectOne("findById",2);
            session.commit();
            System.out.println(user.getName());
            */
            /*
            UserDao userDao = session.getMapper(UserDao.class);
            User user = userDao.findById(2);
            System.out.println(user.getName());
            */
            User user = new User();
            user.setName("王五");
            user.setAge(45);
            UserDao userDao = session.getMapper(UserDao.class);
            userDao.insertUser(user);
            session.commit();
        } finally {
            session.close();
        }

        User user = new User();
        user.setName("王五");
        user.setAge(45);
    }

    private static SqlSessionFactory getSqlSessionFactory(){
        String resource = "mybatis-config.xml";
        Reader reader = null;
        SqlSessionFactory sqlSessionFactory = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch (IOException e){
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }
}
