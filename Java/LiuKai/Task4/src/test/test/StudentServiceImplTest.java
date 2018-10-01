package test;

import dao.StudentDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.Student;
import service.StudentService;
import service.StudentServiceImpl;
import sun.text.resources.FormatData;
import sun.util.calendar.LocalGregorianCalendar;

import javax.sound.midi.Soundbank;
import javax.xml.crypto.Data;
import java.security.PublicKey;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")

public class StudentServiceImplTest {
    @Autowired
    StudentDao studentDao;


    //
    @Autowired
    StudentService studentService;

    //
    @Test
    public void insertStudent() {
        int i = 1;
        while (i < 10) {
            long time = System.currentTimeMillis();
            Student student = new Student();
            student.setStuName("王朝" + i);
            student.setCourse("web");
            student.setJob("架构师");
            student.setSelfIntro("熟悉java，担任架构");
            student.setGood("yes");
            student.setCreateTime(time);
            student.setUpdateTime(time);
            studentService.insertStudent(student);
            System.out.println(student);
            i++;
        }
    }

    //
//    }
//
//    @Test
//    public void deleteById() {
//        studentDao.deleteById(3);
//    }
//
    @Test
    public void deleteAll() {

        studentService.deleteAll();
    }
//
//    @Test
//    public void updateStudent() {
//
//        Student student = studentDao.findById(1);
//        student.setStuName("ddd");
//        studentDao.updateStudent(student);
//        System.out.println(student);
//    }
//
    @Test
    public void findById() {
        Student student = studentService.findById(1);
        System.out.println(student);
    }

//    @Test
//    public void findLikeName() {
//        List<Student> list=studentDao.findLikeName("R");
//        System.out.println(list);
//
//
//    }
//
//    @Test
//    public void findAll() {
//        List<Student> students = studentService.findAll();
//        SimpleDateFormat aformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        System.out.println(students);
//    }
//
//    @Test
//    public void getList() {
//        List<Student> list = studentDao.queryAll(0, 1000);
//        System.out.println(list);
//
//    }


    @Test
    public void countAll() {
        long num = studentDao.countAll();
        System.out.println(num);
    }

@Test
    public  void countJob(){
        long num =studentDao.countJob();
    System.out.println(num);

}

@Test
    public void findGood(){
  int a=studentDao.countCourse("java");
    System.out.println(a);
}

}