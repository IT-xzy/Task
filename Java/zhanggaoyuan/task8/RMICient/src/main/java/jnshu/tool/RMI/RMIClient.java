package jnshu.tool.RMI;

import com.alibaba.fastjson.JSON;
import jnshu.service.ProfessionService;
import jnshu.service.StudentService;
import jnshu.tool.redis.Redis;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Random;

public class RMIClient {
    private static Logger logger = Logger.getLogger (RMIClient.class);

    StudentService studentService;
    ProfessionService professionService;
    static ApplicationContext contextRedis = new ClassPathXmlApplicationContext ("spring-redis.xml");


    public static RMIClient server() {

        Redis redis = (Redis) contextRedis.getBean ("redis");

        logger.info ("进入server（）方法_________________________________");
        List list = (List) redis.getHashMap ("rmi", "port");
        logger.info ("缓存取出来的list为：" + JSON.toJSONString (list));

        if (list == null && list.size () == 0) {
            return null;
        }
        Random ra = new Random ();
        int rl = ra.nextInt (list.size ());
        String port = (String) list.get (rl);

        logger.info ("__________________");

        logger.info ("随机数为" + rl + "," +
                "使用的端口为" + port);

//        获取客户端

        ApplicationContext context;
        RMIClient rmiClient;

        try {
            context = new ClassPathXmlApplicationContext ("spring-RMI-" + port + ".xml");
            rmiClient = (RMIClient) context.getBean ("RMIClient");
            return rmiClient;
        } catch ( Exception e
                ) {
            logger.info ("端口号为" + port + "的server挂了" + e.getMessage ());

            list.removeIf (s -> s.equals (port));
            logger.info ("移除后的结果为：" + JSON.toJSONString (list));
            redis.setHashMap ("rmi", "port", list);
            //递归运行
            RMIClient.server ();
        }
        return null;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public ProfessionService getProfessionService() {
        return professionService;
    }

    public void setProfessionService(ProfessionService professionService) {
        this.professionService = professionService;
    }
}
