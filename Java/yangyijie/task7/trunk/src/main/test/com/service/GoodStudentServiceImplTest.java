package com.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Arike
 * Create_at 2017/12/28 16:08
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:xml/springmybatis.xml")
public class GoodStudentServiceImplTest {
    @Autowired
    GoodStudentServiceImpl goodStudentService;
    
    @Test
    public void selectAll() throws Exception{
        
        System.out.println(goodStudentService.selectAll());
        
        
    }
}