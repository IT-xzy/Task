package cn.wp.controller;

import cn.wp.aspect.WebLog;
import cn.wp.encryption.DESUtil;
import cn.wp.encryption.MD5Util;
import cn.wp.model.User;
import cn.wp.service.MobileService;
import cn.wp.service.UserService;
import cn.wp.utils.AliUtil;
import cn.wp.utils.SmsUtil;
import cn.wp.utils.TengXunUtil;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.TimeZone;

/** @ClassName:Smscontroller @Description:短信接口 @Author: 老王 @Date: 2019/6/13 15:33 @Version: 1.0 */
@Controller
public class SmsController {
  @Autowired UserService userService;
  @Autowired MobileService mobileService;
  @Autowired SmsUtil smsUtil;
  @Autowired AliUtil aliUtil;
  @Autowired TengXunUtil tengXunUtil;

  Logger log = Logger.getLogger(SmsController.class);
  /**
   * @Author: wp @Description: 先去获取手机验证码 @Param: [phone]
   *
   * @return: java.lang.String @Exception: @Date: 2019/6/16 11:34
   */
  @RequestMapping(value = "/a/get", method = RequestMethod.GET)
  public String getCode() {
    return "code";
  }

  @WebLog(description = "获取验证码页")
  @RequestMapping(value = "/getPhone", method = RequestMethod.POST)
  public String getCode(String phone) {
    log.info("手机号==========" + phone);
    // 当天开始的时间和当天结束的时间
    long current = System.currentTimeMillis();
    long dayStart =
        (current / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset())
            + 86400000;
    long dayEnd = dayStart + 24 * 60 * 60 * 1000 - 1;
    // 统计小于等于当天结束时间的时间戳
    int number = mobileService.selectTime(dayStart, dayEnd, Long.valueOf(phone));
    // 如果一个手机号获取验证码超过3次,则不能发送验证码,返回首页
    if (number >= 3) {
      return "home";
    } else {
      // 获取随机数,当验证码的内容
      // 把验证码存到数据库中
      // 发送验证码
      long code = randomCode();
      log.info("code and phone====" + code + "" + phone);
      long result = mobileService.insertCodePhone(code, Long.valueOf(phone), current);
      log.info("result====" + result);

      String sendResult = smsUtil.setSms(String.valueOf(code), phone);
      log.info("sendResult====" + sendResult);
      return "register";
    }
  }

  /** 生成四位随机数,并将手机号和验证码插入 */
  public long randomCode() {
    Random random = new Random();
    long code = 1000 + random.nextInt(8999);
    log.info("验证码是多少啊=========" + code);
    return code;
  }

  //  @WebLog(description = "手机注册页")
  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public String insert(User user, MultipartFile multipartFile, HttpServletResponse response)
      throws IOException {
    log.info("============" + user);
    log.info("图片" + multipartFile);
    // 先判空
    if (!ObjectUtils.isEmpty(user)
        && !ObjectUtils.isEmpty(user.getName())
        && !ObjectUtils.isEmpty(user.getPassword())
        && !ObjectUtils.isEmpty(user.getPhone())
        && !ObjectUtils.isEmpty(user.getCode())
        && !ObjectUtils.isEmpty(user.getMail())
        && !ObjectUtils.isEmpty(multipartFile)) {
      // 看数据库里没有有这个用户名,如果有则返回注册页面
      User userName = userService.selectByName(user.getName());
      log.info("用户名是=========" + userName);
      if (!ObjectUtils.isEmpty(userName)) {
        log.info("用户名已经存在");
        return "register";
      } else {

        // 通过注册时提交的手机号和验证码去另一张表里查手机号和验证码,

        User users = userService.selectCodePhone(user.getPhone(), user.getCode());
        log.info("手机号和验证码是============" + users);
        if (!ObjectUtils.isEmpty(users)) {
          log.info("手机号和验证码不匹配,重新获取验证码");
          return "code";
        } else {

          String key = user.getName() + ".jpg";
          // 上传图片
          // 用multipartFile接收到传进来的文件,调用工具类
          log.info("key是========" + key);
          // 将multiPartFile格式转化为file
          CommonsMultipartFile cf = (CommonsMultipartFile) multipartFile;
          DiskFileItem fi = (DiskFileItem) cf.getFileItem();
          File file = fi.getStoreLocation();

          boolean state = aliUtil.uploadImage((MultipartFile) file);
          log.info("图片上传状态=========" + state);

          // 给密码使用md5加密,然后把id当盐加入
          user.setPassword(MD5Util.MD5(user.getPassword() + user.getId()));
          log.info("密文========" + user);
          boolean sate = userService.insert(user);
          log.info("是否插入=========" + sate);

          // 插入以后给用户发一个token,token,由当前时间,用户名,用户ID组成使用DES加密
          String token =
              DESUtil.encrypt(
                  System.currentTimeMillis() + "|" + user.getName() + "|" + user.getId());
          log.info("token is " + token);
          Cookie cookie = new Cookie("token", token);
          cookie.setMaxAge(30 * 60);
          log.info("cookie is " + cookie.getName() + "/" + cookie.getValue());
          response.addCookie(cookie);
          return "home";
        }
      }
    }
    log.info("数据为空");
    return "register";
  }
}
