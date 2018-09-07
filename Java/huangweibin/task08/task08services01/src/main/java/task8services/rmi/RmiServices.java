package task8services.rmi;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class RmiServices {
    private static final Log LOGGER = LogFactory.getLog(RmiServices.class);
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        new ClassPathXmlApplicationContext("spring/spring-rmicontext.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-rmicontext.xml");
        context.getBean("serverTest");
        LOGGER.info("SUCCESS!");

    }

}
