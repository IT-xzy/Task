package com.fml.rmi;

import com.fml.service.EmailService;
import com.fml.service.StudentService;
import com.fml.service.VocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DistributeServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(DistributeServer.class);
    @Autowired
    ServerA serverA;
    @Autowired
    ServerB serverB;
    /*定义随机数*/
    private static int random;

    public StudentService getStudentService(){
        random = getRandom();
        if (random == 1){
            LOGGER.info("使用8081端口的服务.");
            return serverA.getStudentService();
        } else {
            LOGGER.info("使用8082端口的服务.");
            return serverB.getStudentService();
        }
    }

    public EmailService getEmailService(){
        random = getRandom();
        if (random == 1){
            LOGGER.info("使用8081端口的服务.");
            return serverA.getEmailService();
        } else {
            LOGGER.info("使用8082端口的服务.");
            return serverB.getEmailService();
        }
    }

    public VocationService getVocationService(){
        random = getRandom();
        if (random == 1){
            LOGGER.info("使用8081端口的服务.");
            return serverA.getVocationService();
        } else {
            LOGGER.info("使用8082端口的服务.");
            return serverB.getVocationService();
        }
    }

    private static int getRandom(){
        random = (int)(Math.random() * 2);
        return random;
    }
}
