package task2.aop;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import task2.service.UserService;

public class TestAop {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml" });
        UserService userService = (UserService) context.getBean("UserService");
        userService.login("111","111");
    }
}

