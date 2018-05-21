package com.student.util;

import com.student.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SelectRMI {
    private static final Logger log = LoggerFactory.getLogger(SelectRMI.class);
    private ApplicationContext context = new ClassPathXmlApplicationContext("rmiServer.xml");
    private int random = (int) (Math.random() * 2 + 1);

    public StudentService selectRMI() {
        if (random == 1) {
            log.info("调用端口8885内的远程对象方法");
            try {
                StudentService studentService1 = context.getBean("myRMIClient1", StudentService.class);
                log.info("成功调用8885端口远程对象方法");
                return studentService1;
            } catch (Exception e) {
                log.info("调用8885端口失败，尝试调用8886端口");
                StudentService studentService2 = context.getBean("myRMIClient2", StudentService.class);
                log.info("调用8886远程对象方法成功");
                return studentService2;
            }
        } else {
            log.info("调用端口8886内的远程对象方法");
            try {
                StudentService studentService2 = context.getBean("myRMIClient2", StudentService.class);
                log.info("成功调用8886端口远程对象方法");
                return studentService2;
            } catch (Exception e) {
                log.info("调用8886端口失败，尝试调用8885端口");
                StudentService studentService1 = context.getBean("myRMIClient1", StudentService.class);
                log.info("调用8885远程对象方法成功");
                return studentService1;
            }
        }
    }
}