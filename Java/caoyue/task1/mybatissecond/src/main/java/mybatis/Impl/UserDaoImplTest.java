package mybatis.Impl;

import mybatis.DAO.UserDao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.Before;

import java.io.InputStream;


public class UserDaoImplTest {
    private SqlSessionFactory sqlSessionFactory;
    static  Logger logger = Logger.getLogger(UserDaoImplTest.class);
    @Before
    public void setUp() throws Exception {
        //创建sqlSessionFactory
        String resource = "sqlMapConfig.xml"; //mybatis配置文件
    
        //得到配置文件的流
        InputStream inputStream = Resources.getResourceAsStream(resource);
    
        //创建会话工厂SqlSessionFactory,要传入mybaits的配置文件的流
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    
//    @Test
//    public void testFindUserById() throws Exception {
//        //创建UserDao的对象
//        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
//        System.out.println(userDao.findUserById(1));
//        logger.info("jdaks");
//    }
}
