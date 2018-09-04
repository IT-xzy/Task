package com.jnshu;

import com.jnshu.service.ESService;
import com.jnshu.service.JIService;
import com.jnshu.service.SNService;
import com.jnshu.service.UserService;
import com.jnshu.tools.Redis;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import java.rmi.Naming;
import java.rmi.RemoteException;

public  class RMIClient {

    private static Logger logger = Logger.getLogger(RMIClient.class);

     ESService eSService;

     JIService jiService;

     SNService snService;

     UserService userService;

    public void setJiService(JIService jiService) {
        this.jiService = jiService;
    }

    public void setSnService(SNService snService) {
        this.snService = snService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    public void setEsService(ESService eSService) {
        this.eSService = eSService;
    }


    public ESService geteSService() {
        return eSService;
    }

    public JIService getJiService() {
        return jiService;
    }

    public SNService getSnService() {
        return snService;
    }

    public UserService getUserService() {
        return userService;
    }



    public static RMIClient server() {

        ApplicationContext context;

        RMIClient rmiClient;

        int i = Math.random() > 0.5 ? 1 : 0;
        String a = "ServerA";
        String b = "ServerB";
        String name[] = {a, b};
        Redis redis = new Redis();
        String serverName = name[i];
        String another = name[1 - i];
        logger.info("选择服务器名称" + serverName);
        if (redis.getCacheObject(serverName) == null) {
            logger.info(serverName + "服务器异常，重新选择服务器名称" + another);
            if (redis.getCacheObject(another) == null) {
                logger.info("服务器都坏了");
                return null;
            } else {
                context = new ClassPathXmlApplicationContext(another + ".xml");
                rmiClient = (RMIClient) context.getBean("rmiClient");

            }
        } else {
            context = new ClassPathXmlApplicationContext(serverName + ".xml");
            rmiClient = (RMIClient) context.getBean("rmiClient");
        }
        return rmiClient;
    }






//    public void run() {
//        try {
//            String s = eSService.findById(1).getName();
//            String ji = jiService.findById(1).getJobName();
//            Integer sn = snService.findById(1).getFindJobNum();
//            String us = userService.findById(1).getUserName();
//            System.out.println(ji + "\n" + sn + "\n" + us + "\n" + s);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//    }
}