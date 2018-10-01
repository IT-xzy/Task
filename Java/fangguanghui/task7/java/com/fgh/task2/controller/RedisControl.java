package com.fgh.task2.controller;

import com.fgh.task2.model.User;
import com.fgh.task2.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "redis")
public class RedisControl {

    @Autowired
    UserService userService;

    Logger logger=LoggerFactory.getLogger(RedisControl.class);

    @RequestMapping(path = "/user/{id}",method = RequestMethod.GET)
    public Object quaryById(@PathVariable int id){
        try{
        User user=userService.findUserById(id);
        return user;
        }catch (Exception e){
            return false;
        }
    }
    @RequestMapping (path = "/user",method = RequestMethod.PUT)
    public Boolean update(@RequestBody User user)throws  Exception{
        logger.debug("是否跟新");
        Boolean updateFlag=userService.updateUser(user);
        return updateFlag;
    }
    @RequestMapping (path = "user/{id}",method = RequestMethod.DELETE)
    public Boolean del(@PathVariable int id)throws  Exception{
        Boolean delFlag=userService.delUser(id);
        return delFlag;
    }
    @RequestMapping (path = "/newuser",method = RequestMethod.POST)
    public  Integer insert(@RequestBody User user)throws  Exception{
        Integer insertFlag=userService.insertUser(user);
        return insertFlag;
    }
    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<User> getAll()throws Exception{
        return userService.findAll();
    }
}
