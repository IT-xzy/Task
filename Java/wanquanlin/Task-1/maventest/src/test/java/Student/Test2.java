package Student;

import POJO.User2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test2 {
    public SqlSession getSession() throws IOException {
        String resource="SqlMapConfig2.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        return  sqlSession;
    }
    @Test
    public void findstudentbyName() throws IOException{
        SqlSession sqlSession=getSession();
        List<User2> list=sqlSession.selectList("testbyname.findUserByname","张三");
        System.out.println(list);
        sqlSession.close();
    }
}
