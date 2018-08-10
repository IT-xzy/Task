package com.jnshu.controller;


import com.jnshu.entity.User;
import com.jnshu.service.impl.MemcacheUserServiceImpl;
import com.jnshu.service.impl.RedisUserServiceImpl;
import com.jnshu.tools.Msg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StuController {

    @Autowired
    MemcacheUserServiceImpl userService;
    @Autowired
    RedisUserServiceImpl userService1;

    private static Logger log = LoggerFactory.getLogger(StuController.class);
    /*
     *  1、@ResponseBody令数据不会被解析，而是直接写入HTTP response body中
     *    （比如异步获取JSON数据就要用到这个）
     *  2、想要@ResponseBody正常工作，需要导入jackson包。这个
     *     包负责将对象转化为JSON字符串
     */

    @RequestMapping("/u/student")
    public Msg getUser() throws Exception {
        List<User> users = userService.getAllUser();
        return Msg.success().add("user",users);
    }

    @PostMapping(value = "/student",produces = "application/json;charset=utf-8;")
    public Msg saveUser(User user) throws Exception {
            userService.saveUser(user);
            return Msg.success().add("user",user);
    }

    @GetMapping("/student/{id}")
    public Msg getUserById(@PathVariable("id")Integer id) throws Exception {
       User user = userService.getUserById(id);
       if (user == null){
           return Msg.fail();
       }else {
           log.debug(user.toString());
           return Msg.success().add("user", user);
       }
    }

    @GetMapping("/student/r/{id}")
    public Msg getUserByIdR(@PathVariable("id")Integer id) throws Exception {
        User user = userService1.getUserById(id);
        log.debug(user.toString());
        return  Msg.success().add("user",user);
    }


    @PostMapping(value = "/student/{id}",produces ="application/json; charset=utf-8" )
    public Msg updateUser(@PathVariable Integer id,User user) throws Exception {
        userService.updateUser(id,user);
        return Msg.success().add("user",user);
    }

    @DeleteMapping("/student/{id}")
    public Msg deleteUserById(@PathVariable("id")int id) throws Exception {
        userService.deleteUser(id);
        return Msg.success();
    }
}

