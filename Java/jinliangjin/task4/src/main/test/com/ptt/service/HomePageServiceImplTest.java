package com.ptt.service;

import com.ptt.dao.IHomePageService;
import com.ptt.util.RandomNumber;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @ProjectName: task4
 * @Package: com.ptt.service
 * @ClassName: HomePageServiceImplTest
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/24 21:16
 * @UpdateUser:
 * @UpdateDate: 2018/5/24 21:16
 * @UpdateRemark:
 * @Version: 1.0
 */
public class HomePageServiceImplTest {

/*    AbstractApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("com.ptt/spring/applicationContext-dao.xml");
    IHomePageService homePageService = (IHomePageService)applicationContext.getBean("homePageServiceImpl");*/

    @Test
    public void getStudyStudentNum() {
//        System.out.println(homePageService.getGraduateStudentNum());
//        System.out.println(homePageService.getStudySteps());
//        System.out.println(homePageService.getStudyStudentNum());;
//        System.out.println(homePageService.getGraduateStudent());
    }

    @Test
    public void getGraduateStudentNum() {

//        homePageService.getGoodStudent(4);

    }

    @Test
    public void getStudySteps() {
    }

    @Test
    public void getGoodStudent() {

    }
}