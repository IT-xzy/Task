package com.jnshu.services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SelectRMI {
    private static final Logger log = LoggerFactory.getLogger(SelectRMI.class);

    public static StudentsServices selectRMI() {
        ApplicationContext context = new ClassPathXmlApplicationContext("rmiServer.xml");
        StudentsServices studentsServices;
        int random = (int) (Math.random() * 2 + 1);
        if (random == 1) {
            try {
                log.info("调用端口8999内的远程对象方法");
                studentsServices = context.getBean("StudentsService1", StudentsServices.class);
                log.info("成功调用8999端口远程对象方法");
                return studentsServices;
            } catch (Exception e) {
                log.info("调用8999端口失败，尝试调用8998端口");
                studentsServices = context.getBean("StudentsService2", StudentsServices.class);
                log.info("调用8999远程对象方法成功");
                return studentsServices;
            }
        } else {
            try {
                log.info("调用端口8886内的远程对象方法");
                studentsServices = context.getBean("StudentsService2", StudentsServices.class);
                log.info("成功调用8886端口远程对象方法");
                return studentsServices;
            } catch (Exception e) {
                log.info("调用8886端口失败，尝试调用8885端口");
                studentsServices = context.getBean("StudentsService1", StudentsServices.class);
                log.info("调用8885远程对象方法成功");
                return studentsServices;
            }
        }
    }
}