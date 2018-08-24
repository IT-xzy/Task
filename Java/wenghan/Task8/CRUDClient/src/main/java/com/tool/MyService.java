package com.tool;

import com.service.Service;
import com.service.UserService;
import com.service.UserService1;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Random;

public class MyService {

    private Logger logger=Logger.getLogger(MyService.class);

    public Service getService(){
        Random random=new Random();
        Service service;
        if(random.nextInt(2)==0){
            try {
                logger.info("连接服务器1");
                service=getUseService();
            }catch (Exception e){
                logger.info("连接服务器1失败，重连服务器2");
                service=getUseService1();
            }
            return service;
        }

        try {
            logger.info("连接服务器2");
            service=getUseService1();
        }catch (Exception e){
            logger.info("连接服务器2失败，重连服务器1");
            service=getUseService();
            return service;
        }
        return service;
    }


    private UserService getUseService(){
        UserService userService;
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        userService=(UserService)context.getBean("serviceProxy");
        logger.info("serviceProxy");
        logger.info(userService);
        if(userService!=null) {
            return userService;
        }else {
            logger.info("空值错误");
            return null;
        }
    }

    private UserService1 getUseService1(){
        UserService1 userService1;
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        userService1=(UserService1)context.getBean("serviceProxy1");
        if(userService1!=null) {
            logger.info("serviceProxy1");
            logger.info(userService1);
            return userService1;
        }else {
            logger.info("空值错误");
            return null;
        }
    }
}
