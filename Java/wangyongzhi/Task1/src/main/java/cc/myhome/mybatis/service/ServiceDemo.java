package cc.myhome.mybatis.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

public class ServiceDemo {
    public static Logger logger = LogManager.getLogger(ServiceDemo.class);
    private static ApplicationContext cx = new ClassPathXmlApplicationContext("Spring-Mybatis.xml");

    @Autowired
    public static NetworkService service;

    public static void main(String[] args) {

        service.deleteById(25L);

    }
}
