package Student;


import Dao.UserMapperSp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.io.Reader;

public class FirstPractice {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception {
        String resource = "SqlConfigFirstTest.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    @Test
    public void FristPracticeTest() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapperSp userMapperSp=sqlSession.getMapper(UserMapperSp.class);
        UserTest userTest=userMapperSp.findNameByid(3);
        System.out.println(userTest);
        sqlSession.close();
    }
}
