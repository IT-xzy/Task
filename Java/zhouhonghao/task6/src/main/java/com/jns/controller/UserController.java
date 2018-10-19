package com.jns.controller;

import com.jns.entity.Users;
import com.jns.service.UsersService;
import com.jns.utils.DESUtil;
import com.jns.utils.MD5Util;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@Controller
@RequestMapping("")
public class UserController {

    //借助slf4j记录日志
    Logger logger= LoggerFactory.getLogger(UserController.class);

    @Autowired
    UsersService usersService;
    //指定请求的实际地址，请求的method类型
    //注册页面
    @RequestMapping(value = "/register" , method = RequestMethod.GET)
    public String toRegister(){
        return  "register";
    }
    //登录页面
    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public String toLogin(){
        return  "login";
    }
    //登录以及登录验证
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(Users users, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //防止空指针
        if(users!=null) {
            //注册时候用，数据库中保存的是加密的字符。
            //使用md5对用户密码进行加密
            String passwordMd5 = MD5Util.stringToMD5(users.getPassword());
            users.setPhone(users.getPhone());
            users.setPassword(passwordMd5);
            //声明一个新的用户来接受返回的用户数据
            Users user = usersService.checkLogin(users.getPhone(), users.getPassword());
            if (user != null) {
                //为了记录用户信息，把登录成功的用户信息保存在服务端的session中
                request.getSession().setAttribute("name", users.getPhone());
                request.getSession().setAttribute("pwd", users.getPassword());
                //通过用户phone，找到这个用户，并根据部分信息生成一个token，以便识别用户登录状态
                Users userAuth1 = usersService.getByPhone(users.getPhone());
                long id = userAuth1.getId();
                // 使用系统当前时间生成唯一token, 格式为键值对
                String token = id + "=" + System.currentTimeMillis();
                // 加密key 必须8位
                String key = "liuhuan1";
                // DESUtil加密
                byte[] bytes = DESUtil.encrypt(token, key);
                //两种加密手段
                logger.info("加密后的token: {}" , DESUtil.toHexString(bytes).toUpperCase());
                logger.info("加密后的Base64 token: {}" , Base64.encodeBase64String(bytes));
                //调用方法来管理cookie
                managerCookie("phone",user.getName()+"",6000,response);
                // 使用  org.apache.commons.codec.binary.Base64;
                //把加密后的token放入cookie中，以便储存登录状态
                managerCookie("token", Base64.encodeBase64String(bytes),6000,response);
                //重定向，跳转到首页home
                return new ModelAndView("redirect:/home");
            }
        }
        //如果用户未登录，跳转到登录页面
        return new ModelAndView("redirect:/login");
    }

    private void managerCookie(String name, String value, int maxAge,HttpServletResponse response) throws UnsupportedEncodingException {
        Cookie cookie = new Cookie(name, value);
        if(value!=null) {
            String valueEncoder = URLEncoder.encode(value, "utf-8");
            cookie = new Cookie(name, valueEncoder);
        }
            //cookie的生命周期以及路径
            cookie.setMaxAge(maxAge);
            cookie.setPath("/");
            //保存cookie
            response.addCookie(cookie);
    }

    //注册以及判断用户phone重复
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(Users users,HttpServletResponse response) throws IOException{
        //防止空指针
        if(users!=null) {
                //新创建一个用户对象，设置它的注册时间。
                Users u = new Users();
                u.setPassword(users.getPassword());
                u.setPhone(users.getPhone());
                u.setCreate_at(users.getCreate_at());
                //判断注册的phone是否重复。
                Users user = usersService.getByPhone(users.getPhone());
                if (user == null) {
                    //使用MD5对注册的用户密码进行加密。
                    String passwordMd5 = MD5Util.stringToMD5(u.getPassword());
                    u.setPassword(passwordMd5);
                    //保存注册用户的信息
                    usersService.add(u);
                    //跳转到用户信息页面
                    managerCookie("phone", String.valueOf(u.getPhone()),6000,response);
                    ModelAndView modelAndView = new ModelAndView();
                    modelAndView.setViewName("redirect:/home");
                    return modelAndView;
                }
            }
            //若用户的phone存在，请换一个phone再注册
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("register");
            return modelAndView;
    }

    //注销
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletResponse response) throws UnsupportedEncodingException {
        //清除cookie中的数据
        managerCookie("phone", null,0,response);
        managerCookie("token", null,0,response);
        //返回首页
        return  new ModelAndView("redirect:/home");
    }
    //用户个人信息页面
    @RequestMapping(value = "/personal" , method = RequestMethod.GET)
    public String toPersonal(Model model,HttpServletRequest request) throws UnsupportedEncodingException {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("phone")) {
                    logger.info("name"+cookie.getValue());
                    logger.info("name1"+URLDecoder.decode(cookie.getValue(),"utf-8"));
                    Users users = usersService.getByName(URLDecoder.decode(cookie.getValue(),"utf-8"));
                    if(users==null){
                        logger.info("phone"+Integer.parseInt(URLDecoder.decode(String.valueOf(cookie.getValue()),"utf-8")));
                         users = usersService.getByPhone(Integer.parseInt(URLDecoder.decode(String.valueOf(cookie.getValue()),"utf-8")));
                    }
                    model.addAttribute("c",users);
                    logger.info("long时间类型{}",users.getSign());
                    logger.info("long时间类型{}",users.getCreate_at());
                    return "personal";
                }
            }
        return "register";
    }
    @RequestMapping(value = "/personal" , method = RequestMethod.POST)
    public ModelAndView personal(Users users, HttpServletResponse response) throws UnsupportedEncodingException {
        logger.info(users.getName()+users.getSign()+users.getId());
        usersService.update(users);
        managerCookie("phone",users.getName(),6000,response);
        return new ModelAndView("redirect:/home");
    }
}
