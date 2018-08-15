package com.lihoo.sm.test;

import com.lihoo.sm.service.StudentService;
import com.lihoo.sm.model.Student;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author lihoo
 * @Title: StudentTest
 * @ProjectName spring_mybatis_1
 * @Description: 测试类
 * @date 2018/8/3-20:25
 */


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath*:/applicationContext.xml"})
public class StudentTest {

    //**打印日志**//
    private static Logger logger = Logger.getLogger(StudentTest.class);
//    private static Logger logger = LogManager.getLogger("DebugLogger");

    @Autowired
    StudentService studentService;


    private ApplicationContext applicationContext;
    @Before
    public void setup() throws Exception {
        applicationContext =
                new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

    @Test
    public void testFindStudentList() throws Exception {
        logger.debug("开始查询学员");

        StudentService studentService = applicationContext.getBean(StudentService.class);

        List<Student> list = studentService.findStudentList();

        for (Student studentList:  list) {
            logger.debug(studentList);
        }

        logger.debug("查询成功！！！");
    }

    @Test
    public void testFindStudentById() throws Exception {
        logger.debug("开始查询学员");

        StudentService studentService = applicationContext.getBean(StudentService.class);

        Student stu_id = studentService.findStudentById(15);

        logger.debug(stu_id);
        logger.debug("查询成功！！！");
    }

    @Test
    public void testFindStudentByName() throws Exception {
        logger.debug("开始查询学员");

        StudentService studentService = applicationContext.getBean(StudentService.class);

        Student student_name = studentService.findStudentByName("杨纲");

        logger.debug("学员：" + student_name);
        logger.debug("查询成功！！！");

    }

    @Test
    public void testAddStudent() throws Exception {
        logger.debug("开始添加学员");

        StudentService studentService = applicationContext.getBean(StudentService.class);

        Student stu = new Student();
        //=== _ ===//
//        Long time = System.currentTimeMillis();
//        stu.setId(77);
        stu.setUsername("温思默克@山治");
        stu.setQq_num(9999);
        stu.setStudy_type("pm");
        stu.setStudy_time(1533348646);
        stu.setSchool("黑科技");
        stu.setStudy_id("pm-75486");
        stu.setDaily_link("onepice.com");
        stu.setPromise("皮一下");
        stu.setTeach_bro("大将黄狗");
        stu.setKnow_us_from("nice大夫");
        stu.setCreate_at(1533366950);
        stu.setUpdate_at(1533374875);

        studentService.addStudent(stu);

        logger.debug("添加学员:" +stu);
        logger.debug("添加学员成功！！！");
    }

    @Test
    public void testDeleteStudent() throws Exception {
        logger.debug("开始删除学员");

        StudentService studentService = applicationContext.getBean(StudentService.class);

        studentService.deleteStudent(38);

//        logger.debug(toString(studentService.deleteStudent(32)));
        logger.debug("删除成功");



    }

    @Test
    public void testUpdateStudent() throws Exception {
        logger.debug("开始删除学员");
//        SpringJUnit4ClassRunner.class.getAnnotatedInterfaces();
        StudentService studentService = applicationContext.getBean(StudentService.class);

        Student stu = new Student();

        stu.setId(39);
        stu.setUsername("玛里苟斯");
        stu.setSchool("新泽西大学");
        stu.setDaily_link("www.nice——daifu.com");
        stu.setUpdate_at(1534268749);

        studentService.updateStudent(stu);
        logger.debug("更改学员信息成功");
    }
}
