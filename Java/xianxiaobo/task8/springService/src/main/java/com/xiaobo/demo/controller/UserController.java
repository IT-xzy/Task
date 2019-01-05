package com.xiaobo.demo.controller;

import com.xiaobo.demo.pojo.User;
import com.xiaobo.demo.service.UserService;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.ConnectException;
import java.util.List;
import java.util.Random;

@RestController
public class UserController {
    @Autowired
    @Qualifier("UserService1")
    private RmiProxyFactoryBean factoryBean1;
//    @Autowired
//    @Qualifier("UserService2")
//    private RmiProxyFactoryBean factoryBean2;
    @GetMapping("/page")
    public List<User> getUserByPage(@RequestParam(value="page",required = false,defaultValue = "1")Integer page,
                                    @RequestParam(value = "size",required = false,defaultValue = "10")Integer size) {
        UserService userService;
        userService = (UserService)factoryBean1.getObject();
        return userService.getAllUser(page,size);
    }
//    @GetMapping(value = "user")
//    public User findUser(){
//        UserService userService;
//        Random random = new Random();
//
//        if(random.nextBoolean()){
//            try {
//                System.out.println("随机访问到service1,尝试使用service1");
//                userService = (UserService)factoryBean1.getObject();
//                System.out.println("userService"+userService);
//                return userService.selectByPrimaryKey(18);
//            }catch (Exception  e){
//                System.out.println("service1出异常，使用service2");
//                userService = (UserService)factoryBean2.getObject();
//                return userService.selectByPrimaryKey(18);
//            }
//        }else{
//            try {
//                System.out.println("随机访问到service2,尝试使用service2");
//                userService = (UserService)factoryBean2.getObject();
//                return userService.selectByPrimaryKey(18);
//            }catch (Exception  e){
//                System.out.println("service2出异常，使用service1");
//                userService = (UserService)factoryBean1.getObject();
//                return userService.selectByPrimaryKey(18);
//            }
//        }
//
//
//    }
    @GetMapping(value="test")
    public String test(){
        return "hello it's a test";
    }

}
