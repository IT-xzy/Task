package cn.summerwaves.util;

import cn.summerwaves.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Random;

public class SelectRMIUtil {
    private static Logger logger = Logger.getLogger(SelectRMIUtil.class);


    public static IUserService getUserService() {
        IUserService userService = null;

        Random random = new Random();
        int i = random.nextInt(2) + 1;
        if (i == 1) {
            try {
                logger.error("get data from server1");
                userService = (IUserService) Naming.lookup("//127.0.0.1:2224/userRMIService");

            } catch (Exception e) {
                try {
                    logger.error("error occurred,turn to server2");
                    userService = (IUserService) Naming.lookup("//127.0.0.1:2225/userRMIService");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
        } else {
            try {
                logger.error("get data from server2");
                userService = (IUserService) Naming.lookup("//127.0.0.1:2225/userRMIService");

            } catch (Exception e) {
                try {
                    logger.error("error occurred,turn to server1");
                    userService = (IUserService) Naming.lookup("//127.0.0.1:2224/userRMIService");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
        return userService;
    }
}
