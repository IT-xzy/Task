package com.task.service;

import com.task.cache.RedisCacheManager;
import com.task.dao.StudentDao;
import com.task.models.Student;
import com.task.utils.RandomCode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;
import java.util.List;

//生成spring容器
@RunWith(SpringJUnit4ClassRunner.class)
//加载配置文件
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class StudentServiceTest {
    //生成对象注入属性
    @Autowired
    StudentDao studentDao;
    @Autowired
    RedisCacheManager redisCacheManager;
//    private static boolean isStart = false; // 防止二次调用
    @Test
    public void justAdd() {
       Student student=new Student();
       student.setName("猪八戒");
       student.setProfession("css");
       student.setCreatedAt(System.currentTimeMillis());
       student.setIsWorked("在学");
       student.setUsername("wangqichao");
       student.setStudentID(studentDao.selectCount()+1);
       studentDao.addStudent(student);
    }

    @Test
    public void justDelete() {
        studentDao.deleteStudent(1);
    }

    @Test
    public void justUpdate() {
        Student student=new Student();
       student.setUsername("wangqichao");
       student.setUpdatedAt(System.currentTimeMillis());
       student.setTelephone("15088302652");
       studentDao.updateStudent(student);
    }

    @Test
    public void justListById() {
        System.out.println(studentDao.getStudent(3));

    }

    @Test
    public void justList() {
        Student student=studentDao.getByUsername("wangqichao");

            System.out.println(student);

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

    @Test
    public void test() {
      char a='男';
      char b='女';
      String X="与";
      String sum=""+a+X+b;
        System.out.println(sum);
    }
}
