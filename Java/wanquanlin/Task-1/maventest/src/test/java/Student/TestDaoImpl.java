package Student;

import Dao.Dao1;
import Implements.UserDaoImpl;
import POJO.User;
import POJO.User3;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;


import java.io.InputStream;

public class TestDaoImpl {
  private SqlSessionFactory sqlSessionFactory;

  @Before
  public  void setUp() throws Exception{
      String resource="SqlMapConfigDaoTest.xml";
      InputStream inputStream= Resources.getResourceAsStream(resource);
      sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);

  }
  @Test
    public void testFindInsertUser() throws Exception{
      Dao1 dao1=new UserDaoImpl(sqlSessionFactory);
      System.out.println(dao1.findUserById(1));
      System.out.println(dao1.findUserByname("张"));


  }
}
