package com.dao;

import com.pojo.people;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PeopleMapperTest {
    private static SqlSessionFactory sqlSessionFactory;
    private static InputStream inputStream;

    @Before
    public void before() {

        try {
            String resource = "mybatis-config.xml";
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    @Test
    public void insertPeople() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PeopleMapper peopleMapper = sqlSession.getMapper(PeopleMapper.class);
        people j = new people();
        j.setName("小兰");
        j.setSex("女");
        j.setAddress("152");
        peopleMapper.insertPeople(j);
    }

    @Test
    public void deletePeopleById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PeopleMapper peopleMapper = sqlSession.getMapper(PeopleMapper.class);
        peopleMapper.deletePeopleById(30);

    }

    @Test
    public void updatePeopleById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PeopleMapper peopleMapper = sqlSession.getMapper(PeopleMapper.class);
        people j = new people();
        j.setId(40);
        j.setName("小兰");
        peopleMapper.updatePeopleById(j);

    }

    @Test
    public void findPeopleById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PeopleMapper peopleMapper = sqlSession.getMapper(PeopleMapper.class);
        System.out.println(peopleMapper.findPeopleById(1));

    }

    @Test
    public void findPeopleAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PeopleMapper peopleMapper = sqlSession.getMapper(PeopleMapper.class);
        System.out.println(peopleMapper.findPeopleAll());

    }

    @Test
    public void insertBatch() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PeopleMapper peopleMapper = sqlSession.getMapper(PeopleMapper.class);
        List<people> list = new ArrayList<people>();
        people j = new people();
        sqlSession.commit(false);
        for (int i = 0; i < 10000; i++) {

            j.setName("小兰");
            j.setSex("女");
            j.setAddress("152");
            list.add(j);
            if (i % 1000 == 0) {
                peopleMapper.insertBatch(list);
                sqlSession.commit();
            }
        }
        peopleMapper.insertBatch(list);

    }
}