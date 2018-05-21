package com.task.service;

import com.task.dao.StudentDao;
import com.task.models.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
//生成spring容器
@RunWith(SpringJUnit4ClassRunner.class)
//加载配置文件
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class StudentServiceTest {
    //生成对象注入属性
    @Autowired
    StudentDao studentDao;
    @Test
    public void justAdd() {
        for(int i=0;i<10;i++){
            Student student=new Student(System.currentTimeMillis(),"王三","java",20180502,2018001+i,"在学");
        studentDao.addStudent(student);
        }
    }

    @Test
    public void justDelete() {
        studentDao.deleteStudent(1);
    }

    @Test
    public void justUpdate() {
        Student student=new Student();
       student.setId(4);
       student.setProfession("PM");
       student.setUpdatedAt(System.currentTimeMillis());
       student.setIsWorked("工作");
       studentDao.updateStudent(student);
    }

    @Test
    public void justListById() {
        System.out.println(studentDao.getStudent(3));

    }

    @Test
    public void justList() {
        List<Student> list=studentDao.getByName("王");
        for (Student s1:list){
            System.out.println(s1);
        }
    }

    @Test
    public void justListByStuID() {
        System.out.println(studentDao.getByStuID(2018005));
    }

    @Test
    public void listCount() {
        System.out.println(studentDao.selectCount());
    }

    @Test
    public void listIsStudy() {
        System.out.println(studentDao.selectIsStudy());
    }

    @Test
    public void listIsStuByPro(){
        System.out.println(studentDao.selectIsStuByPro("PM"));
    }
}