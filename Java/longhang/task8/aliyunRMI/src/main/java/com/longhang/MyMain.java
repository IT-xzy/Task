package com.longhang;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class MyMain{
    private static Logger logger= Logger.getLogger("MyTest.class");
        public static void main(String[] args){
            new ClassPathXmlApplicationContext("applicationContext.xml");
           logger.info("配置文件加载成功");
        }
}
