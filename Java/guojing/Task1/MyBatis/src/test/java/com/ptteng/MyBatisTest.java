package com.ptteng;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class MyBatisTest {
    static Logger logger = Logger.getLogger(MyBatisTest.class);
    private UserMapper um;
    private SqlSession session;

    @Before
    public void test() {
        String res = "config.xml";
        InputStream is = MyBatisTest.class.getClassLoader().getResourceAsStream(res);
        SqlSessionFactory sqlSession = new SqlSessionFactoryBuilder().build(is);
        session = sqlSession.openSession();
        um = session.getMapper(UserMapper.class);
    }

    @Test
    public void insertTest() {
        User user = new User();
        user.setName("张生");
        user.setQQ(568217963);
        user.setWish("努力！");
        user.setCreateAt(System.currentTimeMillis());
        user.setUpdateAt(System.currentTimeMillis());
        um.insertUser(user);
        logger.debug(user.getId());
        session.commit();
        session.close();
    }

    @Test
    public void findAllTest() {
        logger.debug(um.findAll());

    }

    @Test
    public void findByIdTest() {
        logger.debug(um.findById(5));
        session.commit();
        session.close();
    }

    @Test
    public void updateTest() {
        User user = new User();
        user.setName("曹操");
        user.setId(4);
        user.setQQ(625894447);
        user.setWish("好好学习");
        user.setCreateAt(System.currentTimeMillis());
        user.setUpdateAt(System.currentTimeMillis());
        logger.debug(um.updateUser(user));
        session.commit();
        session.close();
    }

    @Test
    public void deleteUser() {
        logger.debug(um.deleteUser(36));
        session.commit();
        session.close();
    }


}
