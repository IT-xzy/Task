package com.ptt.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: Service
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/6/22 22:09
 * @Version: 1.0
 */
public class Service {
    private static Logger logger = LoggerFactory.getLogger(Service.class);
    public static void main(String[] args) {
        logger.info("RMI1服务端");
        AbstractApplicationContext aac =
                new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
    }
}
