package com.controller;

import com.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.UserService;

/**
 * @Author qmz
 * @Description TODO
 * @Data 2018/6/23$ 16:04$
 **/
public class controller {

    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService=(UserService) ctx.getBean("userService");
        User user=new User();
        user.setName("乔");
        user.setQq(11111111);
        user.setType("java");
        userService.addUser(user);
        System.out.println(user.toString());
    }
}
