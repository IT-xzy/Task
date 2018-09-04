package com.zyq.controller;

import com.zyq.pojo.ExcellentStudent;
import com.zyq.pojo.User;
import com.zyq.service.ExcellentStudentService;
import com.zyq.service.UserService;
import com.zyq.util.DESUtil;
import com.zyq.util.JwtToken;
import com.zyq.util.MD5Util;
import com.zyq.util.UUIDUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("")
public class UserController {

    private static Logger logger = LogManager.getLogger(StudentController.class);

    @Autowired
    UserService userService;
    @Autowired
    ExcellentStudentService excellentStudentService;
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String Resister(User user, Model model){
        logger.info("这是注册用户。。。。。。。。。。。");
        logger.info("原始密码为："+user.getPassword());
        String salt = UUIDUtil.getSalt();
        logger.info("盐值为："+salt);
        user.setSalt(salt);
        String password = MD5Util.encoder(user.getPassword(),salt);
        logger.info("加盐加密后密码为："+password);
        user.setPassword(password);
        userService.insert(user);
        model.addAttribute("item","loginBody");
        model.addAttribute("msg","注册成功，请登录");
        return "myView";
    }

    @RequestMapping(value = "/User",method = RequestMethod.POST)
    public String Login(User user, Model model, HttpSession session, HttpServletResponse response) {
        logger.info("这是用户登录。。。。。。。。。。。。。。。");
        User user1 = userService.selectByUserName(user.getUsername());
        if (user1==null){
            model.addAttribute("msg", "账号输入错误");
            model.addAttribute("item", "loginBody");
            logger.info("账号输入错误。。。。。。。。。。。。");
            return "myView";
        }else if (user1.getSalt() == null || user1.getSalt().length() <= 0){
            logger.info("这类用户注册过早，没有加密加盐，密码容易泄露。");
            if (user1.getPassword() == null || user1.getPassword().length() <= 0 || !(user1.getPassword()).equals(user.getPassword())) {
                logger.info("用户名密码错误");
                model.addAttribute("msg", "用户名密码错误，请重新输入。");
                model.addAttribute("item", "loginBody");
                return "myView";
            }
        } else {
            logger.info("这类用户密码加盐加密，比较安全。");
            logger.info("原始密码为：" + user.getPassword());
            logger.info("盐值为：" + user1.getSalt());
            String password = MD5Util.encoder(user.getPassword(), user1.getSalt());
            logger.info("加密加盐后密码为：" + password);
            logger.info("数据库存储的密码为：" + user1.getPassword());
            if (user1.getPassword() == null || user.getPassword().length() <= 0 || !(user1.getPassword()).equals(password)) {
                logger.info("用户名密码错误");
                model.addAttribute("msg", "用户名密码错误，请重新输入。");
                model.addAttribute("item", "loginBody");
                return "myView";
            }
        }
        logger.info(user.getUsername()+":恭喜您登录成功。");
        List<ExcellentStudent> list = excellentStudentService.selectByOrder();
        String idPWD = DESUtil.encode(user1.getId().toString());
        String token = JwtToken.sign(idPWD, 30L * 60L * 1000L);
        Cookie cookie1 = new Cookie("token", token);
        cookie1.setHttpOnly(true);
        cookie1.setMaxAge(30*60);
        String sessionId = session.getId();
        Cookie cookie2 =new Cookie("JSESSIONID",sessionId);
        cookie2.setHttpOnly(true);
        cookie2.setMaxAge(30*60);
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        model.addAttribute("list", list);
        model.addAttribute("item", "indexBody");
        session.setAttribute("username", user.getUsername() + ",欢迎您!");
        return "myView";
    }

    @RequestMapping(value = "/exit")
    public String Exit(Model model, HttpSession session, HttpServletRequest request,HttpServletResponse response){
        model.addAttribute("item","indexBody");
        session.removeAttribute("username");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies) {
            if (cookie.getName().equals("token")){
                cookie.setValue("");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }else if (cookie.getName().equals("JSESSIONID")){
                cookie.setValue("");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        logger.info("退出成功。。。。。。。。。。");
        return "myView";
    }
    @ResponseBody
    @RequestMapping(value = "/user/{username}",method = RequestMethod.GET)
    public String getByUserName(@PathVariable String username){
        String password = userService.selectPwdByUserName(username);
        if(password!=null&&password.length()>0){
            logger.info("该账号已存在。。。。。。。。。。。。");
            return "0";
        }else {
            logger.info("该账号可用，请输入密码");
            return "1";
        }
    }
}
