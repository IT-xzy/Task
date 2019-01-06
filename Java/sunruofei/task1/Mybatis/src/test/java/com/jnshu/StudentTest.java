package com.jnshu;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentTest {
    static Logger logger = Logger.getLogger(StudentTest.class);
    static String resource = "config.xml";
    static InputStream inputStream;

    static {
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    StudentDao studentDao=sqlSession.getMapper(StudentDao.class);
    static Student student = new Student();

    @Test
    public void add() {
        student.setName("孙若飞");
        student.setQq(1744207827);
        student.setType("JAVA工程师");
        student.setAdmission_date("2018年12月27日");
        student.setGraduate_school("北京大学");
        student.setStudent_number(1234);
        student.setDaily_link("http://www.jnshu.com/school/29862/daily?page=12");
        student.setWish("好好学习天天向上");
        student.setInstructor("郭靖");
        student.setInformation_source("朋友");
         studentDao.add(student);
        logger.info(student.getId());
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void delete(){
        logger.info(studentDao.delete(8));
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public void update(){
        student.setName("李云龙");
        student.setQq(1744207827);
        student.setType("JAVA工程师");
        student.setAdmission_date("2018年12月27日");
        student.setGraduate_school("北京大学");
        student.setStudent_number(1234);
        student.setDaily_link("http://www.jnshu.com/school/29862/daily?page=12");
        student.setWish("好好学习天天向上");
        student.setInstructor("张建礼");
        student.setInformation_source("朋友");
        student.setId(9);
        logger.info(studentDao.update(student));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void findAll(){
        List<Student> student = studentDao.findAll();
        logger.info(student);
        sqlSession.close();
    }
    @Test
    public void findById(){
        logger.info(studentDao.findById(3));
        sqlSession.close();

    }

}
