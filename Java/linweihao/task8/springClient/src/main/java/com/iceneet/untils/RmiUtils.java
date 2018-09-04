package com.iceneet.untils;


import com.iceneet.service.Service;
import com.iceneet.service.Signupservice;
import com.iceneet.service.Signupservice1;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.util.Random;

public class RmiUtils {
    private Logger logger = Logger.getLogger(RmiUtils.class);

    public Service getService(){
        Random random=new Random();
        Service service;
        int sign = random.nextInt(2);
        System.out.println(sign);
        if(sign==0){
            try {
                logger.info("连接服务器1");
                service=getSignupservice();
            }catch (Exception e){
                logger.info("连接服务器1失败，重连服务器2");
                service=getSignupservice1();
            }
            return service;
        }

        try {
            logger.info("连接服务器2");
            service=getSignupservice1();
        }catch (Exception e){
            logger.info("连接服务器2失败，重连服务器1");
            service=getSignupservice();
            return service;
        }
        return service;
    }


    public  Signupservice getSignupservice(){

        Signupservice signupservice;
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-service.xml");
        signupservice = (Signupservice) context.getBean("signupservice");
        System.out.println(signupservice);
        return signupservice;
    }
    public Signupservice1 getSignupservice1(){

        Signupservice1 signupservice1;
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-service.xml");
        signupservice1 = (Signupservice1) context.getBean("signupservice1");
        System.out.println(signupservice1);
        return signupservice1;
    }
}
