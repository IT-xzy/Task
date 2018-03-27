package com.mybatis.itschool.inputcircle;


import com.mybatis.itschool.DAO.StudentDAO;
import com.mybatis.itschool.student.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Inputcircle {

    public static void main(String[] args){
        /*
        SqlSessionFactory sessionFactory = null;
        String resource = "mybatis-config.xml";
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        long start = System.currentTimeMillis();
        for(int i = 0; i < 1; i++) {
            SqlSession sqlSession = sessionFactory.openSession();
            StudentDAO stuDao = sqlSession.getMapper(StudentDAO.class);
            try {
                stuDao.insertStudent(stu);
            }catch(Exception e){
                e.printStackTrace();
            }
                sqlSession.commit();
                sqlSession.close();
        }
        System.out.println("waste time  "+(System.currentTimeMillis()-start)/1000);
    */
        long start = System.currentTimeMillis();
        Inputcircle it = new Inputcircle();

        for(int j = 0; j < 100; j++) {
            List<Student> list = new ArrayList<Student>();
            for (int i = 0; i < 10000; i++) {
                Student stu = new Student();
                stu.setName("小强");
                stu.setQQ(j*10000+i);
                stu.setType("java");
                stu.setStime("20180105");
                stu.setGraschool("北大幼儿园");
                stu.setClassnum("11111");
                stu.setLink("www.baidu.com");
                stu.setMentor("hahahh");
                stu.setConbrother("大强");
                stu.setHknow("微信");
                list.add(stu);
            }

            try {
                it.batchInsert(list);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("waste time: " + (System.currentTimeMillis() - start)/1000);
    }

    public void batchInsert(List<Student> list) throws Exception {
        SqlSession sqlSession = getSqlSessionFactory().openSession(ExecutorType.BATCH);
        try{
            sqlSession.insert("com.mybatis.itschool.DAO.StudentDAO.batchInsert", list);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory(){
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
