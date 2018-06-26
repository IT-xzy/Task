package com.dao;

import com.pojo.User1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class User1MapperTest {

    private static SqlSessionFactory sqlSessionFactory;
    private static InputStream inputStream;
//    private static SqlSession sqlSession;


    @Before
    public void before() {

        try {
            String resource = "mybatis-config2.xml";
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    @Test
    public void selectByIdTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User1Mapper user1Mapper = sqlSession.getMapper(User1Mapper.class);
        System.out.println(user1Mapper.selectById(3000));


    }

    @Test
    public void selectAllTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User1Mapper user1Mapper = sqlSession.getMapper(User1Mapper.class);
        List<User1> user1List = user1Mapper.selectAll();
        for (User1 user1 : user1List) {
            System.out.println(user1);
        }

    }

    @Test
    public void insertByIdTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User1Mapper user1Mapper = sqlSession.getMapper(User1Mapper.class);
        User1 user1 = new User1();
        user1.setName("小兰");
        user1.setPassword("122");
        user1.setBirth("8018.5.26");
        user1Mapper.insert(user1);

    }

    @Test
    public void updateByIdTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User1Mapper user1Mapper = sqlSession.getMapper(User1Mapper.class);
        User1 user1 = new User1();
        user1.setId(300);
        user1.setName("老李");
        user1Mapper.updateById(user1);

    }

    @Test
    public void deleteByIdTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User1Mapper user1Mapper = sqlSession.getMapper(User1Mapper.class);
        user1Mapper.deleteById(455);
    }


}