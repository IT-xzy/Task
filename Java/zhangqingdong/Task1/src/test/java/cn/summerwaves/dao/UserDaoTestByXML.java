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
 * Created by summerwaves on 2017/7/18.
 */
public class UserDaoTestByXML {
    private SqlSessionFactory factory;
    private SqlSession session;

    private static Logger logger = Logger.getLogger("UserDaoTestByXML.class");

    //以下注释掉的代码，是不以Dao来开发的，独立使用mapper层即可

    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
        session = factory.openSession();

    }



    @Test
    public void insertUser() throws Exception {
        User user = new User();
        user.setUserName("张三");
        user.setPassword("123456");
        user.setSex(1);
        UserDao dao = session.getMapper(UserDao.class);
        dao.insertUser(user);
        logger.debug("XML型插入");

        /*session.insert("cn.summerwaves.dao.UserDao.insertUser", user);*/
    }

    @Test
    public void selectUserByName() throws Exception {
        UserDao dao = session.getMapper(UserDao.class);
        User user = dao.selectUserByName("张三");
        System.out.println(user);
        logger.debug("XML型查询");

        /*User user = session.selectOne("cn.summerwaves.dao.UserDao.selectUserByName","张三");
        System.out.println(user);*/
    }

    @Test
    public void updateUser() throws Exception {
        UserDao dao = session.getMapper(UserDao.class);
        User user = dao.selectUserByName("张三");
        user.setPassword("654321");
        dao.updateUserByName(user);
        logger.debug("XML型更改");

        /*User user = session.selectOne("cn.summerwaves.dao.UserDao.selectUserByName","张三");
        user.setPassword("654321");
        session.update("cn.summerwaves.dao.UserDao.updateUserByName",user);*/
    }

    @Test
    public void deleteUserByName() throws Exception {
        UserDao dao = session.getMapper(UserDao.class);
        dao.deleteUserByName("张三");
        logger.debug("XML型删除");

        /*session.delete("cn.summerwaves.dao.UserDao.deleteUserByName","张三");*/
    }

    @After
    public void teardown() throws Exception {
        session.commit();
        session.close();

    }
}