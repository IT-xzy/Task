package cc.myhome.mybatis;


import java.io.IOException;
import java.io.Reader;
import java.util.List;

import cc.myhome.jdbctemplate.dao.Dao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cc.myhome.mybatis.mapper.Network1Mapper;

import cc.myhome.model.Network1;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:Spring-Mybatis.xml")

public class Test2MybatisMapper {

//   private static ApplicationContext cx = new ClassPathXmlApplicationContext("Spring-Mybatis.xml");
    public static Logger logger = LogManager.getLogger(Test2MybatisMapper.class);

    @Autowired
    Network1Mapper mapper;
//    private static ApplicationContext cx = null;
//     private static Network1Mapper mapper = null;



//      @BeforeClass public static void inti() {
////      cx = new ClassPathXmlApplicationContext("Spring-Mybatis.xml");
////      Network1Mapper mapper = (Network1Mapper) cx.getBean("sqlSessionFactory");
////
////      }



    @Test
    public void testInsert() {
        //  SqlSession sqlSession = sqlSessionFactory.openSession();
        //   try {
        logger.info("插入开始");
        Network1 one = new Network1();
        one.setLineId(25L);
        one.setName("Jack");
        one.setQQ("35135145");
        one.setType("PM");
        one.setEnrolmentTime("20181112");
        one.setGraduate("东海大学");
        one.setReportLink("www.dfgdxcvcbfgs.erfr");
        one.setWish("实现自己");
        one.setSenior("李恪非");
        one.setHowKnow("微信");
        one.setCreateAt(201845526L);
        one.setUpdateAt(201825225L);

        //      Network1Mapper mapper = sqlSession.getMapper(Network1Mapper.class);

        //插入数据
        int result = mapper.insert(one);

        logger.info("插入结束。");
        //测试
        Assert.assertEquals(1, result);


        //    } finally {
        //      sqlSession.rollback();
        //     sqlSession.close();
        //   }
    }

    @Test
    public void testSelectByIdName() {
        //     SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //     Network1Mapper mapper = sqlSession.getMapper(Network1Mapper.class);

            Network1 one = new Network1();
            one.setLineId(3L);
            one = mapper.selectByIdName(one);
            Assert.assertEquals("874616216", one.getQQ());

            one.setLineId(6L);
            one.setName("李华");
            one = mapper.selectByIdName(one);
            Assert.assertEquals("运维", one.getType());

        } finally {
            //       sqlSession.rollback();
            //       sqlSession.close();
        }
    }

    @Test
    public void testUpdate() {
        //   try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
        //     Network1Mapper mapper = sqlSession.getMapper(Network1Mapper.class);
        Network1 one = new Network1();

        one.setLineId(6L);
        one = mapper.selectByIdName(one);
        Assert.assertEquals("李华", one.getName());

        one.setName("Jack");
        one.setQQ("35135145");
        one.setType("PM");
        one.setEnrolmentTime("20181112");
        one.setGraduate("东海大学");
        one.setReportLink("www.dfgdxcvcbfgs.erfr");
        one.setWish("实现自己");
        one.setSenior("李恪非");
        one.setHowKnow("微信");
        one.setCreateAt(201845526L);
        one.setUpdateAt(201825225L);

        int result = mapper.update(one);
        Assert.assertEquals(1, result);
        Assert.assertEquals("李恪非", one.getSenior());
        //     sqlSession.rollback();


    }

    @Test
    public void testSelectAll() {
        //     SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //       Network1Mapper mapper = sqlSession.getMapper(Network1Mapper.class);
            List<Network1> ones = mapper.selectAll();
            Assert.assertEquals(12, ones.size());
            Assert.assertEquals("靳东", ones.get(7).getName());

        } finally {
            //       sqlSession.rollback();
            //     sqlSession.close();
        }

    }

    @Test
    public void testDeleteById() {
        //    SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //       Network1Mapper mapper = sqlSession.getMapper(Network1Mapper.class);
            Network1 one = new Network1();
            one.setLineId(6L);
            one = mapper.selectByIdName(one);
            Assert.assertNotNull(one);

            int result = mapper.deleteById(6L);
            one.setLineId(null);
            one.setName("李华");
            one = mapper.selectByIdName(one);
            Assert.assertNull(one);
        } finally {
            //       sqlSession.rollback();
            //       sqlSession.close();
        }
    }

}