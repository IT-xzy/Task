package com.ev.controller;

import com.ev.entity.User;
import com.ev.exception.CustomException;
import com.ev.exception.WrongPasswordException;
import com.ev.service.UserService;
import com.ev.utils.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    private Logger logger= LoggerFactory.getLogger(LoggerFactory.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() throws Exception {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(HttpServletResponse response, @RequestParam(value = "account")String account, @RequestParam(value="password")String password) throws Exception{
        String resultPage=null;
        int expireMinutes=30;
        if (userService.login(account,password)) {
            resultPage="studentList";
            String token = (new JWTUtil()).createToken(account, expireMinutes);
            Cookie cookie = new Cookie("mytoken", token);
            cookie.setMaxAge(expireMinutes*60);
            response.addCookie(cookie);
            response.setContentType("text/html;charset=UTF-8");
            logger.info("Create JWT : "+account+" .");
            return resultPage;
        }else{
            throw new WrongPasswordException("Wrong account or password!");
        }
    }


    @RequestMapping(value = "/signup", method =RequestMethod.GET)
    public String getSignUp() throws Exception {
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String doSignUp(User user) throws Exception{
        try {
            Long time = System.currentTimeMillis();
            user.setUpdateAt(time);
            user.setCreateAt(time);
            userService.signUp(user);
            logger.info("Register user : "+ user.getName()+" .");
        }catch (CustomException e){
            e.setMessage("注册失败");
        }
        return "login";
    }
//    @RequestMapping(value = "/forgetpassword", method = RequestMethod.GET)
//    public String forgetPassword() throws Exception{
//        return "forgetPassword";
//    }
//
//    @RequestMapping(value = "/forgetpassword", method = RequestMethod.POST)
//    public String renewPasswordSuccess(@RequestParam User user,@RequestParam String password) throws Exception{
//        userService.signUp(user, password);
//        return "redirect:login";
//    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Cookie[] cookies=request.getCookies();
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("mytoken")) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        return "redirect:home";
    }


}
