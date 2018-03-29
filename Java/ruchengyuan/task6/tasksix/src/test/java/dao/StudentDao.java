package dao;

import jnshu.tasksix.dao.StudentMapper;
import jnshu.tasksix.model.Student;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017-10-15.
 */

//value = true 则测试完毕自动回滚，无法看到数据库是否插入数据，测试环境应该设置为false
// 否则无法确定是否成功提交事务
//value = false
@Rollback(value = true)
//标记，使事务管理器来管理识别
@Transactional(transactionManager = "transactionManager")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/spring-mybatis.xml"})
public class StudentDao {

    private static final Logger logStuDAO = LoggerFactory.getLogger(StudentDao.class);

    @Resource
    private StudentMapper studentMapper;

    @BeforeClass
    public static void begin(){
        logStuDAO.info("测试开始");
    }

    @AfterClass
    public static void end(){
        logStuDAO.info("测试结束");
    }

    @Test
    public void testGetStudentUser(){
        try {
            logStuDAO.info("测试查询\n");
            Student study = new Student();
            study = studentMapper.getStudentUser("qwe");
            logStuDAO.info("学生信息： \n" + study);
        }catch (Exception e){
            e.printStackTrace();
            logStuDAO.error("查询失败 " + e.getMessage());
        }
    }


    @Test
    public void testInsertStudentUser(){

        Long INSERT_TIME = System.currentTimeMillis();
            logStuDAO.info("添加信息\n");
            Student study = new Student();
            study.setUser("789456");
            study.setPass("12345689");
            study.setImages("452758278.png");
            study.setProfession("IT");
            study.setQq(789456123);
            Long importTime = new Long(0);
            study.setEnrolAt(importTime);
            study.setCreateAt(INSERT_TIME);
            study.setUpdateAt(INSERT_TIME);
            int id  = studentMapper.insertStudentUser(study);
            logStuDAO.info("学生信息： \n" + study);
            logStuDAO.info("返回影响行数： " + id);
            logStuDAO.info("id为： " + study.getId());
    }


    @Test
    public void testListStudent(){
        List<Student> students = studentMapper.listStudentTable();
        logStuDAO.info("get all student information: " + students);

    }


    @Test
    public void testCountStudentStatus(){
        Student student = new Student();
        student.setStatus(1);
        int userNumber = studentMapper.countStudentUser(student);
        logStuDAO.info("get the number of student based on \"status\": " + userNumber);

    }


    @Test
    public void testCountStudentUser(){
        Student student = new Student();
        student.setUser("qwe");
        int userNumber = studentMapper.countStudentUser(student);
        logStuDAO.info("get the number of student based ob user name:  " + userNumber);

    }

}
