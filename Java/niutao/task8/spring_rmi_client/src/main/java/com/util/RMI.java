package com.util;

import com.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RMI {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(RMI.class);

    public static StudentService getService() {

        StudentService studentService;

        int i = (int) (Math.random() * 2);
        if (i == 0) {
            try {
                AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RmiConfig.class);
                studentService = (StudentService) context.getBean("rmiservice1199");
                logger.info("service1199 action");
            } catch (Exception e) {
                AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RmiConfig.class);
                studentService = (StudentService) context.getBean("rmiservice1198");
                logger.info("service1199 bad to service1198 action");
            }

        } else {
            try {
                AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RmiConfig.class);
                studentService = (StudentService) context.getBean("rmiservice1198");
                logger.info("service1198 action");
            } catch (Exception e) {
                AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RmiConfig.class);
                studentService = (StudentService) context.getBean("rmiservice1199");
                logger.info("service1198 bad to service1199 action");
            }
        }
        return studentService;
    }
}
