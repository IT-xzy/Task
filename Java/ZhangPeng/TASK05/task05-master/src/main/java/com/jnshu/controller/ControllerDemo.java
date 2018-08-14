package com.jnshu.controller;

import com.jnshu.model.User;
import com.jnshu.model.UserCustom;
import com.jnshu.model.UserQv;
import com.jnshu.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController

public class ControllerDemo {
    @Autowired
    UserService userService;

    //查询所有对象
//    @RequestMapping("/")
//    public String indexStart() throws Exception {
//        return "redirect:/user";
//    }
//
//
//    @RequestMapping("/user")
//    public String index(Model model) throws Exception {
//        List<User> list = userService.findUserAll();
//        model.addAttribute(list);
//        return "index";
//    }
//
//    //插入数据
//    //显示所有
//    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
//    public String addUser(User user) throws Exception {
//        System.out.println(user.toString());
//        userService.insertUser(user);
//        return "redirect:/user";
//
//    }
//
//    //插入页面
//    @RequestMapping("/insertUser")
//    public String insertUser() throws Exception {
//        return "insert";
//    }
//
//    //修改数据
//    @RequestMapping("/zhang")
//    public String updateUser(User user) throws Exception {
//        userService.updateUser(user);
//
//        return "redirect:/user";
//    }
//
//    //修改页面
//    @RequestMapping("/updateUser")
//    public String updateUser(int id, Model model) throws Exception {
//        UserCustom user = userService.findUserById(id);
//        model.addAttribute("user", user);
//        return "zhang";
//    }
//
//    //删除页面
//    @RequestMapping("/delete")
//    public String cleanUser(Long id) throws Exception {
//        userService.deleteUser(id);
//        return "redirect:/user";
//    }
    /*api 版本 浏览器地址栏直接请求的都是GET方式
    api响应规则:
    json请求
       功能           返回类型(json格式)      url             动作
    获取用户pojo       UserQV              /api/userQv/{id} method=GET
    模糊搜索           <List>UserCustom    /api/search/     method=POST
    获取指定用户       UserCustom          /api/{id}        method=GET
    获取所有用户       <List>UserCustom    /api/list        method=GET
    删除指定用户       String              /api/{id}        method=DELTET
    插入用户          String              /api/            method=PUT
    更新用户          String              /api/{id}        method=POST
    key/value 请求
      功能           返回类型(json格式)      url                    动作
    模糊搜索          List<UserCustom>  /api/search/key         method=POST
    插入用户          String            /api/key                method=PUT
    更新用户          String            /api/key/{id}           method=POST*/
    @RequestMapping(value = "/test")

    //api 插入与更新 js页面
    public ModelAndView success() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("REST");
        return modelAndView;
    }

    //测试返回的数据格式
    @RequestMapping(value = "api/userQv/{id}", method = RequestMethod.GET)

    public UserQv getUserQv(@PathVariable Integer id) throws Exception {
        UserQv userQv = new UserQv();
        UserCustom userCustom = userService.findUserById(id);
        userQv.setUserCustom(userCustom);
        return userQv;
    }
  //模糊搜索 json
    @RequestMapping(value = "/api/search/", method = RequestMethod.POST)
    @ResponseBody
    public List<User> searchUser(@RequestBody UserQv userQv) throws Exception {
       // logger.debug("userQv: " + userQv.getUserCustom());
        return userService.findUserByCondition(userQv);
    }

    //模糊搜索 key/value
    @RequestMapping(value = "/api/search/key", method = RequestMethod.POST)
    @ResponseBody
    public List<User> searchUserKey(UserQv userQv) throws Exception {
        System.out.println("userQV: " + userQv.toString());
        return userService.findUserByCondition(userQv);
    }

    //json格式根据id输出单个用户数据
    @RequestMapping(value = "/api/{id}", method = RequestMethod.GET)
    @ResponseBody
    public UserCustom jsonUser(@PathVariable("id") int test) throws Exception {
        //logger.info("GET 获取数据中,获取id为" + test);
        return userService.findUserById(test);
    }

    //json格式输出所有用户数据
    @RequestMapping(value = "/api/list", method = RequestMethod.GET)
    @ResponseBody
    public List<User> jsonList() throws Exception {
      //  logger.info("GET 获取所有数据中");
        return userService.findUserAll();
    }

    //删除, 返回必须json格式 浏览器地址栏测试改为GET请求
    @RequestMapping(value = "/api/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean testDELETE(@PathVariable("id") int id) throws Exception {
        //logger.info("DELETE 删除执行中, id为:" + id);
        return userService.deleteUser(id);
    }

/*输出错误信息
    private String getString(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //输出错误信息
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            String Errors = "";
            for (ObjectError objectError : allErrors) {
                //输出错误信息
                Errors = Errors + objectError.getDefaultMessage().toString() + "\n";
            }
          //  logger.error(Errors);
            return Errors;
        }
        return null;
    }*/

    //插入数据 返回提示信息
    /* produces = "application/json; charset=utf-8" 解决json返回string乱码*/
    @RequestMapping(value = "/api/", method = RequestMethod.PUT, produces = "application/text; charset=utf-8")
    @ResponseBody()
    public String insertJson(@RequestBody  UserCustom userCustom) throws Exception {
        /* 效验输入信息 */
        //String Errors = getString(bindingResult);
       // if (Errors != null) return Errors;
      //  logger.info("PUT 插入数据执行中,传入对象值: " + userCustom.toString());
        userService.insertUser(userCustom);
        return "插入成功,id为:  " + userCustom.getId();
    }

    //插入数据 key/value
    @RequestMapping(value = "/api/key", method = RequestMethod.PUT, produces = "application/text; charset=utf-8")
    @ResponseBody
    public String insertKey( UserCustom userCustom, BindingResult bindingResult) throws Exception {
        /* 效验输入信息 */


       // logger.info("PUT 插入数据执行中,传入对象值: " + userCustom.toString());
        userService.insertUser(userCustom);
        return "插入成功,id为: " + userCustom.getId();
    }

    //更新数据 json
    @RequestMapping(value = "/api/{id}", method = RequestMethod.POST, produces = "application/text; charset=utf-8")
    @ResponseBody
    public String updateJson(@PathVariable("id") int id, UserCustom userCustom) throws Exception {
        /* 效验输入信息 */

        return id + "的更新状态: " + userService.updateUser(userCustom);
    }

    //更新数据 key/value
    @RequestMapping(value = "/api/key/{id}", method = RequestMethod.POST, produces = "application/text; charset=utf-8")
    @ResponseBody
    public String updateKey(@PathVariable("id") int id, UserCustom userCustom) throws Exception {
        /* 效验输入信息 */

        return id + "的更新状态: " + userService.updateUser(userCustom);
    }
}












