package com.zyq.util;

import com.zyq.service.ExcellentStudentService;
import com.zyq.service.ProfessionService;
import com.zyq.service.StudentService;
import com.zyq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class RandomService {

    @Autowired
    @Qualifier("professionService1")
    private RmiProxyFactoryBean rmiProxyFactoryProfessionBean1;

    @Autowired
    @Qualifier("excellentStudentService1")
    private RmiProxyFactoryBean rmiProxyFactoryExcellentStudentBean1;

    @Autowired
    @Qualifier("studentService1")
    private RmiProxyFactoryBean rmiProxyFactoryStudentBean1;


    @Autowired
    @Qualifier("userService1")
    private RmiProxyFactoryBean rmiProxyFactoryUserBean1;

    @Autowired
    @Qualifier("professionService2")
    private RmiProxyFactoryBean rmiProxyFactoryProfessionBean2;

    @Autowired
    @Qualifier("excellentStudentService2")
    private RmiProxyFactoryBean rmiProxyFactoryExcellentStudentBean2;

    @Autowired
    @Qualifier("studentService2")
    private RmiProxyFactoryBean rmiProxyFactoryStudentBean2;


    @Autowired
    @Qualifier("userService2")
    private RmiProxyFactoryBean rmiProxyFactoryUserBean2;

    public StudentService getStudentService() {
        StudentService studentService;
        int randomNum = Math.random() >= 0.5 ? 1 : 0;
        if (1 == randomNum) {
            try {
                studentService = (StudentService) rmiProxyFactoryStudentBean1.getObject();
            } catch (Exception e) {
                studentService = (StudentService) rmiProxyFactoryStudentBean2.getObject();
            }
        } else {
            try {
                studentService = (StudentService) rmiProxyFactoryStudentBean2.getObject();
            } catch (Exception e) {
                studentService = (StudentService) rmiProxyFactoryStudentBean1.getObject();
            }
        }
        return studentService;
    }

    public ExcellentStudentService getExcellentStudentService() {
        ExcellentStudentService excellentStudentService;
        int randomNum = Math.random() >= 0.5 ? 1 : 0;
        if (1 == randomNum) {
            try {
                excellentStudentService = (ExcellentStudentService) rmiProxyFactoryExcellentStudentBean1.getObject();
            } catch (Exception e) {
                excellentStudentService = (ExcellentStudentService) rmiProxyFactoryExcellentStudentBean2.getObject();
            }
        } else {
            try {
                excellentStudentService = (ExcellentStudentService) rmiProxyFactoryExcellentStudentBean2.getObject();
            } catch (Exception e) {
                excellentStudentService = (ExcellentStudentService) rmiProxyFactoryExcellentStudentBean1.getObject();
            }
        }
        return excellentStudentService;
    }

    public ProfessionService getProfessionService() {
        ProfessionService professionService;
        int randomNum = Math.random() >= 0.5 ? 1 : 0;
        if (1 == randomNum) {
            try {
                professionService = (ProfessionService) rmiProxyFactoryProfessionBean1.getObject();
            } catch (Exception e) {
                professionService = (ProfessionService) rmiProxyFactoryProfessionBean2.getObject();
            }
        } else {
            try {
                professionService = (ProfessionService) rmiProxyFactoryProfessionBean2.getObject();
            } catch (Exception e) {
                professionService = (ProfessionService) rmiProxyFactoryProfessionBean1.getObject();
            }
        }
        return professionService;
    }

    public UserService getUserService() {
        UserService userService;
        int randomNum = Math.random() >= 0.5 ? 1 : 0;
        if (1 == randomNum) {
            try {
                userService = (UserService) rmiProxyFactoryUserBean1.getObject();
            } catch (Exception e) {
                userService = (UserService) rmiProxyFactoryUserBean2.getObject();
            }
        } else {
            try {
                userService = (UserService) rmiProxyFactoryUserBean2.getObject();
            } catch (Exception e) {
                userService = (UserService) rmiProxyFactoryUserBean1.getObject();
            }
        }
        return userService;
    }
}
