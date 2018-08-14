//package com.fgh.task2.controller.JSON;
//
//import com.fgh.task2.model.User;
//import com.fgh.task2.service.UserServiceImplMemCache;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@RestController()
//@RequestMapping(path = "rest")
//public class CacheController {
//
//    @Autowired
//    UserServiceImplMemCache memCache;
//
//    Logger logger=LoggerFactory.getLogger(UserServiceImplMemCache.class);
//
//    @RequestMapping(path = "/user/{id}",method = RequestMethod.GET)
//    public Object quaryById(@PathVariable int id)throws Exception{
//        logger.error("通过id 查询用户");
//        User user=memCache.findUserById(id);
//        logger.error("查询结束");
//        return user;
//    }
//    @RequestMapping (path = "/user",method = RequestMethod.PUT)
//    public Boolean update(@RequestBody User user)throws  Exception{
//        logger.debug("是否跟新");
//        Boolean updateFlag=memCache.updateUser(user);
//        return updateFlag;
//    }
//    @RequestMapping (path = "user/{id}",method = RequestMethod.DELETE)
//    public Boolean del(@PathVariable int id)throws  Exception{
//        Boolean delFlag=memCache.delUser(id);
//        return delFlag;
//    }
//    @RequestMapping (path = "/newuser",method = RequestMethod.POST)
//    public  Integer insert(@RequestBody User user)throws  Exception{
//        Integer insertFlag=memCache.insertUser(user);
//        return insertFlag;
//    }
//    @RequestMapping(value = "",method = RequestMethod.GET)
//    public List<User> getAll()throws Exception{
//        return memCache.findAll();
//    }
//}
