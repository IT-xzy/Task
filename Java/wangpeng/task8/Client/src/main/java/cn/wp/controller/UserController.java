package cn.wp.controller;

import cn.wp.aspect.WebLog;
import cn.wp.encryption.DESUtil;
import cn.wp.encryption.MD5Util;
import cn.wp.model.User;
import cn.wp.service.UserService;
import cn.wp.utils.RandomUtil;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/** @ClassName: @Description: @Author: 老王 @Date: 2019/5/23 12:39 @Version: 1.0 */
@Controller
public class UserController {

  Logger log = Logger.getLogger(UserController.class);

  /** 登录 */
  @RequestMapping(value = "/a/u/login", method = RequestMethod.GET)
  public String loginOk() {
    return "login";
  }

  @WebLog(description = "登录页")
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String login(User user, HttpServletResponse response) throws UnsupportedEncodingException {
    User state;
    UserService userService;
      // 根据随机数不同来获取不同服务
    if (RandomUtil.randomCode() == 0) {
      try {
        ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("serverPackage/server.xml");

        userService = (UserService) applicationContext.getBean("user");
      } catch (Exception e) {
        ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("serverPackage/server1.xml");

        userService = (UserService) applicationContext.getBean("user1");
      }
    } else {
      try {
        ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("serverPackage/server1.xml");

        userService = (UserService) applicationContext.getBean("user1");
      } catch (Exception e) {
        ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("serverPackage/server.xml");

        userService = (UserService) applicationContext.getBean("user");
      }
    }
    //      参数判空
    if (!ObjectUtils.isEmpty(user.getName()) && !ObjectUtils.isEmpty(user.getPassword())) {
      //       密码加密
      user.setPassword(MD5Util.MD5(user.getPassword() + user.getId()));
      log.info("加密后" + user);
      // 对比数据
      state = userService.selectByCondition(user.getName(), user.getPassword());
      log.info("state is " + state);
      if (ObjectUtils.isEmpty(state)) {
        //   发一个token,token由用户名,id,登录时间组成
        //    DES加密
        String token =
            DESUtil.encrypt(System.currentTimeMillis() + "|" + user.getName() + "|" + user.getId());
        log.info("token===========" + token);
        Cookie cookie = new Cookie("tokens", token);
        cookie.setMaxAge(30 * 60);
        log.info("tokenName=========" + cookie.getName());
        log.info("tokenValue============" + cookie.getValue());
        response.addCookie(cookie);
        log.info("看看保存了没有");
        return "home";
      } else {
        log.info("无此用户,去注册============");
        return "email";
      }
    }
    log.info("参数为空");
    return "login";
  }

  @WebLog(description = "注销")
  @RequestMapping(value = "/a/u/logout", method = RequestMethod.GET)
  public String logout(HttpServletResponse response, HttpServletRequest Request) {
    //                创建一个cookie对象,得到cookie
    Cookie[] cookies = Request.getCookies();
    //                取出cookie
    for (Cookie cookie : cookies) {
      //                        如果存在name为token的cookie,则取出并修改token的时效为0
      if (cookie.getName().equals("token")) {
        cookie.setMaxAge(0);
        log.info("被删除的token是" + cookie.getName());
        response.addCookie(cookie);
        return "home";
      }
    }
    return "home";
  }
}
