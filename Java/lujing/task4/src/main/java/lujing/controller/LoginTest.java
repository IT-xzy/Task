package lujing.controller;

import lujing.mapper.UserMapper;
import lujing.pojo.User;
import lujing.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author lujing
 * Create_at 2018/1/9 13:59
 */
@Controller
public class LoginTest {
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/lgtest")
    public String LoginTest(HttpSession session ,Model model, User testUser){
       
       //判断逻辑
        //..
       User checkUser =  userMapper.selectByUser(testUser);
       if(null == checkUser){
           return "redirect:lgtest";
       }
       
       session.setAttribute("ussername",checkUser.getName());
       session.setMaxInactiveInterval(60*30);
       
        return "xkt/test1";
    }
}
