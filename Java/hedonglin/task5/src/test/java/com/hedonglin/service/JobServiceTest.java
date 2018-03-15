package com.hedonglin.service;


import com.hedonglin.model.Job;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class JobServiceTest {

    @Autowired
    private JobService jobService;
    @Test
    public void getAll() {
        List<Job> jobs=jobService.getAll();
        System.out.println(jobs);
    }
}
