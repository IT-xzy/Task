package com.springmybatis.myitschool.test;

import com.springmybatis.myitschool.DAO.StudentDAO;
import com.springmybatis.myitschool.student.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class StudentTest{
    @Test
    public void selectStu(){
        StudentDAO stuDao = getStudentDAO();
        Student stu = stuDao.selectStudent(1);
        System.out.println(stu.toString());
    }

    @Test
    public void updateStu(){
        StudentDAO stuDao = getStudentDAO();
        Student stu = new Student();
        stu.setId(1);
        stu.setName("hahahha");
        stuDao.updateStudent(stu);
    }

    @Test
    public void insertStu(){
        StudentDAO stuDao = getStudentDAO();
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
    }

    @Test
    public void allStu(){
        StudentDAO stuDao = getStudentDAO();
        List<Student> list = stuDao.allStudent();
        for(Student stu : list)
            System.out.println(stu.toString());
    }

    @Test
    public void deleteStu(){
        StudentDAO stuDao = getStudentDAO();
        stuDao.deleteStudent(13);
    }

    private static StudentDAO getStudentDAO() {
        ApplicationContext ctx = null;
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDAO studentDao = (StudentDAO) ctx.getBean(StudentDAO.class);
        return studentDao;
    }
}
