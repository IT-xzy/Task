package com.ssm.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServerMain {
    private static final Logger logger = LoggerFactory.getLogger(ServerMain.class);

    public static void main(String[] args)  {
        new ClassPathXmlApplicationContext("applicationContext.xml");
        logger.info(" successful startup server1...");
    }
}
