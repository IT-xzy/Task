package com.lihoo.ssm.RMI;

import com.lihoo.ssm.service.StudentListService;
import com.lihoo.ssm.util.commonUtil.RandomNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * #Title: StudentServiceFactory
 * #ProjectName task8_index6*student service工厂类，生产工厂类。
 * #Description: TODO
 * #author lihoo
 * #date 2018/10/12-19:55
 * @author lihoo
 */



@Component
public class StudentServiceFactory {
    private static Logger logger = LoggerFactory.getLogger(StudentServiceFactory.class);
    private static StudentListService studentService1;
    private static StudentListService studentService2;

    public static StudentListService getInstance() {
        StudentListService studentService = null;
        int i = Integer.parseInt(RandomNumber.randomVCode(1));
        AbstractApplicationContext aac = new
                ClassPathXmlApplicationContext("applicationContext.xml");

        logger.info("i：{}", i);
        if (i % 2 == 0) {
            try {
                logger.info("开始调用service1");
                studentService = (StudentListService) aac.getBean("studentService1");
//                studentService =studentService1;
            } catch (Exception e) {
                logger.info("studentService1异常：{}", e.getMessage());
                studentService = studentService2;
            }
            return studentService;
        }
        try {
            logger.info("开始调用service2");
            studentService = (StudentListService) aac.getBean("studentService2");
//            studentService = studentService2;

        } catch (Exception e) {
            logger.info("studentService1异常：{}", e.getMessage());
            studentService = studentService1;
        }
//        return studentService=(StudentListService) aac.getBean("studentService1");
        return studentService;


    }

//    @Resource
    @Autowired
    public void setStudentService1(StudentListService studentService1) {
        StudentServiceFactory.studentService1 = studentService1;
    }

//    @Resource
    @Autowired
    public void setStudentService2(StudentListService studentService2) {
        StudentServiceFactory.studentService2 = studentService2;
    }













/*    public static IStudentService getInstance(){
        IStudentService studentService = null;
        int i = Integer.parseInt(RandomNumber.randomVCode(1));
        AbstractApplicationContext aac = new
                ClassPathXmlApplicationContext("spring/applicationContext-RMI.xml");

        logger.info("i：{}", i);
        if (i % 2 == 0){
            try {
                studentService = (IStudentService) aac.getBean("studentService1");
            } catch (Exception e) {
                logger.info("studentService1异常：{}", e.getMessage());
                studentService = (IStudentService) aac.getBean("studentService2");
            }
            return studentService;
        }
        try {
            studentService = (IStudentService) aac.getBean("studentService2");
        } catch (Exception e) {
            logger.info("studentService1异常：{}", e.getMessage());
            studentService = (IStudentService) aac.getBean("studentService1");
        }
        return studentService;
    }*/
}
