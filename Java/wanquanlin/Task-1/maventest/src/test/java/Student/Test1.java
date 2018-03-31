package Student;

import POJO.Student1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;

public class Test1 {
   public SqlSession getSession() throws IOException{
       String resource="SqlMapConfig.xml";
       InputStream inputStream= Resources.getResourceAsStream(resource);
       SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
       SqlSession sqlSession=sqlSessionFactory.openSession();
       return  sqlSession;
   }
   @Test
   public void findstudentbyID() throws IOException{
       SqlSession sqlSession=getSession();
      Student1 p= sqlSession.selectOne("findstudentbyID", 1);
       System.out.println(p);
       sqlSession.close();
   }
}
