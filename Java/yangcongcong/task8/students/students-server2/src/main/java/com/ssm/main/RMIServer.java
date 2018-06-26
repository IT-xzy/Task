package com.ssm.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RMIServer {
    private static final Logger logger = LoggerFactory.getLogger(RMIServer.class);

    public static void main(String[] args)  {
        new ClassPathXmlApplicationContext("applicationContext.xml");
        logger.info(" successful startup server2...");
    }
}
