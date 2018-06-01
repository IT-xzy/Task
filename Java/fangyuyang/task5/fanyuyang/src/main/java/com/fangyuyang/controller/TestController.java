package com.fangyuyang.controller;

import com.fangyuyang.model.Career;
import com.fangyuyang.model.User;
import com.fangyuyang.service.CareerService;
import com.fangyuyang.service.UserService;
import com.fangyuyang.subsidiary.CookieCheck;
import com.fangyuyang.subsidiary.encrption.DES;
import com.fangyuyang.subsidiary.LoginInterceptor;
import com.fangyuyang.subsidiary.encrption.Encript;
import com.fangyuyang.subsidiary.encrption.MD5;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.command.BinaryCommandFactory;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.utils.AddrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.IIOException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeoutException;

@Controller
public class TestController {
   int loginModel = 0;
    @Autowired
    private CareerService careerService;
    @Autowired
    private UserService userService;
    @RequestMapping("/")
    public String index( Model model) throws InterruptedException, MemcachedException, TimeoutException, IOException {
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        Logger logger = LoggerFactory.getLogger(TestController.class);
        int allId = userService.countAll();
        Random randomUser = new Random();
        logger.info("user数据库总数,{}",allId);
        int pictureId = randomUser.nextInt(allId-3);
        logger.info("pId,{}",pictureId);
        User user = new User();//user类
        String memString1 = String.valueOf(pictureId);
        String memString2 = String.valueOf(pictureId+1);
        String memString3 = String.valueOf(pictureId+2);
        String memString4 = String.valueOf(pictureId+3);
        logger.info("1,{},2,{},3,{},4,{}",userService.findUserById(pictureId).getName(),
                userService.findUserById(pictureId+1).getName(),userService.findUserById(pictureId+2).getName(),
                userService.findUserById(pictureId+3).getName());
            model.addAttribute("hasLogin",loginModel);
            model.addAttribute("learner1",userService.memCacheGet(memString1));
        model.addAttribute("learner2",userService.memCacheGet(memString2));
       model.addAttribute("learner3",userService.memCacheGet(memString3));
       model.addAttribute("learner4",userService.memCacheGet(memString4));
        model.addAttribute("sum",allId);
        loginModel = 0 ;
        return  "index";
    }
    @RequestMapping("/sign")
    public String signUser(User user) {
        return "sign";
    }
    @RequestMapping("/doSign")
    public String doSignUser(HttpServletRequest request, HttpServletResponse response, User user, Model model,String passwordString) {
        Encript encript = new Encript();
        encript.encript(user.getName(),response);//DES加密，cookie使用
        String result = MD5.generate(passwordString);
        user.setPassword(result);//加密输入数据库
        loginModel = 1 ;
        return "signer";
    }
    @RequestMapping("/login")
    public String loginUser(HttpServletRequest request,
                            HttpServletResponse response,User user) {
        loginModel = 1;
        return "redirect:/";
    }
    @RequestMapping("/dologin")
    public String doLoginUser(HttpServletRequest request, HttpServletResponse response,String name,String passwordString) {
        Logger logger = LoggerFactory.getLogger(TestController.class);
        Encript encript = new Encript();
        if(!MD5.verify(passwordString,userService.findByName(name).getPassword()) ){

            logger.info("password :{}",userService.findByName(name).getPassword());
                   return "loginfailer";
               }
       encript.encript(name,response);//DES加密，cookie使用
        return "redirect:/loginer";
    }
    @RequestMapping("/quit")
    public String quit(HttpServletRequest request,HttpServletResponse response){
        CookieCheck cookieCheck = new CookieCheck();
        cookieCheck.deleteCookie(request,response);
        loginModel = 0 ;
        return "redirect:/";
    }
    @RequestMapping("/loginer")
    public String loginer(){
        loginModel = 1 ;
        return "redirect:/";
    }
    @RequestMapping("/t11")
    public String Career(HttpServletRequest request,
                         HttpServletResponse response,User user, Model model) {
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        Logger logger = LoggerFactory.getLogger(TestController.class);
        int[] countCareer = careerService.findCareer() ;
        logger.info("learningman,{}",countCareer);
        int count = 0 ;
        for(Career careerChange:careerService.findAll())
        {
            careerChange.setLearningMan(countCareer[count]);
            count++;
            careerService.updateCareer(careerChange);
            logger.info("learningman,{}",careerChange.getLearningMan());
        }

            model.addAttribute("career1" , careerService.findCareerById(1));//传入
            model.addAttribute("career2" , careerService.findCareerById(2));//传
            model.addAttribute("career3" , careerService.findCareerById(3));//传
            model.addAttribute("career4" , careerService.findCareerById(4));//传
            model.addAttribute("career5" , careerService.findCareerById(5));//传

            return "t11";
    }








}

