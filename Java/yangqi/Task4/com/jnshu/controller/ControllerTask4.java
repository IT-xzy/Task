package com.jnshu.controller;



import com.jnshu.DES.DESUtil;
import test.CharacterUtils;
import com.jnshu.entity.profession;
import com.jnshu.entity.student;
import com.jnshu.entity.user;
import com.jnshu.service.StudentService;


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
@RequestMapping("/user")
public class ControllerTask4 {





    private static final Charset CHARSET = Charset.forName("gb2312");
    private static Logger logger = LoggerFactory.getLogger(ControllerTask4.class);

    @Autowired
    private StudentService studentService;


    //登陆拦截
    @RequestMapping("/login")
    public String toLoginPage(){
        System.out.println("--------------+++++++++--------------");
        return "login";
    }
    //home
    @RequestMapping("home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        List<student> stu = studentService.findAll();
        modelAndView.addObject("stu", stu);
        modelAndView.setViewName("home");
        return modelAndView;

    }
    //profession
    @RequestMapping("/u/profession")
    public ModelAndView home2(){
        ModelAndView modelAndView = new ModelAndView();
        List<profession> pro = studentService.findAlls();
        modelAndView.addObject("pro",pro);
        modelAndView.setViewName("profession");
        return modelAndView;
    }


    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public ModelAndView Login(HttpServletRequest request, HttpServletResponse response, @Param("name")String name, @Param("password")String password, user user, String Password1, String salt, Model model)throws Exception {
        System.out.println("---------------------------------------------------------------------");
        ModelAndView mav = new ModelAndView();
        user loginResult = studentService.login(name);
        System.out.println(name);
        try {
            Password1 = DESUtil.decrypt(loginResult.getDespwd(), CHARSET, loginResult.getSalt());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        if (loginResult != null && Password1.equals(password) && loginResult.getName().equals(name)) {
            //保存到cookies
            Cookie cookie = new Cookie("password", Password1);
            Cookie cookie1 = new Cookie("name", name);
            //对cookies进行设置
            cookie.setMaxAge(60);
            cookie1.setMaxAge(60);
            cookie.setPath("/");
            cookie.setPath("/");
            //添加请求
            response.addCookie(cookie);
            response.addCookie(cookie1);
            mav.addObject("welcom", "学员:    " + name + "欢迎光临");
            mav.setViewName("home");
            return mav;//一个登录成功的页面 "redirect:/login"
        } else {
            mav.addObject("error", "用户名或者密码错误");
            mav.setViewName("login");
            return mav;
        }
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){return "test";}

    @RequestMapping(value = "/Register",method = RequestMethod.POST)
    //ModelAndView可以换成String 但是没有传值功能
    public ModelAndView Register(@Param("name")String name,@Param("password")String password,user user,Model model)throws Exception{
        user loginResult = studentService.login(name);

        if (!name.equals("") && !password.equals("")){

            if (loginResult !=null && loginResult.getName().equals(name)){
                ModelAndView mav = new ModelAndView();
                mav.addObject("exist","此用户已存在");
                mav.setViewName("test");
                return mav;
            }else {
                String salt = CharacterUtils.getRandomString2(8);//随机数
                System.out.println("-----------------------------" + salt);
                ModelAndView mav = new ModelAndView();
                //加密
                System.out.println(password);
                String Password = DESUtil.encrypt(password,CHARSET,salt);
                System.out.println(Password);
                user.setName(name);
                user.setPassword(password);
                user.setSalt(salt);
                user.setDespwd(Password);
                studentService.register(user);
                mav.addObject("error","注册成功");
                mav.setViewName("login");
                return mav;
            }
        }else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exist","请填写用户名密码");
            mav.setViewName("test");
            return mav;
        }
    }


   /* @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public String Login(@Param("name")String name,@Param("password")String password,user user,String Password1,String salt,Model model)throws Exception{
        System.out.println("---------------------------------------------------------------------");
        user loginResult = studentService.login(name);
        System.out.println(name);
        try {
            //解码
            Password1 =DESUtil.decrypt(loginResult.getDespwd(),CHARSET,loginResult.getSalt());
        }catch (Exception e1){
            e1.printStackTrace();
        }
        //登录信息的判断
        if (loginResult != null && Password1.equals(password) && loginResult.getName().equals(name)){
            return "home";
        }else {
            return "login";
        }
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        return "test";
    }

    @RequestMapping(value = "/Register",method = RequestMethod.POST)
    public String Register(@Param("name")String name,@Param("password")String password,user user,Model model)throws Exception{
        //随机数随机生成8额字节
        String salt = CharacterUtils.getRandomString2(8);
        System.out.println("---------------------------"+salt);
        //加密
        System.out.println(password);
        String Password = DESUtil.encrypt(password,CHARSET,salt);
        System.out.println(Password);
        user.setName(name);
        user.setPassword(password);
        user.setSalt(salt);
        user.setDespwd(Password);
        studentService.register(user);
        return "redirect:/user/login";
    }
*/
}



