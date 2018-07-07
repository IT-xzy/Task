package com.jnshu.controller;


import com.jnshu.entity.Profession;
import com.jnshu.entity.Student;
import com.jnshu.entity.User;
import com.jnshu.service.ProfessionService;
import com.jnshu.service.StudentService;
import com.jnshu.service.userService;
import com.jnshu.util.MD5Util;
import com.jnshu.util.TokenUtil;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.util.List;

@Controller
@RequestMapping("")
public class ControllerTask5 {

    private static final Charset CHARSET = Charset.forName("gb2312");
    private static Logger logger = LoggerFactory.getLogger(ControllerTask5.class);

    @Autowired
     StudentService studentService;
    @Autowired
     ProfessionService professionService;
    @Autowired
     userService userService;


    @RequestMapping("/")
    public String logins(){
        return "redirect:/home";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String toLoginPage(){
        System.out.println("--------------+++++++++--------------");
        return "login";
    }

    @RequestMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> stu = studentService.findAll();
        modelAndView.addObject("stu", stu);
        modelAndView.setViewName("home");
        return modelAndView;
    }

    //Profession
    @RequestMapping("/u/profession")
    public ModelAndView home2(){
        ModelAndView modelAndView = new ModelAndView();
        List<Profession> pro = professionService.findAlls();
        modelAndView.addObject("pro",pro);
        modelAndView.setViewName("profession");
        return modelAndView;
    }

    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public String index(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        logger.info("进入controller方法");
        //获取数据姓名参数
        String name = httpServletRequest.getParameter("name");
        //获取数据里密码参数
        String password = httpServletRequest.getParameter("password");
        logger.info(name + password + "密码");
        //使用MD5工具类对密码进行加密
        String password1 = MD5Util.createPassword(password);
        logger.info(password1+"加密后密码");
        //查询数据表里的姓名 密码 进行比对 与这个jsp页面里输入的是否一致
        User user = userService.selectByuser(name,password1);
        logger.info(user + "123123");
        // 如果 这个数据表里 没有这些信息 则返回登录页面，否则就进入
        if (user == null) {
            logger.info("登陆失败");
            httpServletRequest.getSession().setAttribute("errorInfo", "用户名错误");
            return "redirect:login";
        } else {
            //加入登陆时间
            userService.updateTimeByid(user.getId());
            //重新读数据 ，拿出这个数据
            User user1 = userService.selectByuser(name,password1);

            logger.info(TokenUtil.genToken(user1.getId(), user1.getLandtime()));
            // 使用Token工具类来写入这个数据的id 和 登录时间
            String s_token = TokenUtil.genToken(user1.getId(), user1.getLandtime());
            logger.info(s_token + "token+++++++++");
            //创建一个新的token
            Cookie token = new Cookie("token", s_token);
            //响应写入token
            httpServletResponse.addCookie(token);
            logger.info("token");
            return "redirect:home";
        }
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
        Cookie[] cookies = httpServletRequest.getCookies();
        try
        {
            for(int i=0;i<cookies.length;i++)
            {
                //System.out.println(cookies[i].getName() + ":" + cookies[i].getValue());
                Cookie cookie = new Cookie(cookies[i].getName(), null);
                cookie.setMaxAge(0);
                httpServletResponse.addCookie(cookie);
            }
        }catch(Exception ex)
        {
            logger.info("清空Cookies发生异常！");
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){return "test";}


    @RequestMapping(value = "/Register",method = RequestMethod.POST)
    public String Register(@Param("name")String name, @Param("password")String password, User user, Model model)throws Exception{

        logger.info("进入注册页面");
        logger.info("前台传来信息:" +user.toString());
        User user1 = userService.findUserByname(user.getName());
        if (user1 != null){
            logger.info("已经存在用户");
            return "test";
        }else {
            logger.info("开始注册");
            //给用户名加盐
            String salt = user.getName();
            //对密码加盐和MD5加密
            String password1 = MD5Util.createPassword(password);
            logger.info("加密加盐后的密码" + password1);
            user.setPassword(password1);
            user.setSalt(salt);
            userService.regist(user);
            logger.info("注册信息是:" + user);
            return "redirect:/login";
        }
    }
}
