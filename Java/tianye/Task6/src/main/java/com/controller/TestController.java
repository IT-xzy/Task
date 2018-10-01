package com.controller;

import com.DES.MD5Util;
import com.Memcached.MemcachedUtil;
import com.pojo.Shop;
import com.pojo.t_information;
import com.pojo.t_studentPro;
import com.token.Token;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.pojo.t_student;
import com.service.stuService;


import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;


@Controller
public class TestController {
    private static Logger logger= Logger.getLogger(TestController.class);
    @Resource
    private stuService stuService;
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public  String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
        public String toRegister(){
            return "register";
        }
        @RequestMapping(value = "/register",method = RequestMethod.POST)
        public String register(t_information t_Information) {
            t_Information.setCreate_at((new Date()).getTime());
            String userPassword= t_Information.getUserPassword();
            String password= MD5Util.stringToMD5(userPassword+"!!!abc");
            t_Information.setUserPassword(password);
            this.stuService.insert(t_Information);
            return "login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
     public  String  login(HttpSession httpSession, String userId , String userPassword, HttpServletRequest request,HttpServletResponse response) throws Exception {
        long loginTime = System.currentTimeMillis();//登录时间为系统时间
        t_information t_information = stuService.select(userId);
        //当存在这个用户时
        if (t_information != null) {
            logger.info(Token.encryptToken(t_information.getUserId(), loginTime));
            String token1 = Token.encryptToken(t_information.getUserId(), loginTime);//token加密
            Cookie token = new Cookie("token", token1);//token放在cookie中
            logger.info("这是token"+token);
            response.addCookie(token);
            String password = MD5Util.stringToMD5(userPassword + "!!!abc");//密码加密
            if (password.equals(t_information.getUserPassword())) {
                httpSession.setAttribute("userId", t_information.getUserId());
                System.out.println("登录成功");
                 return "redirect:/u/profession";
               //request.getRequestDispatcher("/u/profession").forward(request, response);
            } else {
                request.setAttribute("loginError", "密码错误，请重新输入");
                logger.info("密码错误，请重新输入");
//                request.getRequestDispatcher("WEB-INF/tiles/login.jsp").forward(request, response);
                return "login";
            }
        }
        //不存在这个用户
        else {
            request.setAttribute("loginError", "学号错误，请重新输入");
            logger.info("学号错误，请重新输入");
        //  request.getRequestDispatcher("WEB-INF/tiles/login.jsp").forward(request, response);
            return "login";
        }
    }

    @RequestMapping(value = "/introduction", method = RequestMethod.GET)
    public String select(Model model) {
        List<t_student> studentList=this.stuService.selectAll();
        model.addAttribute("students",studentList);
        return "introduction";

    }
   @RequestMapping(value = "/u/profession", method = RequestMethod.GET)
    public String select1(Model model) {
        List<t_studentPro> studentProList=stuService.listUser();
        model.addAttribute("studentPro",studentProList);
        return "profession";
   }
//   //更改密码
//   /@RequestMapping(value = "/alter",method = RequestMethod.GET)
//    public String update(String userId,)
//
////   }

}


