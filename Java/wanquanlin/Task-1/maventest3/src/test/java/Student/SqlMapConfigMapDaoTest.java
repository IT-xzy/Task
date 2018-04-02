package Student;

import Dao.UserMapper;
import POJO.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import java.io.InputStream;
import java.util.List;

public class SqlMapConfigMapDaoTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp()throws Exception{
        String resource="SqlMapConfigDaoTest.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void testFindUserById() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user=userMapper.findUserById(5);
        System.out.println(user);
    }
    @Test
    public void testFindUserByName() throws Exception{
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        List<User> p=userMapper.findUserByname("四");
        sqlSession.close();
        System.out.println(p);
    }
}
