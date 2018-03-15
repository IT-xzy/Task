package cn.summerwaves.dao;

import cn.summerwaves.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by summerwaves on 2017/7/20.
 */
public class UserDaoTestByAnnotation {
    private SqlSessionFactory factory;
    private SqlSession session;

    private static Logger logger = Logger.getLogger("UserDaoTestByAnnotation.class");

    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
        session = factory.openSession();
    }


    @Test
    public void insertUserByAnnotation() throws Exception {
        UserDao dao = session.getMapper(UserDao.class);
        User user = new User();
        user.setUserName("张三");
        user.setPassword("123456");
        user.setSex(1);
        dao.insertUserByAnnotation(user);
        logger.debug("注释型插入");

    }

    @Test
    public void selectUserByAnnotation() throws Exception {
        UserDao dao = session.getMapper(UserDao.class);
        User user = dao.selectByNameByAnnotation("张三");
        System.out.println(user);
        logger.debug("注释型查询");
    }

    @Test
    public void updateUserByNameByAnnotation() throws Exception {
        UserDao dao = session.getMapper(UserDao.class);
        User user = dao.selectByNameByAnnotation("张三");
        user.setPassword("654321");
        dao.updateUserByNameByAnnotation(user);
        logger.debug("注释型更改");
    }

    @Test
    public void deleteUserByNameByAnnotation() throws Exception {
        UserDao dao = session.getMapper(UserDao.class);
        dao.deleteUserByNameByAnnotation("张三");
        logger.debug("注释型删除");
    }


    @After
    public void teardown() throws Exception {
        session.commit();
        session.close();

    }
}
