package controller;


import dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pojo.User;
import utils.Ossutils;

import javax.servlet.http.HttpServletRequest;

@Controller
public class JnshuController {
@Autowired
    UserMapper userMapper;
@Autowired
    Ossutils ossutils;

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home(Integer id, HttpServletRequest httpServletRequest){
        User user = userMapper.selectbyid(id);
        if (user ==null){
            return  "home";
        }
        else {
            httpServletRequest.setAttribute("user",user);
            return "home";
        }
    }

    @RequestMapping(value = "/error",method = RequestMethod.GET)
    public String error(){
        return "error";
    }

    @RequestMapping(value = "/phonelogin",method = RequestMethod.GET)
    public String phonelogin() {return "phonelogin";}

    @RequestMapping(value = "/emaillogin",method = RequestMethod.GET)
    public String emaillogin() {return "emaillogin";}

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login() {return "login";}

    @RequestMapping(value="/phoneregister",method = RequestMethod.GET)
    public String phoneregister() {return "phoneregister";}

    @RequestMapping(value = "/emailregister",method = RequestMethod.GET)
    public String emailregister() {return "emailregister";}

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register() {return "register";}

    @RequestMapping(value = "/registerselect",method = RequestMethod.GET)
    public String registerselect(){return "registerselect";}

    @RequestMapping(value = "/loginselect",method = RequestMethod.GET)
    public String loginselect(){return "loginselect";}
}
