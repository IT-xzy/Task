package service.impl;

import mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.Student;
import service.StudentService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ServiceImplTest {
    @Autowired
    StudentMapper studentMapper;

    @Test
    public void insertStudent() {
         long id=0;
        while (id<10) {
            Student student = new Student();
            student.setStuName("Rose" + id);
            student.setQqNum("123456");
            student.setCourse("JAVA");
            long time = System.currentTimeMillis();
            student.setCreateTime(time);
            student.setUpdateTime(time);
            studentMapper.insertStudent(student);
            System.out.println(student);
            id++;
        }
    }

    @Test
    public void deleteStudent() {

        studentMapper.deleteStudent(16);
    }

    @Test
    public void updateStudent() {
        Student student1 = studentMapper.findById(1);
        student1.setCourse("lll");
        studentMapper.updateStudent(student1);
        System.out.println(student1);
    }

    @Test
    public void findById() {
        Student student = studentMapper.findById(1000);
        System.out.println(student);

    }

    @Test
    public void findLikeName() {

        List<Student> students = studentMapper.findLikeName("J");

        System.out.println(students);

    }

    @Test
    public void deleteAll() {

        studentMapper.deleteAll();
    }
}