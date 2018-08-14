package com.stu.controller;

import com.stu.model.Student;
import com.stu.service.StudentService;
import com.stu.service.UserService;
import com.stu.service.impl.ProfessionServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.remoting.RemoteLookupFailureException;
import org.springframework.stereotype.Component;

@Component
public class RmiService {

    private static Logger logger = Logger.getLogger(RmiService.class);

    ApplicationContext act = new ClassPathXmlApplicationContext("applicationcontext.xml");
//    @Autowired
//    @Qualifier("userService")
//    private UserService userService;
//
//    @Autowired
//    @Qualifier("userServiceB")
//    private UserService userServiceB;
//
//    @Autowired
//    @Qualifier("studentServer")
//    private StudentService studentServer;
//
//    @Autowired
//    @Qualifier("studentServerB")
//    private StudentService studentServerB;

    public UserService getUserService() {
        return (UserService) act.getBean("userService");

    }
    public StudentService getStudentService() {
        return (StudentService) act.getBean("studentServer");
    }


//
//    public UserService getUserService() {
//
//        int rd = Math.random()>0.5?1:0;
//        if (rd==0){
//            try{
//                return (UserService) act.getBean("userService");
//            }catch (BeanCreationException b){
//                logger.info(b.getLocalizedMessage());
//                return (UserService) act.getBean("userServiceB");
//            }
//
//        }else {
//            try{
//                return (UserService) act.getBean("userServiceB");
//            }catch (BeanCreationException b){
//                logger.info(b.getLocalizedMessage());
//                return (UserService) act.getBean("userService");
//            }
//        }
//    }
//
//    public StudentService getStudentService() {
//
//
//        int rd = Math.random()>0.5?1:0;
//
//        if (rd==0){
//            try{
//                return (StudentService) act.getBean("studentServer");
//            }catch (BeanCreationException b){
//                logger.info(b.getLocalizedMessage());
//                return (StudentService) act.getBean("studentServerB");
//            }
//        }else {
//            try{
//                return (StudentService) act.getBean("studentServerB");
//            }catch (BeanCreationException b){
//                logger.info(b.getLocalizedMessage());
//                return (StudentService) act.getBean("studentServer");
//            }
//        }
//
//    }
//

}
