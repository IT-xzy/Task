package com.myServer;

import com.Logger.LogInterceptor;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyServer {

    private static final Logger logger=Logger.getLogger(LogInterceptor.class);

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("applicationContext.xml");
        logger.info("服务器已启动");
    }
}
