package com.tiles.service;

import com.tiles.dao.StudentDao;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author suger
 * @date 2018/11/18 19:19
 */
public class StudentServiceTest {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
    StudentService studentService = ctx.getBean(StudentService.class);
    static Logger log = Logger.getLogger(StudentServiceTest.class);
    @Test
    public void listStudent() throws Exception {
        log.info(studentService.listStudent());
    }

    @Test
    public void getStudentType() throws Exception {

        Boolean type = true;
        log.info(studentService.getStudentType(type));

    }

}