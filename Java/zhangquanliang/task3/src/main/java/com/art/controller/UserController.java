package com.art.controller;

import com.art.pojo.Banner;
import com.art.pojo.User;
import com.art.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author suger
 * @date 2018/11/6 20:08
 */
@Controller
public class UserController {

    private static final Logger logger= LogManager.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @GetMapping(value = "a/u/user/{id}")
    @ResponseBody
    public Map<String,Object> getBanner(@PathVariable Integer id) {
        Map<String,Object> result = new HashMap<String, Object>();
        User user = userService.getUser(id);
        if (user!=null){
            result.put("message","查询成功");
            result.put("code",200);
            result.put("data",user);

        }else {
            result.put("message","查询失败");
            result.put("code",400);
            result.put("data","ID对应的数据为空");
        }
        return result;
    }

    // 查询 用户 列表
    @GetMapping(value = "/a/u/user")
    @ResponseBody
    public Map<String,Object> list(User user) {
        Map<String,Object> result = new HashMap<String, Object>();
        List<User> users = userService.getUser(user);
        logger.info(users);
        if (users!=null || users.isEmpty()){
            result.put("message","查询成功");
            result.put("code",200);
            result.put("data",users);

        }else {
            result.put("message","查询失败");
            result.put("code",400);
            result.put("data","找不到对应的users");
        }
        return result;
    }

    // 添加 用户
    @RequestMapping(value = "/a/u/user",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> saveUser(User user){
        Map<String,Object> result = new HashMap<String, Object>();

        logger.info(user);
        if (userService.insert(user)){
            result.put("code",200);
            result.put("message","添加成功");
        }else {
            result.put("code",400);
            result.put("message","添加失败");
        }
        return result;
    }

    // 删除 用户
    @RequestMapping(value = "/a/u/user/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object>  deleteUser(@PathVariable Integer id){
        Map<String,Object> result = new HashMap<String, Object>();
        logger.info(id);
        if(userService.delete(id)) {
            result.put("code", 200);
            result.put("message", "删除成功");
        }else {
            result.put("code", 400);
            result.put("message", "删除失败");
        }
        return result;
    }

    //更新 用户
    @RequestMapping(value = "/a/u/user/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> updateUser(@PathVariable Integer id, User user){
        Map<String,Object> result = new HashMap<String, Object>();
        logger.info(user);
        if (userService.update(user)){
            result.put("code", 200);
            result.put("message", "更新成功");
        }else {
            result.put("code", 400);
            result.put("message", "更新失败");
        }
        return result;
    }
}
