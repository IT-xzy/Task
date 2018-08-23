package com.jnshu.czm.util;

import com.jnshu.czm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.rmi.Naming;
import java.util.Random;

public class SwitchService {

    private static Logger logger = LoggerFactory.getLogger(SwitchService.class);

//    private static ApplicationContext applicationContext =
//            new ClassPathXmlApplicationContext("rmiClient.xml");

    public static UserService getUserService() {
        UserService userService = null;
        Random random = new Random();
        int i = random.nextInt(2);
        if (i == 1) {
            try {

                logger.error("get data from server1");
                userService = (UserService) Naming.lookup("rmi://127.0.0.1:8088/UserService");
            } catch (Exception e) {
                try {
                    logger.error("error occurred,turn to server2");
                    userService = (UserService) Naming.lookup("rmi://127.0.0.1:8089/UserService");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        } else {
            try {
                logger.error("get data from server2");
                userService = (UserService) Naming.lookup("//127.0.0.1:8089/UserService");
            } catch (Exception e) {
                try {
                    int a=0;
                    logger.error("error occurred,turn to server1");
                    userService = (UserService) Naming.lookup("//127.0.0.1:8088/UserService");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
        return userService;
    }
}
