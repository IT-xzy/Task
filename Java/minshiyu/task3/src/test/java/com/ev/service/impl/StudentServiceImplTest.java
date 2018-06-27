package com.ev.service.impl;

import com.ev.dao.StudentMapper;
import com.ev.service.StudentService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * StudentServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>04/07/2018</pre>
 */

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class StudentServiceImplTest {

    @Autowired
    StudentService studentMapper;

    @Test
    public void dothing() throws Exception {
        System.out.println(studentMapper.findStudentById(1L));
    }

} 
