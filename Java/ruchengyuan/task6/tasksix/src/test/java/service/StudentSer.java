package service;


import jnshu.tasksix.model.Student;
import jnshu.tasksix.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Administrator
 * @date: 2017-10-19
 * @Time: 下午 2:26
 * Description:
 **/

//value = true 则测试完毕自动回滚，无法看到数据库是否插入数据，测试环境应该设置为false
// 否则无法确定是否成功提交事务
//value = false
@Rollback(value = true)
//标记，使事务管理器来管理识别
@Transactional(transactionManager = "transactionManager")

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/spring-mybatis.xml"})
public class StudentSer {

    private static Logger logStuSer= LoggerFactory.getLogger(StudentSer.class);

    @Autowired
    private StudentService studentService;

    @Test
    public void testGetStudentUser(){
            logStuSer.info("测试查询\n");
            Student study = new Student();
            study = studentService.getStudentUser("qwe");
            logStuSer.info("学生信息： \n" + study);

    }


    @Test
    public void testInsertStudentUser(){

        Long INSERT_TIME = System.currentTimeMillis();
        logStuSer.info("添加信息\n");
        Student study = new Student();
        study.setUser("778894");
        study.setPass("12345689");
        study.setImages("452758278.png");
        study.setProfession("IT");
        study.setQq(789456123);
        Long importTime = new Long(0);
        study.setEnrolAt(importTime);
        study.setCreateAt(INSERT_TIME);
        study.setUpdateAt(INSERT_TIME);
        int id  = studentService.insertStudentUser(study);
        logStuSer.info("学生信息： \n" + study);
        logStuSer.info("返回影响行数： " + id);
        logStuSer.info("id为： " + study.getId());
    }


    @Test
    public void testListStudent(){
        List<Student> students = studentService.listStudentTable();
        logStuSer.info("get all student information: " + students);

    }


    @Test
    public void testCountStudentStatus(){
        Student student = new Student();
        student.setStatus(1);
        int userNumber = studentService.countStudentUser(student);
        logStuSer.info("get the number of student based on \"status\": " + userNumber);

    }


    @Test
    public void testCountStudentUser(){


        Student student = new Student();
        student.setUser("qwe");
        int userNumber = studentService.countStudentUser(student);
        logStuSer.info("get the number of student based ob user name:  " + userNumber);
    }

}