package com.ptteng.controller;


import com.ptteng.model.User;
import com.ptteng.service.NoteService;
import com.ptteng.service.UserService;
import com.ptteng.utils.*;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.http.HttpResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.TimeZone;


/**
 * @ClassName NoteController
 * @Description TODO 手机号三次 发送验证码那里
 * @Author 孙若飞
 * @Date 2019/3/6  22:51
 * @Version 1.0
 **/
@Controller
public class NoteController {
    @Autowired
    UserService userService;
    @Autowired
    NoteService noteService;
    @Autowired
    NoteUtil noteUtil;
    @Autowired
    AliUtil aliUtil;
    @Autowired
    TengXunUtil tengXunUtil;

    Logger log = Logger.getLogger(NoteController.class);

    @RequestMapping(value = "/p/get", method = RequestMethod.GET)
    public String getCode() {
        return "/one/code";
    }

    @RequestMapping(value = "/getPhone", method = RequestMethod.POST)
    public String getCode(String phone) {
        log.info("看看宝贝的手机号==========" + phone);
        //当天开始的时间和当天结束的时间
        long current = System.currentTimeMillis();
        long dayStart = (current / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset()) + 86400000;
        long dayEnd = dayStart + 24 * 60 * 60 * 1000 - 1;
        //统计小于等于当天结束时间的时间戳
        int number = noteService.selectTime(dayStart, dayEnd,Long.valueOf(phone));
        //如果一个手机号获取验证码超过3次,则不能发送验证码,返回首页
        if (number >= 3) {
            return "home";
        } else {
            //获取随机数,当验证码的内容
            //把验证码存到数据库中
            //发送验证码
            long code = randomCode();
            log.info("code and phone====" + code + "" + phone);
            long result = noteService.insertCodePhone(code, Long.valueOf(phone), current);
            log.info("result====" + result);

            String sendResult = noteUtil.setNote(String.valueOf(code), String.valueOf(phone));
            log.info("sendResult====" + sendResult);
            return "one/registerPhone";
        }
    }

    //生成四位随机数,并将手机号和验证码插入
    public long randomCode() {
        Random random = new Random();
        long code = 1000 + random.nextInt(8999);
        log.info("验证码是多少啊=========" + code);
        return code;
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String insert(User user, MultipartFile multipartFile, HttpServletResponse response) throws IOException {
        log.info("============" + user);
        log.info("图片" + multipartFile);
        //先判空
        if (!ObjectUtils.isEmpty(user)
                && !ObjectUtils.isEmpty(user.getName())
                && !ObjectUtils.isEmpty(user.getPassword())
                && !ObjectUtils.isEmpty(user.getPhone())
                && !ObjectUtils.isEmpty(user.getCode())
                && !ObjectUtils.isEmpty(user.getMail())
                && !ObjectUtils.isEmpty(multipartFile)
                ) {
            //看数据库里没有有这个用户名,如果有则返回注册页面
            User userName = userService.selectByName(user.getName());
            log.info("用户名是=========" + userName);
            if (!ObjectUtils.isEmpty(userName)) {
                log.info("用户名已经存在");
                return "one/registerPhone";
            } else {

                //通过注册时提交的手机号和验证码去另一张Note表里查手机号和验证码,
                log.info("验证码是=====" + user.getCode());
                User userCodePhone = userService.selectCodePhone(user.getCode(), user.getPhone());
                log.info("手机号和验证码是============" + userCodePhone);
                if (ObjectUtils.isEmpty(userCodePhone)) {
                    log.info("手机号和验证码不匹配,跳到获取验证码的页面");
                    return "one/code";
                } else {

                    String key = user.getName() + ".jpg";
                    //上传图片
                    //用multipartFile接收到传进来的文件,调用工具类
                    log.info("key是========" + key);

                    //将multiPartFile格式转化为file
                    CommonsMultipartFile cf = (CommonsMultipartFile) multipartFile;
                    DiskFileItem fi = (DiskFileItem) cf.getFileItem();
                    File file = fi.getStoreLocation();

                    boolean state = tengXunUtil.image(key, file);
                    log.info("图片上传成功了吗?" + state);
                    log.info("手机号和验证码匹配,可以插入这条数据,即注册成功");
                    //给密码使用md5加密,然后把id当盐加入
                    user.setPassword(MD5Util.MD5(user.getPassword() + user.getId()));
                    log.info("看一下加密后的效果======" + user);
                    boolean sate = userService.insert(user);
                    log.info("是否插入=========" + sate);
                    log.info("user id is " + user.getId());
                    //插入以后给用户发一个token,token,由当前时间,用户名,用户ID组成使用DES加密
                    String token = DESUtil.encrypt(System.currentTimeMillis() + "|" + user.getName() + "|" + user.getId());
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
        return "one/registerPhone";
    }

    @RequestMapping(value = "p/login", method = RequestMethod.GET)
    public String loginPage() {
        return "one/loginPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, HttpServletResponse response) throws UnsupportedEncodingException {
        if (!ObjectUtils.isEmpty(user.getName())
                && !ObjectUtils.isEmpty(user.getPassword())
                ) {
            //密码加密
            user.setPassword(MD5Util.MD5(user.getPassword() + user.getId()));
            log.info("加密后" + user);
            //这里有问题
            User state = userService.selectByCondition(user.getName(), user.getPassword());
            log.info("state is " + state);
            if (ObjectUtils.isEmpty(state)
                    ) {
                //发一个token
                //DES加密
                String token = DESUtil.encrypt(System.currentTimeMillis() + "|" + user.getName() + "|" + user.getId());
                log.info("token=============" + token);
                Cookie cookie = new Cookie("token", token);
                cookie.setMaxAge(30 * 60);
                log.info("tokenName=========" + cookie.getName());
                log.info("tokenValue============" + cookie.getValue());
                response.addCookie(cookie);
                log.info("看看保存了没有");
                return "home";
            } else {
                log.info("无此用户,去注册============");
                return "one/registerPhone";
            }
        }
        log.info("参数为空");
        return "one/loginPage";
    }

}
