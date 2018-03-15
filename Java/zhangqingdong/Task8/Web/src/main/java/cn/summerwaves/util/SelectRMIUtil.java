package cn.summerwaves.util;

import cn.summerwaves.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

public class SelectRMIUtil {
    private static Logger logger = Logger.getLogger(SelectRMIUtil.class);


    @Lazy
    public static IUserService getUserService() {
        IUserService userService = null;

        Random random = new Random();
        int i = random.nextInt(2) + 1;
        if (i == 1) {
            try {
                ApplicationContext ctx = new ClassPathXmlApplicationContext("RMI.xml");
                logger.error("get data from server1");
                userService = (IUserService) ctx.getBean("userService1");

            } catch (Exception e) {
                ApplicationContext ctx = new ClassPathXmlApplicationContext("RMI.xml");
                logger.error("get a error,turn to server2");
                userService = (IUserService) ctx.getBean("userService2");

            }
        } else {
            try {
                ApplicationContext ctx = new ClassPathXmlApplicationContext("RMI.xml");
                logger.error("get data from server2");
                userService = (IUserService) ctx.getBean("userService2");

            } catch (Exception e) {
                ApplicationContext ctx = new ClassPathXmlApplicationContext("RMI.xml");
                logger.error("get a error,turn to server1");
                userService = (IUserService) ctx.getBean("userService1");

            }
        }
        return userService;
    }
}
