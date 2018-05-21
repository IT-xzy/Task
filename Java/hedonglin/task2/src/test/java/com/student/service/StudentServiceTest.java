package com.student.service;

import com.student.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class StudentServiceTest {


    @Resource
    private StudentService studentService;
    @Test
    public void deleteByPrimaryKey() {
        Long id=1L;
        int delete =studentService.deleteByPrimaryKey(id);
        System.out.println(delete);
    }

    @Test
    public void insert() {
        Student student=new Student();
        student.setId(1L);
        student.getCreateAt();
        student.getUpdateAt();
        student.setName("雷雷");
        student.setQq("12312321");
        student.setSex("难");
        student.setComeFrom("sad");
        student.setEntryTime(123331L);
        student.setMajor("sds");
        studentService.insert(student);
        System.out.println(student);
    }


    @Test
    public void selectByPrimaryKey() {
        Student student=studentService.selectByPrimaryKey(3L);
        System.out.println(student);
    }


    @Test
    public void updateByPrimaryKey() {
        Student student=new Student();
        student.setId(4L);
        student.setName("asd");
        student.setSex("男");
        student.setQq("123123");
        student.setEntryTime(12315L);
        student.setComeFrom("asd");
        student.setMajor("sda");
        studentService.updateByPrimaryKey(student);
    }

    @Test
    public void getAll(){
        List<Student> studentList = studentService.getAll();
//        遍历
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}