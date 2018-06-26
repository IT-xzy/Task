package com.fgh.task2.controller;

import com.fgh.task2.model.User;
import com.fgh.task2.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class JSONController {
    @Autowired
    private UserService userService;

    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);


    /**
     * 查询全部用户
     */
  @RequestMapping(value = "",method = RequestMethod.GET)
  public List<User> getAll()throws Exception{
      return userService.findAll();
  }

    /**
     * 更新用户
     */
    @RequestMapping(path = "user",method = RequestMethod.PUT,produces = "application/json;charset=utf-8")
    public String updateUser( @RequestBody User user) throws Exception {
            Boolean updateUser = userService.updateUser(user);
            return "完成更新："+updateUser+"\n"+user.getId();
        }


    /**
     * 通过id查询用户
     */
    @RequestMapping(path = "user/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable int id, User user) throws Exception {
        user = userService.findUserById(id);
        logger.debug(user);
        return user;
    }
//
//
    /**
     *添加用户
     * @param  user
     * @return
     */
    @RequestMapping(path = "user",method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    public String addUser( @RequestBody User user)throws Exception{
        Boolean addUser=userService.insertUser(user);
        return "完成添加："+addUser+"\n"+user.getId();
    }

    /**
     *删除用户
     * @param  id
     * @return
     */
    @RequestMapping(path = "user/{id}",method = RequestMethod.DELETE)
    public Boolean del(@PathVariable int id) throws Exception {
        return userService.delUser(id);
    }
//
//    /**
//     *自定义查询
//     * @param  finduser
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/findUser",method = RequestMethod.GET)
//    public List<User> findUserBy(User finduser)throws Exception{
//        List<User> findUser =userService.findUserBy(finduser);
//        return findUser;
//    }
}
