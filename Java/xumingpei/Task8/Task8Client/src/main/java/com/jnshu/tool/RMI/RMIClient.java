package com.jnshu.tool.RMI;

import com.alibaba.fastjson.JSON;
import com.jnshu.service.JobService;
import com.jnshu.service.StudentService;
import com.jnshu.service.UserService;
import com.jnshu.tool.redis.Redis;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Random;

public class RMIClient {


    JobService jobService;
    StudentService studentService;
    UserService userService;

    private static Logger logger = Logger.getLogger(RMIClient.class);

    public JobService getJobService() {
        return jobService;
    }

    public void setJobService(JobService jobService) {
        this.jobService = jobService;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    static ApplicationContext contextRedis = new ClassPathXmlApplicationContext("spring-redis.xml");

    public static RMIClient server() {

        Redis redis = (Redis) contextRedis.getBean ("redis");
        logger.info ("进入server方法");
        List list = (List) redis.getObj ("rmi", "port");
        logger.info ("缓存list：" + JSON.toJSONString (list));
        if (list == null || list.size () == 0) {
            return null;
        }
        Random random = new Random ();
        int rs = random.nextInt (list.size ());
        String port = (String) list.get (rs);
        logger.info ("随机数为" + rs + "," +
                "使用的端口为" + port);

        //获取客户端
        ApplicationContext context;
        RMIClient rmiClient;

        try {
            context = new ClassPathXmlApplicationContext ("spring-rmi-" + port + ".xml");
            rmiClient = (RMIClient) context.getBean ("RMIClient");
            return rmiClient;
        } catch ( Exception e
                ) {
            logger.info ("端口号为" + port + "的server挂了" + e.getMessage ());
            list.removeIf (s -> s.equals (port));
            logger.info ("移除后的结果为：" + JSON.toJSONString (list));
            redis.addObj("rmi", "port", list);
            //递归运行
            RMIClient.server ();
        }
        return null;
    }


}
