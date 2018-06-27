package hzw.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class RedisDemo {

    public static void main(String[] args) {

        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        RedisUtil redisUtil=(RedisUtil) context.getBean("redisUtil");


//        redisUtil.set("han","炸死你大立科技哦");
        System.out.println(redisUtil.get("hand"));
//
//
//        redisUtil.set("foo",312312);
//        System.out.println(redisUtil.get("foo"));
    }
}
