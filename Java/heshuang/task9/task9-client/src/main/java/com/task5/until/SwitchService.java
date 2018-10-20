package com.task5.until;

import com.task5.service.EliteStudentsService;
import com.task5.service.ProfessionService;
import com.task5.service.StudentService;
import com.task5.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class SwitchService {
    private static Logger logger = Logger.getLogger("SwitchService.class");

    @Autowired
    @Qualifier("studentService1")
    private RmiProxyFactoryBean rmiProxyFactoryStudentBean1;

    @Autowired
    @Qualifier("eliteStudentService1")
    private RmiProxyFactoryBean rmiProxyFactoryEliteStudentBean1;

    @Autowired
    @Qualifier("professionService1")
    private RmiProxyFactoryBean rmiProxyFactoryProfessionBean1;

    @Autowired
    @Qualifier("userService1")
    private RmiProxyFactoryBean rmiProxyFactoryUserBean1;

    @Autowired
    @Qualifier("studentService2")
    private RmiProxyFactoryBean rmiProxyFactoryStudentBean2;

    @Autowired
    @Qualifier("eliteStudentService2")
    private RmiProxyFactoryBean rmiProxyFactoryEliteStudentBean2;

    @Autowired
    @Qualifier("professionService2")
    private RmiProxyFactoryBean rmiProxyFactoryProfessionBean2;

    @Autowired
    @Qualifier("userService2")
    private RmiProxyFactoryBean rmiProxyFactoryUserBean2;

    public StudentService getStudentService(){
        StudentService studentService;
        int i = Math.random() >= 0.5 ? 1 : 0;
        if (i == 1){
            try{
                logger.error("get data from studentService1");
                studentService = (StudentService) rmiProxyFactoryStudentBean1.getObject();
            }
            catch (Exception e){
                logger.error("get data from studentService2");
                studentService = (StudentService) rmiProxyFactoryStudentBean2.getObject();
            }
        }
        else try {
            logger.error("get data from studentService2");
            studentService = (StudentService) rmiProxyFactoryStudentBean2.getObject();
        }catch (Exception e){
            logger.error("get data from studentService1");
            studentService = (StudentService) rmiProxyFactoryStudentBean1.getObject();
        }
        return studentService;
    }

    public EliteStudentsService getEliteStudentsService(){
        EliteStudentsService eliteStudentsService;
        int i = Math.random() >= 0.5 ? 1 : 0;
        if (i == 1){
            try{
                logger.error("get data from eliteStudentsService1");
                eliteStudentsService = (EliteStudentsService) rmiProxyFactoryEliteStudentBean1.getObject();
            }
            catch (Exception e){
                logger.error("get data from eliteStudentsService2");
                eliteStudentsService = (EliteStudentsService) rmiProxyFactoryEliteStudentBean2.getObject();
            }
        }
        else try {
            logger.error("get data from eliteStudentsService2");
            eliteStudentsService = (EliteStudentsService) rmiProxyFactoryEliteStudentBean2.getObject();
        }catch (Exception e){
            logger.error("get data from eliteStudentsService1");
            eliteStudentsService = (EliteStudentsService) rmiProxyFactoryEliteStudentBean1.getObject();
        }
        return eliteStudentsService;
    }

    public ProfessionService getProfessionService(){
        ProfessionService professionService;
        int i = Math.random() >= 0.5 ? 1 : 0;
        if (i == 1){
            try{
                logger.error("get data from professionService1");
                professionService = (ProfessionService) rmiProxyFactoryProfessionBean1.getObject();
            }
            catch (Exception e){
                logger.error("get data from professionService2");
                professionService = (ProfessionService) rmiProxyFactoryProfessionBean2.getObject();
            }
        }
        else try {
            logger.error("get data from professionService2");
            professionService = (ProfessionService) rmiProxyFactoryProfessionBean2.getObject();
        }catch (Exception e){
            logger.error("get data from professionService1");
            professionService = (ProfessionService) rmiProxyFactoryProfessionBean1.getObject();
        }
        return professionService;
    }

    public UserService getUserService(){
        UserService userService;
        int i = Math.random() >= 0.5 ? 1 : 0;
        if (i == 1){
            try{
                logger.error("get data from userService1");
                userService = (UserService) rmiProxyFactoryUserBean1.getObject();
            }
            catch (Exception e){
                logger.error("get data from userService2");
                userService = (UserService) rmiProxyFactoryUserBean2.getObject();
            }
        }
        else try {
            logger.error("get data from userService2");
            userService = (UserService) rmiProxyFactoryUserBean2.getObject();
        }catch (Exception e){
            logger.error("get data from userService1");
            userService = (UserService) rmiProxyFactoryUserBean1.getObject();
        }
        return userService;
    }

}
