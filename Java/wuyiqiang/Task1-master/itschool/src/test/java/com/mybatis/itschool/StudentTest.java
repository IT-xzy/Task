package com.mybatis.itschool;

import com.mybatis.itschool.DAO.StudentDAO;
import com.mybatis.itschool.student.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class StudentTest{

    @Test
    public void selectStu(){
        SqlSessionFactory sqlSessionFactory = getSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentDAO stuDao = sqlSession.getMapper(StudentDAO.class);
        long start = System.currentTimeMillis();
        Student stu = stuDao.selectStudent(458125);
        System.out.println("waste time: " +  (System.currentTimeMillis() - start));
     //   stu.showStudent();
        sqlSession.close();

    }

    @Test
    public void updateStu(){
        SqlSessionFactory sqlSessionFactory = getSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentDAO stuDao = sqlSession.getMapper(StudentDAO.class);
        Student stu = new Student();
        stu.setId(1);
        stu.setName("小强");
        stu.setName(null);
        stuDao.updateStudent(stu);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertStu(){
        SqlSessionFactory sqlSessionFactory = getSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentDAO stuDao = sqlSession.getMapper(StudentDAO.class);
        Student stu = new Student();
        stu.setName("小强");
        stu.setQQ(1111110);
        stu.setType("java");
        stu.setStime("20180105");
        stu.setGraschool("北大幼儿园");
        stu.setClassnum("11111");
        stu.setLink("www.baidu.com");
        stu.setMentor("hahahh");
        stu.setConbrother("大强");
        stu.setHknow("微信");
        stuDao.insertStudent(stu);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void allStu(){
        SqlSessionFactory sqlSessionFactory = getSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentDAO stuDao = sqlSession.getMapper(StudentDAO.class);
        List<Student> list = stuDao.allStudent();
        for(Student stu : list)
            stu.showStudent();
        sqlSession.close();
    }

    @Test
    public void deleteStu(){
        SqlSessionFactory sqlSessionFactory = getSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentDAO stuDao = sqlSession.getMapper(StudentDAO.class);
        stuDao.deleteStudent(11);
        sqlSession.commit();
        sqlSession.close();
    }

    private static SqlSessionFactory getSessionFactory() {
        SqlSessionFactory sessionFactory = null;
        String resource = "mybatis-config.xml";
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }
}
