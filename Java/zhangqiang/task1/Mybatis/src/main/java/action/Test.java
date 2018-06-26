package action;

import model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Test {


    public static void main(String[] args) throws IOException {

        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        Student student = sqlSession.selectOne("selectById",23);

        sqlSession.commit();

        System.out.print(student.toString());

        sqlSession.close();


    }



}
