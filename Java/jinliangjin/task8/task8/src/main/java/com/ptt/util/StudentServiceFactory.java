package com.ptt.util;

import com.ptt.service.IStudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName: StudentServiceFactory
 * @Description: student service工厂类，生产工厂类。
 * @Author: Jin
 * @CreateDate: 2018/6/26 12:19
 * @Version: 1.0
 */
@Component
public class StudentServiceFactory {
    private static Logger logger = LoggerFactory.getLogger(StudentServiceFactory.class);
    private static IStudentService studentService1;
    private static IStudentService studentService2;

    public static IStudentService getInstance() {
        IStudentService studentService = null;
        int i = Integer.parseInt(RandomNumber.randomVCode(1));
        AbstractApplicationContext aac = new
                ClassPathXmlApplicationContext("spring/applicationContext-RMI.xml");

        logger.info("i：{}", i);
        if (i % 2 == 0) {
            try {
                studentService = studentService1;
            } catch (Exception e) {
                logger.info("studentService1异常：{}", e.getMessage());
                studentService = studentService2;
            }
            return studentService;
        }
        try {
            studentService = studentService2;
        } catch (Exception e) {
            logger.info("studentService1异常：{}", e.getMessage());
            studentService = studentService1;
        }
        return studentService;


    }

    @Resource
    public void setStudentService1(IStudentService studentService1) {
        this.studentService1 = studentService1;
    }

    @Resource
    public void setStudentService2(IStudentService studentService2) {
        this.studentService2 = studentService2;
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
