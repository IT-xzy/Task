package com.xiaobo.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.xiaobo.demo.service.UserService;
import com.xiaobo.demo.dto.User;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("MeTA_INF/applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");
//        userService.getAll();
//        userService.getUserById(3);
        User user = new User();
        user.setName("王二麻子");
        user.setHope("麻婆豆腐");
        userService.addUser(user);
        userService.deleteUser(17);
//        userService.updateUser();

    }
}
