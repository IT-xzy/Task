package com.ptteng.controller;

import com.ptteng.DESUtil;
import com.ptteng.entity.User;
import com.ptteng.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/2/15  16:11
 * @Version 1.0
 **/
@Controller
public class UserController {
    @Autowired
    UserService userService;
    Logger logger = Logger.getLogger(UserController.class);

    //    访问register,跳到registerPage页面
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "one/registerPage";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String insert(User user, String name) {
        logger.info("新注册用户信息================" + user);
//        通过用户名查找数据,看是否有这条数据
        List<User> users = userService.selectByName(name);
        logger.info("查看数据库里是否有配置的数据================" + users);
//        能查出来这条数据就说明数据库里有这条数据,那么注册失败,否则注册成功,跳转到登录页面
        if (!CollectionUtils.isEmpty(users)) {
            logger.info("用户已存在=============");
            return "redirect:/register";
        } else {
            if (
                    user.getName() != null
                            && user.getName().length() > 0
                            && user.getPassword() != null
                            && user.getPassword().length() > 0) {
                logger.info("注册用户的信息=============" + user);
                int row = userService.insert(user);
                logger.info("插入成功===============" + row);
                return "one/loginPage";
            } else {
                return "redirect:/register";
            }
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(User user,HttpServletResponse response, DESUtil desUtil) throws UnsupportedEncodingException {
        logger.info("user============" + user);
//        如果能查出来数据,说明数据库里有这条数据,那么登录成功,跳转首页,否则登录失败,跳回登录页面

        List<User> list = userService.selectByCondition(user.getName(), user.getPassword());
        logger.info("list=======================" + list);
//          DES加密
        String str1 = desUtil.encryptFromLong(System.currentTimeMillis());
        String str2 = desUtil.encryptFromLong(user.getId());
//          token由用户名,id,登录时间组成
        String token = desUtil.encrypt(str1+"|"+user.getName()+"|"+str2);
        logger.info("token============="+token);
        if (!CollectionUtils.isEmpty(list)) {

//            创建cookie对象,将登录信息存入里面
            Cookie nameCookie = new Cookie("name", user.getName());
//              创建cookie对象,把token放进去
            Cookie tokenCookie = new Cookie("token",token);
//          设置token的生命周期为30分钟
            tokenCookie.setMaxAge(30*60);
//            设置cookie的生命周期30分钟
            nameCookie.setMaxAge(30 * 60);
//          保存到客户端
            response.addCookie(tokenCookie);
//            保存cookie到客户端
            response.addCookie(nameCookie);



            return "home";
        } else {
            return "one/loginPage";
        }
    }
}
