package com.task8.util;

import com.task8.service.LoginService;
import com.task8.service.ProfessionService;
import com.task8.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;


/**
 * Create by SongWu on 2018/8/18
 */

public class RmiServerUtil {

    Logger logger = Logger.getLogger(RmiServerUtil.class);


      LoginService loginService;

    UserService userService ;

    ProfessionService professionService ;

    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public ProfessionService getProfessionService() {
        return professionService;
    }

    public void setProfessionService(ProfessionService professionService) {
        this.professionService = professionService;
    }

    public  RmiServerUtil() {

        ApplicationContext context = registratContext();
        this.loginService =(LoginService) context.getBean("myRMIClient1-1");
        this.userService =(UserService) context.getBean("myRMIClient2-1");
        this.professionService = (ProfessionService) context.getBean("myRMIClient3-1");
    }

    private ApplicationContext registratContext(){
        Random random = new Random();
        ApplicationContext context;
        //捕捉BeanCreationException,如果发现该异常,说明该服务被中断,转向另一个服务
        if (random.nextInt(10) % 2 == 0) {

            try {

                context = new ClassPathXmlApplicationContext("spring/applicationContext-rmi-a.xml");
                logger.info("调用双a");
            } catch (BeanCreationException e) {
                context = new ClassPathXmlApplicationContext("spring/applicationContext-rmi-b.xml");
                logger.info("调用双b");
            }
        } else {


            try {
                context = new ClassPathXmlApplicationContext("spring/applicationContext-rmi-b.xml");
               logger.info("调用单b");
            } catch (BeanCreationException e) {
                context = new ClassPathXmlApplicationContext("spring/applicationContext-rmi-a.xml");
                logger.info("调用单a");

            }
        }

        return context;
    }

    public void getBeanAgain(){

        ApplicationContext context = registratContext();
        this.loginService = context.getBean("myRMIClient1-1", LoginService.class);
        this.userService = context.getBean("myRMIClient2-1",UserService.class);
        this.professionService = context.getBean("myRMIClient3-1", ProfessionService.class);
    }
}
