package com.ptteng.client;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MyRMIClient {
    private static Logger logger= Logger.getLogger(MyRMIClient.class);

    public MyRMIClient() {
        logger.info("进入MyRMIClient");
    }

    public static Object getServiceBean(String rmiClient,String beanName) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(rmiClient);
        return ac.getBean(beanName);
    }

    public static Object object(String beanName1, String beanName2) {
        Object className;
        String rmiClient="rmiClient.xml";
        String rmiClient2="rmiClient2.xml";
        Random random=new Random();
        int i =  random.nextInt(2)+1;
        try {
            logger.info("正常启动");
            if (i ==1) {
                className = getServiceBean(rmiClient,beanName1);
            } else {
                className = getServiceBean(rmiClient2,beanName2);
            }
            logger.info("调用了\t" + className);
        } catch (Exception e) {
            logger.info("dang机一个");
            if (i==2) {
                className = getServiceBean(rmiClient,beanName1);
            } else {
                className = getServiceBean(rmiClient2,beanName2);
            }
            logger.info("调用了\t" + className);
        }
        return className;
    }
}
