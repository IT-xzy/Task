package com.ssm.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetBeanAndRandomSelect {
    private static final Logger logger = LoggerFactory.getLogger(GetBeanAndRandomSelect.class);

    //加载配置文件，获取userReg bean
    private static Object getServiceBean(String beanName) {

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("rmiClient.xml");
        return  applicationContext.getBean(beanName);
    }

    //选择调用userReg的server
    public static Object randomSelect(String beanName1,String beanName2) {
        Object object;
        //产生0-9随机数
        int randomNum = (int) (Math.random() * 10);
        //判断奇偶性
        try {
            if (randomNum % 2 != 0) {
                logger.info("奇数try调用 NO.1 service");
                object = getServiceBean(beanName1);
            } else {
                logger.info("偶数try调用 NO.2 service");
                object = getServiceBean(beanName2);
            }
        } catch (Exception e) {
            logger.error("catch:" + e);
            if (randomNum % 2 == 0) {
                logger.info("偶数，调用catch内 NO.1");
                object = getServiceBean(beanName1);
            } else {
                logger.info("奇数，调用catch内 NO.2");
                object = getServiceBean(beanName2);
            }
        }
        return object;
    }

}
