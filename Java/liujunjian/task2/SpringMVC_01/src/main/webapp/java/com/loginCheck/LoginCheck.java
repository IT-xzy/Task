package com.loginCheck;

import com.service.UserDaoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoginCheck {

    public static String check(String username, String password) throws Exception{
        ApplicationContext context=
                new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        UserDaoService userDaoService=context.getBean(UserDaoService.class);
        if (userDaoService.findAdministrator(username, password) != null) {
            return userDaoService.findAdministrator(username, password).getUsername();
        } else {
            return "";
        }
    }
}
