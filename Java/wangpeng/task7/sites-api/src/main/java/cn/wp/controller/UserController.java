package cn.wp.controller;

import cn.wp.aspect.WebLog;
import cn.wp.encryption.DESUtil;
import cn.wp.encryption.MD5Util;
import cn.wp.model.User;
import cn.wp.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired UserService userService;

  Logger log = Logger.getLogger(UserController.class);

  /** 登录 */
  @RequestMapping(value = "/a/u/login", method = RequestMethod.GET)
  public String loginOk() {
    return "login";
  }

  @WebLog(description = "登录页")
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String login(User user, HttpServletResponse response) throws UnsupportedEncodingException {
    //      参数判空
    if (!ObjectUtils.isEmpty(user.getName()) && !ObjectUtils.isEmpty(user.getPassword())) {
      //       密码加密
      user.setPassword(MD5Util.MD5(user.getPassword() + user.getId()));
      log.info("加密后" + user);
      // 对比数据
      User state = userService.selectByCondition(user.getName(), user.getPassword());
      log.info("state is " + state);
      if (ObjectUtils.isEmpty(state)) {
        //                                        发一个token,token由用户名,id,登录时间组成
        //                                        DES加密
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

  //  /** 注册 */
  //  @RequestMapping(value = "/a/u/register", method = RequestMethod.GET)
  //  public String register() {
  //    return "register";
  //  }
  //
  //  @RequestMapping(value = "/register", method = RequestMethod.POST)
  //  public String insert(User user, HttpServletResponse response)
  //      throws UnsupportedEncodingException {
  //    logger.info("user========================" + user);
  //    //                对传入参数进行判空
  //    if (!ObjectUtils.isEmpty(user.getName()) && !ObjectUtils.isEmpty(user.getPassword())) {
  //
  //      //                       注册时,先根据用户名查数据库,如果查不出则插入,否则返回注册页面
  //      User userName = userService.selectByName(user.getName());
  //      logger.info("userName====================" + userName);
  //      if (ObjectUtils.isEmpty(userName)) {
  //        //                                插入时,使用MD5加密再加盐
  //        user.setPassword(MD5Util.MD5(user.getPassword()) + user.getId());
  //        logger.info("用户名和加密后的密码=================" + user);
  //        boolean row = userService.insert(user);
  //        logger.info("是否插入================" + row);
  //        logger.info("userId===============" + user.getId());
  //        User dbUser = userService.selectByCondition(user.getName(), user.getPassword());
  //        //                                发一个token
  //        String token =
  //            DESUtil.encrypt(
  //                System.currentTimeMillis() + "|" + user.getName() + "|" + dbUser.getId());
  //        logger.info("token=================" + token);
  //        Cookie cookie = new Cookie("token", token);
  //        cookie.setMaxAge(30 * 60);
  //        logger.info("tokenName===================" + cookie.getName());
  //        logger.info("tokenValue==================" + cookie.getValue());
  //        response.addCookie(cookie);
  //        logger.info("确认数据======================");
  //        return "home";
  //      }
  //      logger.info("用户名已存在=================");
  //      return "redirect:/a/u/register";
  //    }
  //    logger.info("用户名密码为空================");
  //    return "redirect:/a/u/register";
  //  }
