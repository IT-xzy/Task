package com.jnshu.controller;

import com.jnshu.pojo.User;
import com.jnshu.pojo.tool.AliyunOss;
import com.jnshu.pojo.tool.Cos;
import com.jnshu.pojo.tool.DesUtil;
import com.jnshu.pojo.tool.Md5Util;
import com.jnshu.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @Autowired
    UserService userService;

    @Autowired
    AliyunOss aliyunOss;

    @Autowired
    Cos cos;

    //跳转页面
    @RequestMapping(value = "/goRegister", method = RequestMethod.GET)
    public String register() {
        logger.info("进入注册页面");
        return "register";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String insert(User user, HttpServletResponse response, String msgCode) throws IOException {
        String phone = user.getPhone();
        logger.info("新注册用户信息：" + user);
        //对传进来的参数进行判空
        if (!ObjectUtils.isEmpty(user.getName()) && !ObjectUtils.isEmpty(user.getPassword())) {
            if (msgCode == null) {
                logger.info("请输出短信验证码");
                return "register";
            }
            //比对验证码是否一致 0为一致
            else if (userService.checkPhoneCode(phone, msgCode) == 0){
                //注册时,先根据用户名查,如果查不出,说明数据库里没有这条数据则插入,否则返回注册页面
                List<User> userName = userService.selectByName(user.getName());
                logger.info("用户名是："+userName);
                if (ObjectUtils.isEmpty(userName)){
                    //插入时，使用MD5给密码加密加盐
                    user.setPassword(Md5Util.MD5(user.getPassword()+user.getId()));
                    logger.info("加密后的密码："+user.getPassword());
                    user.setPhone(phone);
                    int regist = userService.insert(user);
                    String token = DesUtil.encrypt(System.currentTimeMillis()+"|"+user.getName()+"|"+user.getId());
                    logger.info("token："+token);
                    Cookie cookie = new Cookie("token",token);
                    cookie.setMaxAge(60*60);
                    logger.info("tokenName："+cookie.getName());
                    logger.info("tokenValue"+cookie.getValue());
                    response.addCookie(cookie);
                    return "login";
                }else{
                    logger.info("用户名已存在");
                    return "redirect:/goRegister";
                }
            }
            logger.info("验证错误");
            return "redirect:/goRegister";
        }
        logger.info("数据为空");
        return "redirect:/goRegister";
    }

    @RequestMapping(value = "/register/email", method = RequestMethod.POST)
    public String registByEmail(User user, HttpServletResponse response, String msgCode) throws Exception {
        String email = user.getEmail();
        logger.info("新注册用户信息：" + user);
        //对传进来的参数进行判空
        if (!ObjectUtils.isEmpty(user.getName()) && !ObjectUtils.isEmpty(user.getPassword())) {
            if (msgCode == null) {
                logger.info("请输出邮箱验证码");
                return "register";
            } else if (userService.cheakEmail(email, msgCode) == 0) {
                //注册时,先根据用户名查,如果查不出,说明数据库里没有这条数据则插入,否则返回注册页面
                List<User> userName = userService.selectByName(user.getName());
                logger.info("用户名是："+userName);
                if (ObjectUtils.isEmpty(userName)){
                    //插入时，使用MD5给密码加密加盐
                    user.setPassword(Md5Util.MD5(user.getPassword()+user.getId()));
                    logger.info("加密后的密码："+user.getPassword());
                    user.setEmail(email);
                    int regist = userService.insert(user);
                    String token = DesUtil.encrypt(System.currentTimeMillis()+"|"+user.getName()+"|"+user.getId());
                    logger.info("token："+token);
                    Cookie cookie = new Cookie("token",token);
                    cookie.setMaxAge(60*60);
                    logger.info("tokenName："+cookie.getName());
                    logger.info("tokenValue"+cookie.getValue());
                    response.addCookie(cookie);
                    return "login";
                }else{
                    logger.info("用户名已存在");
                    return "redirect:/goRegister";
                }
            }
            logger.info("验证错误");
            return "redirect:/goRegister";
        }
        logger.info("数据为空");
        return "redirect:/goRegister";
    }


    @RequestMapping(value ="/goLogin",method = RequestMethod.GET)
    public String loginIn(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(User user , HttpServletResponse response, String name) throws UnsupportedEncodingException {
        ModelAndView mav = new ModelAndView("home");
        logger.info("user:"+user);
        if (name.contains("@")) {
            logger.info("邮箱登录：" + name);
            user = userService.selectByEmail(name);
            logger.info("邮箱登录的user：" + user);
            if (!ObjectUtils.isEmpty(name)) {
                logger.info("查出的数据：" + name);
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
        else if (name.length() == 11 && StringUtils.isNumeric(name)) {
            logger.info("手机号登录："+ name);
            user = userService.selectByPhone(name);
            logger.info("手机号登录的user：" + user);
            if (!ObjectUtils.isEmpty(name)) {
                logger.info("查出的数据：" + name);
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
        else if (!ObjectUtils.isEmpty(user.getName()) && !ObjectUtils.isEmpty(user.getPassword())) {
            //密码加密加盐,然后用密码和用户名与数据库里的数据对比
            user.setPassword(Md5Util.MD5(user.getPassword() + user.getId()));
            logger.info("加密后的user:"+user);
            //对比一下传进来的和数据库里的是否一致
            List<User> user1 = userService.selectByNameAndPassword(user.getName(),user.getPassword());
            if (!ObjectUtils.isEmpty(user1)) {
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

    /**
     * 发送手机验证码
     * @param phone
     * @return 1：发送成功 2:发送过于频繁 3：超过每天最大次数 0：其他
     */
    @ResponseBody
    @RequestMapping(value = "/phone", method = RequestMethod.POST, produces = "text/xml;charset=UTF-8")
    public String phoneCode (String phone){
        logger.info("注册的手机号:"+ phone);
        // 为测试方便 验证码固定为111111
        String msgCode = "111111";
        logger.info("验证码：" + msgCode);
        int status = userService.sendPhone(phone, msgCode);
        logger.info("手机的状态:"+ status);
        String message = null;
        if (status == 0) {
            message = "验证码发送成功";
        }
        if (status == 1) {
            message = "请稍后再试";
        }
        if (status == 2) {
            message = "发送过于频繁";
        }
        if (status == 3) {
            message = "超过每天最大次数";
        }
        logger.info("手机验证码的信息:"+ message);
        return message;
    }

    /**
     * 发送邮箱验证码
     * @param email
     * @return  发送成功（状态为0），发送失败(状态为1），默认发送失败
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/email",method = RequestMethod.POST,produces = "text/xml;charset=UTF-8")
    public String emailCode(String email) throws IOException {
        logger.info("使用邮箱注册："+email);
        //生成随机验证码
        //String msgCode = DataUtils.getNumber(6);
        // 为测试方便 验证码固定为111111
        String msgCode = "222222";
        logger.info("验证码："+msgCode);
        int status = userService.sendEmail(email,msgCode);
        logger.info("email-status:"+status);
        String message = null;
        if(status == 0){
            message = "验证码发送成功";
        }
        if(status == 1){
            message = "邮箱格式不正确";
        }
        return message;
    }


}
