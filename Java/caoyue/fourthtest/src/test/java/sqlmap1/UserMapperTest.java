package sqlmap1;


import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import fourth.com.student;

import java.io.InputStream;

public class UserMapperTest extends TestCase {
    private SqlSessionFactory sqlSessionFactory;
    
    @Before
    public void setUp() throws Exception {
        String resource = "SqlMapConfig.xml"; //mybatis配置文件
        //得到配置文件的流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂SqlSessionFactory,要传入mybatis的配置文件的流
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    
//    @Test
//    public void testFindStudentById() throws Exception {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //创建StudentMapper对象，mybatis自动生成mapper代理对象
//        UserMapper UserMapper = sqlSession.getMapper(UserMapper.class);
//        student student = UserMapper.findStudentById(10);
//        System.out.println(student);
//    }
    
    @Test
    public void testFindStudentByName() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建StudentMapper对象，mybatis自动生成mapper代理对象
        UserMapper UserMapper = sqlSession.getMapper(UserMapper.class);
        student student = UserMapper.findStudentByName("大");
        System.out.println(student);
    }
}

