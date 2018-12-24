package com.suger.controller;

import com.suger.pojo.User;
import com.suger.service.UserService;
import com.suger.util.DesUtils;
import com.suger.util.JwtUtils;
import com.suger.util.MD5Utils;
import com.suger.util.UUIDUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author suger
 * @date 2018/11/20 14:53
 *
 * 用户的注册，登录与注销
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    private static Logger logger = Logger.getLogger(UserController.class);


    //  -----------注册------------------

    @RequestMapping(value = "/u/reg",method = RequestMethod.GET)
    public String goReg(){
        return "reg";
    }

    @RequestMapping(value = "/u/reg",method = RequestMethod.POST)
    public String reg(User user, Model model, HttpServletRequest request, HttpServletResponse response){

        logger.info("注册信息："+user.toString());

        String name = user.getName();
        String pwd = user.getPwd();

        String message = null;

        // 判定输入用户名或者密码是否为空，若其中一项为空，则返回注册页面
        if(name.isEmpty() || pwd.isEmpty()){
            message = "用户名或者密码不能为空";
            model.addAttribute("msg",message);
            return "reg";
        }

        User user1 = userService.getUserByName(name);

        logger.info("注册用户已经存在："+user1);

        if(user1!=null){
            message = "用户已经存在！请重新输入！";
        }else {
            logger.info("未查询到用户信息，开始注册");
            // 获取盐值
            String salt = UUIDUtils.getUUID();
            logger.info("盐值："+salt);
            user.setSalt(salt);
            logger.info(user.toString());
            String password = MD5Utils.md5(user.getPwd()+salt);
            user.setPwd(password);
            long time = System.currentTimeMillis();
            user.setCreateAt(time);
            user.setUpdateAt(time);
            userService.insertUser(user);

            return "login";
        }

        model.addAttribute("msg",message);
        return "reg";
    }

    // ------------登录------------------------------

    @RequestMapping(value = "/u/login",method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response){
        return "login";
    }

    @RequestMapping(value = "/u/login",method = RequestMethod.POST)
    public String login(User user, Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

        logger.info("登录信息："+user.toString());

        // 获取用户信息
        String username = user.getName();
        String pwd = user.getPwd();
        String message = null;

        User userInfo = userService.getUserByName(username);
        logger.info("userInfo：" + userInfo);

        if (userInfo != null) {

            logger.info("用户密码明文:"+pwd);
            // 采用 UUID 为盐值
            String salt = userInfo.getSalt();
            logger.info("盐值："+salt);
            // md5 加密
            String password = MD5Utils.md5(pwd+salt);
            logger.info("加盐后的密码："+password);
            logger.info("数据库的密码："+userInfo.getPwd());

            // 判空以及验证密码
            if(userInfo.getPwd() == null || userInfo.getPwd().isEmpty() || !userInfo.getPwd().equals(password)) {
                message = "密码输入有误，请重新输入";
                logger.info(message);
                model.addAttribute("msg",message);
                return "login";
            }else{
                logger.info(username+"登录成功");
                // 实例化 jwt ,可以设置自己的加密密码---字符串形式
                JwtUtils jwtUtils = new JwtUtils();

                // 用户名加密后 和时间戳一起写入token
                String name = DesUtils.encode(user.getName());
                // 1小时后token过期
                long maxAge = 60L * 60L * 1000L;
                String token = jwtUtils.getToken(name, maxAge);

                Cookie cookie = new Cookie("token", token);
                logger.info("token = " + token);

                // 过期时间：1小时
                //cookie.setMaxAge(60*60);
                // 1天过期
                cookie.setMaxAge(24*60*60);
                cookie.setPath("/");
                response.addCookie(cookie);

                session.setAttribute("username",user.getName());
                // 30分钟过期
                session.setMaxInactiveInterval(30*60);
                session.setAttribute("username", username);

                return "redirect:/u/student";

            }

        }else{

            message = "用户名错误，请重新输入或者注册！";
            model.addAttribute("msg", message);
            return "login";
        }

    }

    //-----------------注销---------------------------
    @RequestMapping(value = "/u/logout",method = RequestMethod.GET)
    public String logout(HttpSession session,HttpServletRequest request, HttpServletResponse response){
        // 删除session
        session.invalidate();
        logger.info("注销------");

        Cookie[] cookies = request.getCookies();
        // setMaxAge(0)------删除Cookie失效----------默认 setMaxAge(-1) ,关闭浏览器删除Cookie
        for (Cookie cookie : cookies) {
            if ("token".equals(cookie.getName()) || "JSESSIONID".equals(cookie.getName())) {
                //cookie.setValue("");
                cookie.setValue(null);
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
        logger.info("退出登录");
        return "redirect:/home";
    }

}
