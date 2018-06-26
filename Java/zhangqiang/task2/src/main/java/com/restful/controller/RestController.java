package com.restful.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.restful.model.Page;
import com.restful.model.User;
import com.restful.service.StudentServiceImpl;
import com.restful.service.UserServiceImpl;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/urg")
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath*:springmybatis.xml"})
public class RestController {

    private Logger logger = Logger.getLogger(RestController.class.getName());
    private String message = "可能遇到点问题…";
    private final String SUCCESS = "success";

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springmybatis.xml");
    UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("userService");
    String mseeage = "似乎遇到点问题……";
    String info = "信息";



    //    根据姓名查询，跳转到user页面
    @RequestMapping(value = "/user/{name}",method = RequestMethod.POST)
    public ModelAndView getStudentForName(@RequestParam("name")String name, ModelAndView modelAndView ){

        logger.info("\n 输入的查询：" + name + "\n");

        User user = new User();
        user.setName(name);
        List<User> users = userService.findByUser(user);

        modelAndView.addObject("users",users);
        modelAndView.setViewName("/userlist");

        return modelAndView;
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String updre(@RequestParam("id")Integer id,Model model){
        logger.info("跳转upd修改页面,修改id："+id);
        User user = userService.findById(id);
        user.setId(id);
        model.addAttribute("upduser",user);
        return "upd";
    }

//    @ResponseBody
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public ModelAndView upd(User user,ModelAndView modelAndView){
        logger.info("修改的数据："+user);
        message = "修改失败";
        if(user!=null){
            if(userService.updateOne(user)!=0){
                message = "修改成功！";
                info = "修改信息";
                modelAndView.addObject("reguser",user);
            }
        }
        modelAndView.addObject("message",message);
        modelAndView.addObject("info",info);
        modelAndView.setViewName("redirect:user/usereditinfo");
        return modelAndView;
    }


    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String del(@RequestParam("id")Integer id,Model model){
        logger.info("删除id："+id);
        int del = userService.deleteOne(id);
        info="删除信息";
        if(del!=0) {
            message = "删除成功";
        }else {
            message = "删除失败";
        }
        model.addAttribute("message",message);
        return "redirect:list";
    }

    @ResponseBody
    @RequestMapping(value = "/user/json",method = RequestMethod.GET)
    public ModelAndView jsonlist(@RequestParam(value = "jsonname",required = false)String name,ModelAndView modelAndView){
        logger.info("json 传入的name：" + name );
        User user = new User();
        if(name!=null && name!=""){
            user.setName(name);
            List<User> users = userService.findByUser(user);
            logger.info("查询到的users：" + users + "users的size：" + users.size());
            boolean flag = users.size()==0;
            logger.info(flag);
            if( users.size()==0 ){
                message = "查询失败";
            }else {
                //json字符串
                String usersJsonStr = JSON.toJSONString(users);
                //json对象
                JSON usersJson = (JSON) JSON.toJSON(users);
                message = "查询成功";
                modelAndView.addObject("usersJsonStr",usersJsonStr);
                modelAndView.addObject("usersJson",usersJson);
                logger.info(usersJsonStr);
            }
        }else {
            //前台已经检查是否为空，后台信息
            message = "查询姓名不能为空";
        }
        modelAndView.setViewName("jsonlist");
        modelAndView.addObject("message",message);
        return modelAndView;

    }

    @RequestMapping(value = "/user/list")
    public String userList(@RequestParam(value = "nowpage",defaultValue = "1")Integer nowpage,
                           @RequestParam(value = "pagesize",defaultValue = "5")Integer pagesize,Model model){

        Page<User> page = userService.findByPage(nowpage,pagesize);
        model.addAttribute("nowPages",page);
        return "list";
    }

    @RequestMapping(value = "/user/reg")
    public String reg(){
        logger.info("跳转reg注册页面");
        return "reg";
    }

    @RequestMapping(value = "/user/reg",method = RequestMethod.POST)
    public String reg(Model model,User user){
        logger.info("注册的参数："+user.toString());
        int ids = userService.insertOne(user);
        if(ids!=0){
            message = "注册成功！";
            model.addAttribute("reguser",user);
        }
        model.addAttribute("message",message);
        return "userlist";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam("name")String name, @RequestParam("pwd")String pwd, HttpSession httpSession, Model model){

        User user = new User();
        user.setName(name);
        user.setPwd(pwd);
        logger.info("登录信息："+user.toString());
        info = "登录信息";
        message = "没有登陆信息！登录失败";
        List<User> users = userService.findByUser(user);
        if(users.size()!=0){
            for(User us : users){
                logger.info("查询匹配信息：" + us.toString());
                if(us.getName().equals(name) && us.getPwd().equals(pwd)){
                    logger.info("正确匹配的："+us.getName()+":"+us.getPwd()+" | ");
                    message = "登陆成功！";
                    httpSession.setAttribute("username",name);
                    model.addAttribute("reguser",us);
                }else {
                    logger.info("未匹配的："+us.getName()+":"+us.getPwd()+" | ");
                    message = "登陆失败！";
                }
            }
        }else {
            mseeage = "账号密码错误，登录失败！";
        }
        model.addAttribute("message",message);

        return "userlist";
    }

    //测试redirect:user/usereditinfo  跳转userlist 只有修改方法upd() 调用
    @RequestMapping(value = "user/usereditinfo")
    public String userlist(@RequestParam(value = "message",required = false)String message,
                           @RequestParam(value = "info",required = false)String info,Model model){
        model.addAttribute("message",message);
        model.addAttribute("info",info);
        return "userlist";
    }

//      测试
//    @RequestMapping("/login")
//    public String logOut(HttpSession httpSession){
//        httpSession.invalidate();
//        return "forward:list";
//    }

//      测试
//    @RequestMapping(value = "/jgg")
//    public String jgg(){
//        logger.info("跳转jgg");
//        return "jgg";
//    }







}
