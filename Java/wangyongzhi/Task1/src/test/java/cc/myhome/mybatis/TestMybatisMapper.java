package cc.myhome.mybatis;


import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;


import cc.myhome.mybatis.mapper.Network1Mapper;

import cc.myhome.model.Network1;


public class TestMybatisMapper {

    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void inti() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException ignore) {
            ignore.printStackTrace();
        }
    }


    @Test
    public void testInsert() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
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

            Network1Mapper mapper = sqlSession.getMapper(Network1Mapper.class);

            //插入数据
            int result = mapper.insert(one);

            //测试
            Assert.assertEquals(1, result);


        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectByIdName() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Network1Mapper mapper = sqlSession.getMapper(Network1Mapper.class);

            Network1 one = new Network1();
            one.setLineId(3L);
            one = mapper.selectByIdName(one);
            Assert.assertEquals("874616216", one.getQQ());

            one.setLineId(6L);
            one.setName("李华");
            one = mapper.selectByIdName(one);
            Assert.assertEquals("运维", one.getType());

        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testUpdate() {
        try(SqlSession sqlSession = sqlSessionFactory.openSession();) {
            Network1Mapper mapper = sqlSession.getMapper(Network1Mapper.class);
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



        }
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Network1Mapper mapper = sqlSession.getMapper(Network1Mapper.class);
            List<Network1> ones = mapper.selectAll();
            Assert.assertEquals(12, ones.size());
            Assert.assertEquals("靳东", ones.get(7).getName());

        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }

    }

    @Test
    public void testDeleteById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Network1Mapper mapper = sqlSession.getMapper(Network1Mapper.class);
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
            sqlSession.rollback();
            sqlSession.close();
        }
    }

}
