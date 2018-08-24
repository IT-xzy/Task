package com.jnshu.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainServer {

    private static final Logger logger = LoggerFactory.getLogger(MainServer.class);

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        logger.info("\nrmi服务端启动");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mybatis.xml");

        logger.info("\nrmi服务端1启动完成。。。");
    }
}
