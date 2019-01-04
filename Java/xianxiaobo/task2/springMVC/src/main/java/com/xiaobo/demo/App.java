package com.xiaobo.demo;

import com.xiaobo.demo.entity.User;
import com.xiaobo.demo.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class App {
    @Autowired
    private UserService userService;
    private static Logger log = Logger.getLogger(App.class);

    public static void main(String[] args)
    {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-servlet.xml");
        UserService userService = context.getBean(UserService.class);

        log.info("获取所有用户");
//        log.info(userService.getAll());

        log.info("获取ID10417的用户信息");
        Integer id = 10417;
        log.info(userService.getUserById(id));

        log.info("新增用户");
        User user = new User();
        user.setName("王婆");
        user.setSex("2");
        user.setPhone("18578785689");
        Integer result = userService.addUser(user);
        log.info(result);
        log.info(user.getId());


        log.info("编辑用户");
        User user2 = new User();
        user2.setId(10417);
        user2.setName("李八");
        user2.setSex("2");
        user2.setPhone("18578895689");
        Boolean result2 = userService.updateUser(user2);
        log.info(result2);
    }
}
