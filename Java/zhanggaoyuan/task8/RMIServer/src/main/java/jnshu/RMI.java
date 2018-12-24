package jnshu;

import com.alibaba.fastjson.JSON;
import jnshu.tool.redis.Redis;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

//@Component
//@PropertySource("classpath:properties/RMI.properties")
public class RMI {
    private static Logger logger = Logger.getLogger (String.valueOf (RMI.class));


    public static void main(String[] args) {
        String port = "1021";
        ApplicationContext context = new ClassPathXmlApplicationContext ("spring-mybatis.xml");
        context.getBean ("stRMI");
        context.getBean ("pfRMI");
        logger.info ("启动的端口号为" + port);

        ApplicationContext context1 = new ClassPathXmlApplicationContext ("spring-redis.xml");
        Redis redis = (Redis) context1.getBean ("redis");
        logger.info ("成功获取Redis的bean");
        if (redis.getHashMap ("rmi", "port") == null) {
            ArrayList list = new ArrayList ();
            list.add (port);
            redis.setHashMap ("rmi", "port", list);
            logger.info ("使用的端口为" + JSON.toJSONString (redis.getHashMap ("rmi", "port")));
        } else {
            ArrayList list = (ArrayList) redis.getHashMap ("rmi", "port");
            list.add (port);
            redis.setHashMap ("rmi", "port", list);
            logger.info ("使用的端口为" + JSON.toJSONString (redis.getHashMap ("rmi", "port")));

        }

        logger.info ("开始工作");


    }
}
