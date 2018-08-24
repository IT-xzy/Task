package com.fgh.task2.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fgh.task2.model.User;
import com.fgh.task2.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;




/*
URL 规范
路径中不能有动词，只能有名词
使用-而不是_
首选小写字母
URL路径名词均为复数
*/

@Controller
@RequestMapping(path = "users")
public class UserController {
    private static Logger logger = LogManager.getLogger(UserController.class.getName());
    @Autowired
    private UserService userService;

    /**
     * 获取所有用户列表
     * @param  model
     * @return /allUser
     *
     */
    @RequestMapping(path = "",method =RequestMethod.GET )
    public String getAllUser( Model model) throws Exception {
        List<User> user = userService.findAll();
        model.addAttribute("userList", user);
        return "/allUser";
    }

    /**
     * 编辑用户
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(path = "/user",method = RequestMethod.PUT)
    public String updateUser(User user, Model model) throws Exception {
        logger.debug("-------------执行更新操作-----------");
        if (userService.updateUser(user)) {
            user = userService.findUserById(user.getId());
            model.addAttribute("user", user);
            return "redirect:/users";
        } else {
            logger.debug("更新失败");
            return "/error";
        }
    }

    /**
     * 通过ID查询用户
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(path = "user/{id}",method = RequestMethod.GET)
    public String getUser(@PathVariable int id, Model model,User user) throws Exception {
        user = userService.findUserById(id);
        model.addAttribute("userby", user);
        return "/editUser";
    }
    /**
     *跳转添加用户页面
     * @return
     */
    @RequestMapping("/user/new")
    public String toAddUser()throws Exception{
        return "addUser";
    }
    /**
     *添加用户
     * @param  user
     * @return
     */
    @RequestMapping(path = "newuser",method = RequestMethod.POST)
    public String addUser(User user)throws Exception{
            Integer A=userService.insertUser(user);
            logger.debug(A);
        return "redirect:/users";
    }

    /**
     *删除用户
     * @param  id
     *         用户id
     * @return
     */

    @RequestMapping(path = "/user/{id}",method = RequestMethod.DELETE)
    public Boolean del(@PathVariable int id) throws Exception {
        return userService.delUser(id);
    }

    /**
     *自定义查询
     * @param  finduser
     * @param  model
     * @return
     */
    @RequestMapping(value = "/name",method = RequestMethod.GET)
    public String findUserBy(User finduser, Model model, RedirectAttributes redirectAttributes)throws Exception{
            List<User> findUser =userService.findUserBy(finduser);
            redirectAttributes.addFlashAttribute("findUser",findUser);
            model.addAttribute("findUser",findUser);
            return "redirect:/users";
            }


    /**
     * json taglib 测试
     * @param
     * @param
     * @param
     * @return
     * @throws Exception
     */

    @RequestMapping(value = "/userJson",produces = "application/json;charset=utf8")
    public String userJson()throws Exception{
        ObjectMapper mapper=new ObjectMapper();
        try{
            return
                    mapper.writeValueAsString(userService.findAll());
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }


}




