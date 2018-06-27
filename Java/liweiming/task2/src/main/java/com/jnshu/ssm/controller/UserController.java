package com.jnshu.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jnshu.ssm.entities.User;
import com.jnshu.ssm.service.UserServiceImpl;
import com.jnshu.ssm.tools.Msg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class UserController {

    @Autowired
    UserServiceImpl userService;

    private static Logger log = LoggerFactory.getLogger(UserController.class);
    /*
     *  1、@ResponseBody令数据不会被解析，而是直接写入HTTP response body中
     *    （比如异步获取JSON数据就要用到这个）
     *  2、想要@ResponseBody正常工作，需要导入jackson包。这个
     *     包负责将对象转化为JSON字符串
     */

    @RequestMapping("/student")
    @ResponseBody
    public Msg getUser(@RequestParam(value = "pn",defaultValue = "1") int pn) throws Exception {
//        使用分页插件，pn 当前查询页数、 5 每页显示几条
        PageHelper.startPage(pn,5);

//        后面的查询语句就可以实现分页查询
        List<User> users = userService.getAllUser();

//        将查询的结果封装到PageInfo对象中，5表示 导航栏的数目 5
        PageInfo info = new PageInfo(users,5);

        return Msg.success().add("pageInfo",info);
    }

    @PostMapping(value = "/student",produces = "application/json;charset=utf-8;")
    @ResponseBody
    public Msg saveUser(@Validated User user,BindingResult result,HttpServletResponse response) throws Exception {
        if (result.hasErrors()){
//            校验失败，需要返回失败，在模态框中显示校验失败的错误信息，遍历错误信息
//            封装map，用于放回错误信息
            Map<String ,Object> map = new HashMap<>();
            List<FieldError> errors = result.getFieldErrors();

            for (FieldError fieldError:errors){
                System.out.println("错误的字段" + fieldError.getField());
                System.out.println("错误信息"+ fieldError.getDefaultMessage());
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields",map);
        }else {
            userService.saveUser(user);
            return Msg.success().add("user",user);
        }
    }

   @ResponseBody
    @GetMapping("/student/{id}")
    public Msg getUserById(@PathVariable("id")Integer id) throws Exception {
       User user = userService.getUserById(id);
       log.debug(user.toString());
       return  Msg.success().add("user",user);
    }


    @ResponseBody
    @PostMapping("/student/{id}")
    public Msg updateUser(@PathVariable Integer id,User user) throws Exception {


        userService.updateUser(id,user);

        return Msg.success().add("user",user);
    }

    @ResponseBody
    @DeleteMapping("/student/{id}")
    public Msg deleteUserById(@PathVariable("id")int id) throws Exception {
        userService.deleteUser(id);
        return Msg.success();
    }
}

