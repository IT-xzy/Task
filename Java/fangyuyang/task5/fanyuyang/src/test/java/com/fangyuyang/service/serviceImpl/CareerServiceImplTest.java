package com.fangyuyang.service.serviceImpl;

import com.fangyuyang.service.CareerService;
import com.fangyuyang.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CareerServiceImplTest {
    @Resource
    private UserService userService;
    @Resource
    private CareerService careerService;
    @Test
    public void findCareerById() {
        System.out.println("ceshi"+careerService.findCareerById(8));
    }

}