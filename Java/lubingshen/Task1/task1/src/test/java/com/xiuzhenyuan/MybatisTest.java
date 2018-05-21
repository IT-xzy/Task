package com.xiuzhenyuan;

import com.xiuzhenyuan.bean.Graduate;
import com.xiuzhenyuan.dao.GraduateDao;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.xiuzhenyuan.dao.StudentDao;
import com.xiuzhenyuan.bean.Student;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = {"classpath:applicationContext.xml"})

public class MybatisTest {

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private GraduateDao graduateDao;


    @Test
    public void findByIdTest() throws Exception {
        Student student = studentDao.findById(4L);
        System.out.println(student);
    }

    @Test
    public void findByNameTest() throws Exception {
        List<Student> students = studentDao.findByName("曲");
        System.out.println(students);
    }

    @Test
    public void findByNumTest() throws Exception {
        Student student = studentDao.findByNum("java-5000");
        System.out.println(student);
    }

    @Test
    public void insertSingleTest() throws Exception {
        Logger logger = Logger.getLogger(MybatisTest.class);
        Student student_insert = new Student(
                "曲艳行", "3169119846", "JAVA工程师",
                "11月18日--11月22日", "燕山大学", "java-1111",
                "http://www.jnshu.com/daily/40038?dailyType=others&total=8&page=1&uid=18143&sort=0&orderBy=3",
                "努力努力再努力！", "郑州分院王鹏举", "知乎");
        student_insert.setCreateAt(System.currentTimeMillis());
        logger.debug(studentDao.insertStudent(student_insert) + "  :  " + student_insert.getId());
    }

    @Test
    public void insertStudentTest() throws Exception {
        Logger logger = Logger.getLogger(MybatisTest.class);
        long start_insert = System.currentTimeMillis();
        Student student_insert = new Student(
                "好学生", "1111111111", "程序员",
                "2018", "中国大学", "java",
                "http://www.baidu.com/",
                "天天向上", "葡萄藤", "网络");
        student_insert.setCreateAt(System.currentTimeMillis());
        for (int i = 0; i < 100; i++) {
            student_insert.setNum("java-" + i);
            logger.debug(studentDao.insertStudent(student_insert) + "  :  " + student_insert.getId());
        }
        long end_insert = System.currentTimeMillis();
        logger.info("The total time spent on updating is " + (end_insert - start_insert) + "millisecond.");
    }

    @Test
    public void deleteStudentTest() throws Exception {
        System.out.println(studentDao.deleteStudent(3L));
    }

    @Test
    public void updateStudentTest() throws Exception {
        Logger logger = Logger.getLogger(MybatisTest.class);
        long start_update = System.currentTimeMillis();
        Student student_update = studentDao.findById(5000L);
        student_update.setUpdateAt(System.currentTimeMillis());
        student_update.setDeclaration("老大最帅");
        for (long i = 2; i < 10000; i++) {
            logger.debug(studentDao.updateStudent(student_update));
        }
        long end_update = System.currentTimeMillis();
        logger.info("The total time spent on updating is " + (end_update - start_update) + "millisecond.");
    }

    @Test
    public void updateAllTest() throws Exception {
        Logger logger = Logger.getLogger(MybatisTest.class);
        long start = System.currentTimeMillis();
        Student student = new Student();
        student.setUpdateAt(System.currentTimeMillis());
        student.setDeclaration("老大最帅");
        logger.debug(studentDao.updateStudent(student));
        long end = System.currentTimeMillis();
        logger.info("The total time spent on updating is " + (end - start) + "millisecond.");
    }

    @Test
    public void truncateTableTest() throws Exception {
        studentDao.truncateTable();
    }

    @Test
    public void testLazyLoading() throws Exception {
        List<Graduate> list = graduateDao.findGraduates();

        //遍历上边的订单列表
        for(Graduate graduate : list) {
            System.out.println("********************");
            //执行getUser()去查询用户信息，这里实现按需加载
            System.out.println(graduate.getName());
            System.out.println("还没开始调用toString方法...\n现在开始调用！");
            System.out.println(graduate);
        }
    }

}
