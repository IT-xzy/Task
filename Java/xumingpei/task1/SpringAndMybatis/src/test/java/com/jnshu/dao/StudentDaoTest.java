package com.jnshu.dao;

import com.jnshu.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/1/2 - 23:37
 */
//用来指定加载的Spring配置文件的位置，回家再默认的配置文件
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
//让测试运行于Spring测试环境
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentDaoTest {
    @Resource(name = "studentDao")
    private StudentDao studentDao;


    @Test
    public void testAddStudent(){
        Student student = new Student();
        student.setName("李白");
        student.setQq("441207082");
        student.setType("Web");
        student.setEnrolmentTime(20181104);
        student.setSchool("中山大学");
        student.setOnlineId(5064);
        student.setDailyUrl("www.jnshu.com");
        student.setWish("长胖");
        student.setBrother("唐海清");
        student.setWhereToKnowJnshu("知乎");
        student.setcreateAt(20181115);
        student.setupdateAt(20181117);
        studentDao.addStudent(student);
        System.out.println("新增id:"+student.getId());
    }

    @Test
    public void testDeleteStudent(){
        int result = studentDao.deleteStudent(990024);
        if(result != 0){
            System.out.println("ture");
        }else{
            System.out.println("false");
        }
    }

    @Test
    public void testUpdateStudent(){
        Student student = new Student();
        student.setName("2412");
        student.setId(990023);
        int result = studentDao.updateStudent(student);
        if (result != 0){
            System.out.println("true");
        }else {
            System.out.println("faluse");
        }
    }

    @Test
    public void findStudentById(){
        Student student = studentDao.findStudentById(1);
        System.out.println(student);
    }

    @Test
    public void findAll(){
        List<Student> students = studentDao.findAll();
        for (Student student : students){
            System.out.println(student);
        }
    }
}