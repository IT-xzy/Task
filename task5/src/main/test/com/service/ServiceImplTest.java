package com.service;
import com.pojo.Occupation;
import com.pojo.Trainees;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class ServiceImplTest {
    @Resource
    private ServiceIF serviceIF;
    private static Logger  logger=Logger.getLogger(ServiceImplTest.class);
    private int i;
    @Test
    public void accountStudents() {
        i=serviceIF.accountStudents();
        logger.info(i);
    }

    @Test
    public void countOccupation() {
        i=serviceIF.countOccupation();
        logger.info(i);
    }

    @Test
    public void lessonAll() {
        i=serviceIF.lessonAll(2);
        logger.info(i);
    }

    @Test
    public void niceStudents() {
        List<Trainees> traineesList;
        traineesList=serviceIF.niceStudents();
        logger.info(traineesList);
    }

    @Test
    public void queryAllOccupation() {
        List<Occupation> occupationList;
        occupationList=serviceIF.queryAllOccupation();
        logger.info(occupationList);
    }

    @Test
    public void queryAllOccupationAndLesson(){
        serviceIF.queryAllOccupationAndLesson();
    }

    @Test
    public void checkPwd() {
        Trainees tr=serviceIF.checkPwd("123");
        logger.info(tr);
    }

    @Test
    public void loginTrainees() {
        Trainees trainees=new Trainees();
        trainees.setPassword("000");
        trainees.setAccount("000");
        int i=serviceIF.loginTrainees(trainees);
        logger.info(i);
    }

    @Test
    public void enterPage() {
        Trainees trainees=new Trainees();
        trainees.setAccount("000");
        trainees.setPassword("000");
        int i=serviceIF.enterPage(trainees);
        logger.info(i);
    }
}