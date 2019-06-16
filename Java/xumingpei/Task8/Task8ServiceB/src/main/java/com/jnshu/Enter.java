package com.jnshu;

import com.alibaba.fastjson.JSON;
import com.jnshu.tool.redis.Redis;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

/**
 * @author pipiretrak
 * @date 2019/6/5 - 17:42
 */
public class Enter {
    private static Logger logger = Logger.getLogger(Enter.class);
    public static void main(String[] args){
        String port = "2223";
        ApplicationContext context = new ClassPathXmlApplicationContext ("spring-mybatis.xml");
        context.getBean ("RMIJob");
        context.getBean ("RMIStudent");
        context.getBean("RMIUser");
        logger.info ("启动的端口号为" + port);

        ApplicationContext context1 = new ClassPathXmlApplicationContext ("spring-redis.xml");
        Redis redis = (Redis) context1.getBean ("redis");
        logger.info ("成功获取Redis的bean");
        if (redis.getObj ("rmi", "port") == null) {
            ArrayList list = new ArrayList ();
            list.add (port);
            redis.addObj ("rmi", "port", list);
            logger.info ("使用的端口为" + JSON.toJSONString (redis.getObj ("rmi", "port")));
        } else {
            ArrayList list = (ArrayList) redis.getObj ("rmi", "port");
            list.add (port);
            redis.addObj ("rmi", "port", list);
            logger.info ("使用的端口为" + JSON.toJSONString (redis.getObj ("rmi", "port")));
        }
        logger.info ("开始工作");


    }
}
