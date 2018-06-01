package com.mojorjoe.web.dao;

import com.mojorjoe.web.pojo.PageBean;
import com.mojorjoe.web.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class StudentDAOTest {

    ApplicationContext act=  new ClassPathXmlApplicationContext("SpringApplication.xml");
    StudentDAO studentDAO= (StudentDAO)act.getBean("studentDAO");

Student student= new Student();


    @Test
    public void saveStudent() {
        student.setName("张天师");
        student.setCreateTime(System.currentTimeMillis());
        studentDAO.saveStudent(student);
        System.out.println(student.getId());
    }

    @Test
    public void deleteStudent() {
        if (studentDAO.deleteStudent(450)){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

    @Test
    public void selectStudent() {
        System.out.println(studentDAO.selectStudent(6));
    }

    @Test
    public void selectByName() {
        System.out.println(studentDAO.selectByName("宇"));
    }

    @Test
    public void updateStudent() {
        student.setId(1);
        student.setSenior("王琦超");
        student.setUpdateTime(System.currentTimeMillis());
        if (studentDAO.updateStudent(student)){
            System.out.println("更新成功");
        }else {
            System.out.println("更新失败");
        }
    }

    @Test
    public void pageListStudent() {

        PageBean pageBean=new PageBean(2,20,5);
        System.out.println(pageBean);
        System.out.println(studentDAO.pageListStudent(pageBean));

    }

    @Test
    public void totalStudent() {
        System.out.println(studentDAO.totalStudent());
    }

}