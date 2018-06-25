package com.fangyuyang.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.net.Socket;
import java.util.Random;

import static org.junit.Assert.*;

public class LearnerServiceTest {

    @Test
    public void findLearnerById() {
        BeanFactory f = new ClassPathXmlApplicationContext("applicationContext.xml");
        String learner1 = "learnerClient";
        String learner2 = "learnerClient1";
        double count = 3;
        System.out.println("count: "+ count);
        if(count<5){
            try {
                LearnerService learnerService = (LearnerService) f.getBean(learner1);
                System.out.println(learnerService.findLearnerById(8));
                System.out.println("第一次成功1");

            }catch (Exception e){
                LearnerService learnerService = (LearnerService) f.getBean(learner2);
                System.out.println("learner2: "+learnerService.findLearnerById(8));
            }
        }else {
            try {
                LearnerService learnerService = (LearnerService) f.getBean(learner2);
                System.out.println(learnerService.findLearnerById(8));
                System.out.println("第一次成功2");
            }catch (Exception e){
                LearnerService learnerService = (LearnerService) f.getBean(learner1);
                System.out.println("learner1: "+learnerService.findLearnerById(8));
            }
        }



    }
}