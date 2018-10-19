package com.jnshu.czm.util;

import com.jnshu.czm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

public class SwitchService {

    private static Logger logger = LoggerFactory.getLogger(SwitchService.class);

    private static ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("rmiClient.xml");

    public static UserService getUserService() {
        UserService userService = null;
        Random random = new Random();
        int i = random.nextInt(2);
        if (i == 1) {
            try {
//                ApplicationContext applicationContext =
//                        new ClassPathXmlApplicationContext("rmiClient.xml");
                logger.error("get data from server1");
                userService = (UserService) applicationContext.getBean("RmiService1");
            } catch (Exception e) {
//                ApplicationContext applicationContext =
//                        new ClassPathXmlApplicationContext("rmiClient.xml");
                logger.error("get a error,turn to server2");
                userService = (UserService) applicationContext.getBean("RmiService2");
            }
        } else {
            try {
//                ApplicationContext applicationContext =
//                        new ClassPathXmlApplicationContext("rmiClient.xml");
                logger.error("get data from server2");
                userService = (UserService) applicationContext.getBean("RmiService2");
            } catch (Exception e) {
//                ApplicationContext applicationContext =
//                        new ClassPathXmlApplicationContext("rmiClient.xml");
                logger.error("get a error,turn to server1");
                userService = (UserService) applicationContext.getBean("RmiService1");
            }
        }
        return userService;
    }
}
