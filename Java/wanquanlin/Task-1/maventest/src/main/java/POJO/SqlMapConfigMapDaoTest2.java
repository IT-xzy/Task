package POJO;

import Dao.UserMapper;
import Dao.UserMapperMap;
import POJO.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class SqlMapConfigMapDaoTest2 {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp()throws Exception{
        String resource="SqlMapConfigDaoMap.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void testFindUserById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapperMap userMapperMap=sqlSession.getMapper(UserMapperMap.class);
        User user=userMapperMap.findUserByid(1);
        System.out.println(user);
    }
}
