package com.myspring.di.context;

import com.mybatis_spring.dao.IStudentDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.core.*;

/**
 * @author Arike
 * Create_at 2017/12/1 11:28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/myspring/di/context/mybatis-spring.xml")
public class StudentMapperTest {
    @Autowired
    ApplicationContext ctx;

    @Test
    public void getStudentById() throws Exception {
        StudentMapper sm = (StudentMapper) ctx.getBean("studentDao");
        System.out.println(sm.getStudentById(81L));
    }
    
    @Test
    public void getStudentByName() throws Exception {
    }
    
    @Test
    public void updateStudent() throws Exception {
    }
    
    @Test
    public void insertStudent() throws Exception {
    }
    
    @Test
    public void deleteStudent() throws Exception {
    }
    
}