package lujing.controller;

import lujing.Constant;
import lujing.pojo.User;
import lujing.security.MessageDigestUtils;
import lujing.serviceimpl.UserServiceImpl;
import lujing.util.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.POST;

/**
 * @author lujing
 * Create_at 2018/1/4 19:44
 */
@Controller
@RequestMapping("")
public class LoginController {
    @Autowired
    UserServiceImpl userServiceImpl;
    
    /**
     * 登录请求
     *
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public String login(HttpSession session , HttpServletResponse response, User user, ModelMap model) {
        
        String result = userServiceImpl.findUser(session ,response, user);
        if (result.equals(Constant.loginSuccess)) {
            return "redirect:/u/joblist";
        }
        model.addAttribute("result", result);
        return "redirect:/loginjsp";
    }
    
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
     * 注册请求
     *
     * @param modelMap
     * @param record
     * @param qq
     * @return
     */
    @RequestMapping("/sigin")
    public String signController(ModelMap modelMap, User record, String qq) {
        
        String result = userServiceImpl.siginUser(record, qq);
        if (result == Constant.signSuccess) {
            return "/login/sigSuccess";
        }
        //失败
        modelMap.addAttribute("result", result);
        return "redirect:/loginjsp";
    }
    
    /**
     * 注销
     *
     * @param response
     * @return
     */
    @RequestMapping("/loginout")
    public String loginOut(HttpServletResponse response,HttpSession session) {
        //清除cookie
        CookieUtils.clearCookie(response, Constant.jwtCookieName);
        //清除session
        
        session.invalidate();
        return "loginjspss";
    }
    
  
    
}
