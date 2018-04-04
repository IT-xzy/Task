
package Student;

import POJO.User3;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;

public class Test3 {
      public SqlSession getSession() throws IOException {
        String resource = "SqlMapConfig3.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
    @Test
    public void insertUser() throws  IOException{
        SqlSession sqlSession=getSession();
        User3 user3=new User3("赵六",null, "男", "同济大学");
        sqlSession.insert("test3.insertUser",user3);
        sqlSession.commit();
        System.out.println(user3.getId());
        sqlSession.close();

    }
}
