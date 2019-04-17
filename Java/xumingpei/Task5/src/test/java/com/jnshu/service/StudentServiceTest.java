package com.jnshu.service;

import com.jnshu.dao.StudentMapper;
import com.jnshu.pojo.Student;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/30 - 8:30
 */
@ContextConfiguration(locations = "classpath:SpringMybatis.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentServiceTest {
    private static Logger logger = Logger.getLogger(StudentServiceTest.class);

    @Autowired
    StudentService studentService;
    Student student = new Student();

    @Test
    public void getAll(){
        logger.info(studentService.getAll());
    }

}
