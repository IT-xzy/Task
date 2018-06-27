package com.task.test;


import com.task.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    private static final Logger logger = LoggerFactory.getLogger(TestMain.class);

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
        RedisUtil redisUtil = (RedisUtil) context.getBean("redisUtil");

        redisUtil.set("name", "王守仁");
        logger.info("读取name:"+redisUtil.get("name").toString());
    }
}
