package com.Tools;


import com.service.Service0;

import com.service.Service1;
import com.service.Service2;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SwitchService {

    private static Logger logger=Logger.getLogger(SwitchService.class);
    private Service0 service0;

    private static int swichNumber(){
        int i= (int) (Math.random()*2);
        System.out.println(i);
        return i;
    }

    public Service0 getService0(){
        logger.info("进入getService");
        ApplicationContext ap=new ClassPathXmlApplicationContext("spring_rmi_client.xml");
        int i=SwitchService.swichNumber();
        if (i==0){
            try {
                logger.info("随机数是 "+"1"+"调用service1接口");
                service0 = (Service0) ap.getBean("service1");
                service0.findStudentById(1);
            }catch (RuntimeException e){
                try {
                    logger.info("service1接口崩溃，调用service2接口");
                    service0 = (Service0) ap.getBean("service2");
                    service0.findStudentById(1);
                }catch (RuntimeException r){
                    logger.info("两个服务器接口全部崩溃，请联系管理员");
                }
            }
        }else {
            try {
                logger.info("随机数是 "+"2"+"调用service2接口");
                service0 = (Service0) ap.getBean("service2");
                service0.findStudentById(1);
            }catch (RuntimeException e){
                try {
                    logger.info("service2接口崩溃，调用service1接口");
                    service0 = (Service0) ap.getBean("service1");
                    service0.findStudentById(1);
                }catch (RuntimeException r){
                    logger.info("两个服务器接口全部崩溃，请联系管理员");
                }
            }
        }
        return service0;
    }
}
