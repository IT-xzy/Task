package jnshu.tool.Tuscany;

import com.alibaba.fastjson.JSON;
import jnshu.tool.redis.Redis;
import org.apache.log4j.Logger;
import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

public class StartTuscany {
    private static Logger logger = Logger.getLogger (String.valueOf (StartTuscany.class));

    public static void main(String[] args) {

        Node node = NodeFactory.newInstance ().createNode (
                "task9_tuscany.composite");
        node.start ();

        String port = "1023";
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

