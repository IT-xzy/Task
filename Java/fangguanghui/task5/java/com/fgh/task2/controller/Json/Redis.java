package com.fgh.task2.controller.Json;

import com.fgh.task2.Utils.RedisUtils;
import com.fgh.task2.model.User;
import com.fgh.task2.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//@RestController
//public class Redis {
//    @Autowired
//    private RedisUtils redisUtils;
//    @Resource
//    private UserService userService;
//
//    Logger logger=LoggerFactory.getLogger( RedisUtils.class);
//
//    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
//    public Object quaryById(@PathVariable int id)throws Exception{
//        logger.debug("进入方法");
//        String s_id = String.valueOf(id);
//        User user=userService.findUserById(id);
//        logger.info(s_id + "--------" + user);
//
//        try{
//         Boolean flag=redisUtils.add(s_id,user);
//            if (flag){
//                logger.debug("缓存成功");
//                logger.debug("缓存:"+redisUtils.getkey(s_id));
//            }else{
//                logger.debug("缓存失败");
//            }
//        }
//        catch (Exception e){
//            System.out.println("错误  "+ e);
//        }
//
//       return user;
//    }
//    @RequestMapping (path = "/user",method = RequestMethod.PUT)
//    public Boolean update(@RequestBody User user)throws  Exception{
//        logger.debug("是否跟新");
//        Boolean updateFlag=userService.updateUser(user);
//        return updateFlag;
//    }
//    @RequestMapping (path = "//user/{id}",method = RequestMethod.DELETE)
//    public Boolean del(@PathVariable int id)throws  Exception{
//        Boolean delFlag=userService.delUser(id);
//        return delFlag;
//    }
//    @RequestMapping (path = "/newuser",method = RequestMethod.POST)
//    public  Integer insert(@RequestBody User user)throws  Exception{
//        Integer insertFlag=userService.insertUser(user);
//        return insertFlag;
//    }
//    @RequestMapping(value = "",method = RequestMethod.GET)
//    public List<User> getAll()throws Exception{
//        return userService.findAll();
//    }
//}
