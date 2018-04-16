package com.alibaba.dao;

import com.alibaba.model.Student;
import com.alibaba.service.StudentService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {
    @Resource
    private StudentService studentService;

    @Test
    public void deleteByPrimaryKey() {
        studentService.deleteByPrimaryKey(1L);
        // System.out.println(s);
    }
    @Test
    public void insert() {
        Student student = new Student();
        student.setId(22L);
        student.setName("高娃敏");
        student.setQq("617665");
        student.setMajor("面师");
        studentService.insert(student);
        System.out.println(student);
    }
    @Test
    public void update(){
        Student student = new Student();
        student.setId(22L);
        student.setMajor("龙是吧");
        student.setName("虚竹");
       student.setQq("5497864");
      studentService.updateByPrimaryKey(student);
    }
    @Test
    public void list(){
        List<Student> studentList = studentService.list();
        System.out.println(studentList);
    }
    @Test
    public void selectById(){
        Student student = studentService.selectById(5L);
        System.out.println(student);
    }
}

