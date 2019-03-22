package com.xiaobo.demo;

import com.xiaobo.demo.pojo.User;
import com.xiaobo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class App {
    @Autowired
    private  UserService userService;
    private static Logger log =Logger.getLogger(App.class);
    public static void main(String[] args) {

      ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/dispatcher-servlet.xml");
        UserService userService = context.getBean(UserService.class);

        log.info("获取所有用户");
        User user = new User();
        user.setId(new Long(6));
        Map<String,Object> pageData = new HashMap<>();
        pageData.put("offset",0);
        pageData.put("limit",1000000);
        List<User> userList = userService.getList(user,pageData);
        log.info(userList);
    }
}
