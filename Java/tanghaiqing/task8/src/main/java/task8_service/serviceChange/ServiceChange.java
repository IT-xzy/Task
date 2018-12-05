package task8_service.serviceChange;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import task8_service.service.JobService;

import java.util.Random;


public class ServiceChange{
    private static Logger logger = Logger.getLogger(ServiceChange.class);
    //private T t;
    //    //初始化ApplicationContext
    private static ApplicationContext context;

    static {
        if (context == null) {
            logger.info("初始化ApplicationContext");
            context = new ClassPathXmlApplicationContext("spring-servlet.xml");
        }
    }

    public static Object getObjService(String s) {
        logger.info("进入JobServiceChange.getObjService....");
        Object obj = null;
        Random random = new Random();
        int i = random.nextInt(2);
        if (i == 1) {
            logger.info("加载1号端口的service");
            try {
                //String s1=null;
                //s1.toLowerCase();
                obj = context.getBean(s);
            } catch (Exception e) {
                logger.error("1号端口service出现问题，转到2号端口");
                e.printStackTrace();
                obj = context.getBean(s + "-2");
            }

        } else {
            try {
                logger.info("加载2号端口的service");
                obj = context.getBean(s + "-2");
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("2号端口service出现问题，转到1号端口");
                obj = context.getBean(s);
            }
        }
        return obj;
    }

    public static void main(String[] args) {

            Thread t1 =new Thread(){
                @Override
                public void run() {
                    JobService jobService =(JobService)ServiceChange.getObjService("jobService");
                    for (int i=0;i<10;i++){
                        jobService.queryService("后端开发");
                    }
                }
            };
            Thread t2 =new Thread(){
                @Override
                public void run() {
                    JobService jobService =(JobService)ServiceChange.getObjService("jobService");
                    for (int i=0;i<10;i++){
                        jobService.queryService("前端开发");
                    }
                }
            };
            t1.start();t2.start();
    }

    //public T getT(String s) {
    //    logger.info("进入JobServiceChange.getJobService....");
    //
    //    Random random = new Random();
    //    int i = random.nextInt(2);
    //    if (i == 1) {
    //        logger.info("加载1号端口的service");
    //        try {
    //            t = (T) context.getBean(s);
    //        } catch (Exception e) {
    //            logger.error("1号端口service出现问题，转到2号端口");
    //            e.printStackTrace();
    //            t = (T) context.getBean(s + "-2");
    //        }
    //
    //    } else {
    //        try {
    //            logger.info("加载2号端口的service");
    //            t = (T) context.getBean(s + "-2");
    //        } catch (Exception e) {
    //            e.printStackTrace();
    //            logger.error("2号端口service出现问题，转到1号端口");
    //            t = (T) context.getBean(s);
    //        }
    //    }
    //    return t;
    //}


}
