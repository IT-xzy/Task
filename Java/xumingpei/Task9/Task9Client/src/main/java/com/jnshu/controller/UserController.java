package com.jnshu.controller;

import com.jnshu.pojo.User;
import com.jnshu.tool.DesUtil;
import com.jnshu.tool.Md5Util;
import com.jnshu.tool.RMI.RMIClient;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/4/3 - 2:23
 */
@Controller
public class UserController {
    private static Logger logger = Logger.getLogger(UserController.class);

    //跳转页面
    @RequestMapping(value = "/goRegister", method = RequestMethod.GET)
    public String register() {
        logger.info("进入注册页面");
        return "register";
    }



    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String insert(User user, HttpServletResponse response, String msgCode) throws IOException {
        RMIClient rmiClient = RMIClient.server();
        logger.info("新注册用户信息：" + user);
        //对传进来的参数进行判空
        if (!ObjectUtils.isEmpty(new String[]{user.getName()}) && !ObjectUtils.isEmpty(new String[]{user.getPassword()})) {
            //注册时,先根据用户名查,如果查不出,说明数据库里没有这条数据则插入,否则返回注册页面
            List<User> userName = rmiClient.getUserService().selectByName(user.getName());
            logger.info("userName："+userName);
            if (ObjectUtils.isEmpty(new List[]{userName})){
                //插入时，使用MD5给密码加密加盐
                user.setPassword(Md5Util.MD5(user.getPassword()+user.getId()));
                logger.info("加密后的密码："+user);
                int x = rmiClient.getUserService().insert(user);
                String token = DesUtil.encrypt(System.currentTimeMillis()+"|"+user.getName()+"|"+user.getId());
                logger.info("token："+token);
                Cookie cookie = new Cookie("token",token);
                cookie.setMaxAge(60*60);
                logger.info("tokenName："+cookie.getName());
                logger.info("tokenValue"+cookie.getValue());
                response.addCookie(cookie);
                return "home";
            }
            logger.info("用户名已存在");
            return "redirect:/goRegister";
        }
        logger.info("用户名密码为空");
        return "redirect:/goRegister";
    }

    @RequestMapping(value ="/goLogin",method = RequestMethod.GET)
    public String loginIn(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(User user , HttpServletResponse response, String name) throws UnsupportedEncodingException {
        RMIClient rmiClient = RMIClient.server();
        ModelAndView mav = new ModelAndView("home");
        logger.info("user:"+user);
        if (!ObjectUtils.isEmpty(new String[]{user.getName()}) && !ObjectUtils.isEmpty(new String[]{user.getPassword()})) {
            //密码加密加盐,然后用密码和用户名与数据库里的数据对比
            user.setPassword(Md5Util.MD5(user.getPassword() + user.getId()));
            logger.info("加密后的user:"+user);
            //对比一下传进来的和数据库里的是否一致
            List<User> user1 = rmiClient.getUserService().selectByNameAndPassword(user.getName(),user.getPassword());
            if (!ObjectUtils.isEmpty(new List[]{user1})) {
                logger.info("查出的数据：" + user1);
                //token由用户名,id,登录时间组成
                String token = DesUtil.encrypt(System.currentTimeMillis() + "|" + user.getName() + "|" + user.getId());
                logger.info("token：" + token);
                Cookie cookie = new Cookie("token", token);
                //设置过期时间，单位为秒
                cookie.setMaxAge(60 * 60);
                logger.info("tokenName：" + cookie.getName());
                logger.info("tokenValue：" + cookie.getValue());
                mav.addObject("name",user.getName());
                response.addCookie(cookie);
                logger.info("username："+user.getName());
                return mav;
            } else {
                logger.info("没有找到该用户");
                return mav;
            }
        }
        logger.info("账号密码错误");
        return mav;
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletResponse response, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            if (cookie.getName().equals("token")){
                cookie.setMaxAge(0);
                logger.info("被删除的token："+cookie.getName());
                response.addCookie(cookie);
                return "home";
            }
        }
        return "home";
    }
}
