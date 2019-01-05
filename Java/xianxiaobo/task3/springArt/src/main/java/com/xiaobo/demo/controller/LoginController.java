package com.xiaobo.demo.controller;


import com.xiaobo.demo.constant.Global;
import com.xiaobo.demo.pojo.Login;
import com.xiaobo.demo.pojo.Response;
import com.xiaobo.demo.service.LoginServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/a")
public class LoginController {
    @Autowired
    private LoginServiceImpl loginService;
    @Autowired
    Login login;
    @Autowired
    Response response;
    //没有登录的情况
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView notLoginError(){
        Response response = new Response(401,"请先登录后再使用此接口");
        return new ModelAndView("response","data",response);
    }
    //获取所有用户
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getToHome(){
        List<Login> loginList = loginService.getAll();
        return new ModelAndView("home","data",loginList);
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST, consumes={"application/json"},produces={"application/json"})
    @ResponseBody
    public ModelAndView postRegister(@Valid @RequestBody Login login){
        Integer checkResult = loginService.checkUsernameExist(login.getUsername());
        Response response;
        if(checkResult != null){
            response = new Response(400,"用户名已存在");
        }else{
            // 取出密码进行加密存储
            String password = login.getPassword();
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String hashedPassword = encoder.encode(password);
            login.setPassword(hashedPassword);
            Integer postResult = loginService.postUser(login);
            response = new Response();
        }

        return new ModelAndView("response","data",response);
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST, consumes={"application/json"},produces={"application/json"})
    @ResponseBody
    public ModelAndView postLogin(@Valid @RequestBody Login login,@ApiIgnore HttpSession session){
        Response response;
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashedPassword = loginService.getPasswordByUsername(login.getUsername());
        if(hashedPassword == null){
            response = new Response(200,"用户名不存在");
        }
        else if(!encoder.matches(login.getPassword(),hashedPassword)){
            response = new Response(200,"密码错误");
        }else{
            Login user = loginService.getIdByUsername(login.getUsername());
            session.setAttribute(Global.USER_SESSION_KEY,user.getId());
            response = new Response();
        }
        return new ModelAndView("response","data",response);
    }
}
