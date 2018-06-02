package action;

import model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;
import service.RandomStudent;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
/*
* 测试Annotation方式下的Mybatis
* */

public class MybatisAnnotationAction {

    static Logger logger = Logger.getLogger(MybatisAction.class.getName());

    private static SqlSessionFactory sqlSessionFactory ;

    private static Reader reader;

    //    randomStudent.getStudent() 无id
    private RandomStudent randomStudent = new RandomStudent();

    private Student student;

    static {
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }



    @Test
    public void selectTest(){

        SqlSession sqlSession = sqlSessionFactory.openSession();

        logger.info(sqlSession.selectOne("dao.mapper.StudentAnnotationMapper.selectById",25));

        student.setName("福");
        List<Student> list = sqlSession.selectList("dao.mapper.StudentAnnotationMapper.findByStudent",student);
        for (Student student1:list){
            logger.info(student1.toString());
        }


    }


    @Test
    public void insertTest(){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Student> students = new ArrayList<>();

        for (int i=0;i<5;i++){
            student = randomStudent.getStudent();
            students.add(student);
        }
        try {

            sqlSession.insert("dao.mapper.StudentAnnotationMapper.insertList",students);

            sqlSession.commit();

        }catch (Exception e){
            e.fillInStackTrace();
        }finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }



    }


}
