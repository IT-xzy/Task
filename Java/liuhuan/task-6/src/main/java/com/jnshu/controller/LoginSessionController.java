package com.jnshu.controller;

import com.jnshu.model.Auth;
import com.jnshu.service.UserService;
import com.jnshu.tools.MemcacheUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/* 认证Controller */
@Controller
public class LoginSessionController {
    //日志
    private static Logger logger = LoggerFactory.getLogger(LoginSessionController.class);
    @Qualifier("userServiceMemcacheImpl")
    @Autowired
    UserService userService;
    @Autowired
    MemcacheUtils memcacheUtils;

    // 跳转到登陆页面
    @RequestMapping(value = "/login.action", method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    //登陆
    @RequestMapping("/validate.action")
    public String login(HttpSession session, Auth auth) throws Exception {
        if(userService.findAuth(auth)){
            // 在session中保存用户身份信息
            session.setAttribute("username", auth.getUsername());
            logger.info("session.getId():" + session.getId());
            // 存入缓存 用作效验
            memcacheUtils.set(session.getId(), auth.getUsername());
            logger.info("memcached 验证账号时 : " + (String) memcacheUtils.get(session.getId()));
        }
        //redirect 重定向到用户信息页面,会导致session内容丢失. 这里先forward保存session
        return "forward:/succed.action";
    }

    //首页跳转到综合页面 这是被 springmvc_rest 拦截处理的
    @RequestMapping("/succed.action")
    public String test(HttpSession session) {
        logger.info(" memcached 确认跳转时 : " + (String) memcacheUtils.get(session.getId()));
        return "redirect:/u/userList.action";
    }

    //退出登陆
    @RequestMapping("/logout.action")
    public String logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        HttpSession session = httpServletRequest.getSession();
        logger.info(" memcached 删除时 : " + (String) memcacheUtils.get(session.getId()));
        // 删除缓存
        memcacheUtils.delete(session.getId());
        //删除session
        session.invalidate();

        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null){
            for (Cookie c : cookies) {
                if (c.getName().equals("token")){
                    // cookie有效时间为0 即失效
                    c.setMaxAge(0);
                    httpServletResponse.addCookie(c);
                    return "redirect:/login";
                }
            }
        }
        return "redirect:/login.action";
    }
}