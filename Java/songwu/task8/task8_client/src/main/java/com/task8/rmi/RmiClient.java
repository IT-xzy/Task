package com.task8.rmi;

import com.task8.pojo.Person;
import com.task8.service.LoginService;
import com.task8.service.ProfessionService;
import com.task8.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Create by SongWu on 2018/8/14
 */
public class RmiClient {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext-rmi-a.xml");
        LoginService loginService = context.getBean("myRMIClient1-1", LoginService.class);
        Person person = new Person("qwerty", "qwerty");
        System.out.println(loginService.loginForm(person));
        UserService userService = context.getBean("myRMIClient2-1",UserService.class);

        System.out.println(userService.selectAll());
        ProfessionService professionService = context.getBean("myRMIClient3-1", ProfessionService.class);
        System.out.println(professionService.selectProfession());
    }
}
