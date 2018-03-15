package com.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Arike
 * Create_at 2018/1/2 14:25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springmybatis.xml")
public class JobsDaoTest {
    @Autowired
    ApplicationContext ctx;
    @Test
    public void selectJobs() throws Exception{
    
        System.out.println(ctx.getBean(JobsDao.class).selectJobs());
    }
}