package mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class MybatisTest {
    public static void main(String[] args) throws  Exception{
        String ri = "sqlMapConfig.xml";
        Reader stream = Resources.getResourceAsReader(ri);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        for(int i = 0; i < 1000; i++) {
//            User user= sqlSession.selectOne("test.insertUser","韩阳");
//        }
        User user = new User("韩阳");
        sqlSession.insert("test.insertUser",user);
        sqlSession.commit();
//        User user= sqlSession.selectOne("test.find",1);
//        System.out.println(user);
        System.out.println("hello");
    }
}
