package task9.pojo;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestRMI {
    private static Logger logger =Logger.getLogger(TestRMI.class);
    public static void main(String[] args) {
        System.out.println("正在启动！！！！");
        try {
            new ClassPathXmlApplicationContext("spring-servlet.xml");
            System.out.println("启动完成！！！！！");
        }catch (Exception e){
            logger.info("启动webService出现错误");
            e.printStackTrace();
        }


    }
}
