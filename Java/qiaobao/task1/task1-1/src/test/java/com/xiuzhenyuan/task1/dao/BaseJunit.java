package com.xiuzhenyuan.task1.dao;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


    @RunWith(SpringJUnit4ClassRunner.class)//表示整合Junit进行测试
    @ContextConfiguration(locations = {"classpath:SpringConfig.xml"})
    public class BaseJunit {
    }
