package com.xiaobo.demo.controller;


//import com.xiaobo.demo.entity.User;
import com.alibaba.fastjson.JSONObject;
import com.xiaobo.demo.entity.Message;
import com.xiaobo.demo.entity.Response;
import com.xiaobo.demo.entity.Result;
import com.xiaobo.demo.entity.User;
import com.xiaobo.demo.service.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/a")
public class UserController {
//    private static Logger log = Logger.getLogger(UserController.class);
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    User user;
    @Autowired
    Result result;
    @Autowired
    Message message;
//    @Autowired
//    Response response;
    @Autowired
    MessageSource messageSource;
    // 获取用户列表
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public Result userListPage() {
        return new Result(200,"success",userService.getAll());
    }
    //获取单个用户
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result userEditPage(@PathVariable("id") Integer id) {

        User user = userService.getUserById(id);
        String code = user != null?"200":"-100";
        String message =  messageSource.getMessage(code,null,null);
        System.out.println(message);
        return  new Result(Integer.parseInt(code),message,userService.getUserById(id));
    }
    //新增用户
    @RequestMapping(value = "/u/user", method = RequestMethod.POST, consumes={"application/json"},produces={"application/json"})
    @ResponseBody
    public Message userAddUserPage(@RequestBody User user) {
        String code;
        if(user.getName()!= null && user.getName().length() != 0){
            code = userService.addUser(user) == 1?"200":"-200";
        }else{
            code = "-300";
        }
        String message =  messageSource.getMessage(code,null,null);
        return  new Message(Integer.parseInt(code),message);
    }
    @RequestMapping(value = "/u/user/{id}", method = RequestMethod.PUT, consumes={"application/json"},produces={"application/json"})
    @ResponseBody
    public Message userUpdatePage(@PathVariable("id") Integer id,@RequestBody User user) {
        String code;
        if(user.getName()== null || user.getName().length() == 0){
            code = "-300";
        }else if(!(user.getId()>0)){
            code = "-400";
        }else{
            code = userService.updateUser(user)?"200":"-100";
        }
        String message =  messageSource.getMessage(code,null,null);
        return  new Message(Integer.parseInt(code),message);
    }
    @RequestMapping(value = "/u/user/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Message userDeletePage(@PathVariable("id") Integer id) {
        String code = userService.deleteUser(id)?"200":"-100";
        String message =  messageSource.getMessage(code,null,null);
        return new Message(Integer.parseInt(code),message);
    }
    @RequestMapping(value = "/u/user/batch", method = RequestMethod.DELETE)
    @ResponseBody
    public Message userDeletePage(@RequestParam("ids") String ids) {
        List<String> list = new ArrayList<>();
        String[] items = ids.split(",");
        Collections.addAll(list,items);
        Integer result = userService.batchDeleteUser(list);
        String code = result>0?"200":"-100";
        String message =  messageSource.getMessage(code,null,null);
        return new Message(Integer.parseInt(code),message);
    }
    //新增用户
//    @RequestMapping(value = "/user", method = RequestMethod.POST, consumes={"application/json"},produces={"application/json"})
//    @ResponseBody
//    public Result userAddUserPage(@RequestBody User user) {
//        JSONObject jo = new JSONObject();
//        JSONObject parseObject = jo.parseObject(param);
//        System.out.println(parseObject);
//        JSONObject responseObj = (JSONObject)JSONObject.toJSON(user);
//        User user = new User();
//        user.setName(name);
//        user.setSex(sex);
//        user.setPhone(phone);
//        userService.addUser(user);
//        Result result = new Result();
//        result.setCode(200);
//        result.setMessage("success");
////        result.setData("");
//        return result;
//    }
    // 获取用户列表
//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public ModelAndView userListPage() {
//        List<User> userList = userService.getAll();
//        return new ModelAndView("userList","data",userList);
//    }
    //  获取单个用户
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
//    public ModelAndView userEditPage(@PathVariable("id") Integer id) {
//        User user = userService.getUserById(id);
//        return new ModelAndView("userEdit","data",user);
//    }


//    @RequestMapping(value = "/add", method = RequestMethod.GET)
//    public ModelAndView userAddPage() {
//        return new ModelAndView("userAdd");
//    }
//
//    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
//    public String userUpdatePage(@PathVariable("id") Integer id, @RequestParam("name") String name, @RequestParam("sex") String sex, @RequestParam("phone") String phone) {
//        User user = new User();
//        user.setId(id);
//        user.setName(name);
//        user.setSex(sex);
//        user.setPhone(phone);
//        userService.updateUser(user);
//        return "redirect:/user/list";
//    }
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//    public String userDeletePage(@PathVariable("id") Integer id) {
//        userService.deleteUser(id);
//        return "redirect:/user/list";
//    }

}
