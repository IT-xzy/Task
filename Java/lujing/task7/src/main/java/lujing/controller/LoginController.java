package lujing.controller;

import lujing.Constant;
import lujing.mapper.UserMapper;
import lujing.pojo.User;
import lujing.serviceimpl.UserServiceImpl;
import lujing.util.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author lujing
 * Create_at 2018/1/4 19:44
 */
@Controller

public class LoginController {
    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    UserMapper userMapper;
    
  
    /**
     * 登录页面
     *
     * @return
     */
    @RequestMapping("/loginjsp")
    public String loginJsp() {
        return "loginjspss";
    }
    /**
     * 用户登录认证接口
     * @param session
     * @param response
     * @param user
     * @param password
     * @return 0:认证成功。1：用户不存在。-1：认证失败。2：未激活
     */
    @RequestMapping(value = "/loginRequest", method = RequestMethod.POST)
    public @ResponseBody
    int loginRequest(HttpSession session, HttpServletResponse response, User user, String password) {
        
        int result = userServiceImpl.verifyUser(session, response, user, password);
        return result;
    }
    /**
     * 未激活跳转
     *
     * @param
     * @param
     * @return
     */
 
    @RequestMapping("/login")
    public String login(){
        return "redirect:/u/joblist";
    }
    /**
     * 注销
     *
     * @param response
     * @return
     */
    @RequestMapping("/loginout")
    public String loginOut(HttpServletResponse response, HttpSession session) {
        //清除cookie
        CookieUtils.clearCookie(response, Constant.jwtCookieName);
        //清除session
        
        session.invalidate();
        return "loginjspss";
    }
    
    
}
