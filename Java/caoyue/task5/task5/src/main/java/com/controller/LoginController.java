package com.controller;

import com.Impl.LoginServiceImpl;
import com.POJO.User;
import com.Utils.CookieUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author: 曹樾
 * @program: task5-module
 * @description:
 * @create: 2018/5/9 下午3:45
 */
@Controller
public class LoginController {
    private static final Logger LOG= Logger.getLogger(LoginController.class);
    @Autowired
    private LoginServiceImpl loginServiceImpl;
    /**
     * 登录请求
     *
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpSession session , HttpServletResponse response, User user, ModelMap model) {
        return "login";
//        String result = loginServiceImpl.findUser(session ,response, user);
//        if (result.equals("登录成功")) {
//            return "redirect:/u/index";
//        }
//        model.addAttribute("result", result);
//        return "redirect:/u/index";
    }
    @RequestMapping(value = "/elogin" ,method = RequestMethod.POST)
    public String testlogin(HttpSession session , HttpServletResponse response, User user, ModelMap model) {
        
        String result = loginServiceImpl.findUser(session ,response, user);
        System.out.println(result);
        if (result == "登录成功") {
            return "redirect:/u/index";
        }
        model.addAttribute("result", result);
        return "redirect:/u/index";
    }
    /**
     * 注册请求
     * @return
     */
    @RequestMapping("/relogin")
    public String regiterController() {
        return "/register";
    }
    @RequestMapping("/register")
    public String signController(ModelMap modelMap, User record,String recordPassword) {
//        System.out.println(record);
//        System.out.println(recordPassword);
        String result = loginServiceImpl.siginUser(record,record.getPassword());
//        System.out.println(result);
        if (result == "注册成功") {
            System.out.println("注册成功");
            return "/login";
        }
        modelMap.addAttribute("result", result);
        System.out.println("register again");
        return "redirect:/login";
    }
    
    /**
     * 注销
     *
     * @param response
     * @return
     */
//    @RequestMapping("/loginout")
//    public String loginOut(HttpServletResponse response,HttpSession session) {
//        //清除cookie
//        CookieUtil.clearCookie(response, "JWT_COOKIE");
//        //清除session
//
//        session.invalidate();
//        return "loginjspss";
//    }
}
