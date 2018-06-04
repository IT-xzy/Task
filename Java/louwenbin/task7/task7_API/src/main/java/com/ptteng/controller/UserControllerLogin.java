package com.ptteng.controller;

import com.aliyuncs.exceptions.ClientException;
import com.ptteng.entity.UserLogin;
import com.ptteng.service.Impl.UserServiceImplLogin;
import com.ptteng.utils.aliyunAPI.HelloOSS;
import com.ptteng.utils.aliyunAPI.ReceiveDemo;
import com.ptteng.utils.aliyunAPI.SMSSend;
import com.ptteng.utils.encrypt.DesUtil;
import com.ptteng.utils.interceptor.LoginInterceptor;
import com.ptteng.utils.md5.MD5Util;
import com.ptteng.utils.strategy.concreteStrategy.Context;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

@Controller
public class UserControllerLogin {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    @Resource
    private UserServiceImplLogin userServiceImplLogin;
    private static final String SKEY = "12345678";
    private static final Charset CHARSET = Charset.forName("gb2312");
    @Resource
    private SMSSend smsSend;
    @Resource
    private ReceiveDemo receiveDemo;
    @Resource
    private HelloOSS helloOSS;
    @Resource
    private Context context;
    int emailFrequency = 0;
    int phoneFrequency = 0;

    @RequestMapping(value = "/regi", method = RequestMethod.GET)
    public String toInsertUser() {
        return "no/regi";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String insertUser(UserLogin user, Model model) {
        String account = user.getAccount();
        String password = user.getPassword();
        UserLogin userDB = userServiceImplLogin.selectUserLogin(account);
        int code = userDB.getCode();
        logger.info("for DB :code..........." + code);
        if (userDB != null) {
            model.addAttribute("返回通知", "用户名已存在");
            return "/regi";
        } else if (!("".equals(password))) {
            int salt = (int) ((Math.random() * 9 + 1) * 100000);
            password = MD5Util.MD5(password + salt);
            user.setPassword(password);
            user.setSalt(salt);
            userServiceImplLogin.insertUserLogin(user);
            model.addAttribute("返回通知", "注册成功,请登陆");
            return "/login";
        } else {
            model.addAttribute("返回通知", "密码不能为空");
            return "/register_phone";
        }
    }

    @RequestMapping(value = "/verifyPhone", method = RequestMethod.GET)
    public String VerifyPhone() {
        return "register_phone";
    }

    @RequestMapping(value = "/verifyPhoneCode", method = RequestMethod.GET)
    public void verifyPhoneCode(HttpServletRequest request, HttpServletResponse response, UserLogin user) throws ClientException {
        logger.info("....................手机验证......................");
        HttpSession session = request.getSession();
        Long nowTime = System.currentTimeMillis();
        String phone = request.getParameter("phoneNum");
        if (session.getAttribute(phone) == null) {
            request.getSession().setAttribute(phone, phoneFrequency);
            session.setMaxInactiveInterval(60 * 60 * 24);//设置单位为秒，设置为-1永不过期;
        }
        phoneFrequency = (int) session.getAttribute(phone);
        if (phoneFrequency > 3) {
            logger.info("本号码发送超过3次");
        } else {
            Long sendPhoneTime = (Long) session.getAttribute("sendPhoneTime");
            if (sendPhoneTime != null) {
                if ((nowTime - sendPhoneTime) < 6000) {
                    logger.info("时间不足，距上次发送：\t" + (nowTime - sendPhoneTime) / 1000 + "s");
                } else {
                    logger.info("可以发送，距上次发送：\t" + (nowTime - sendPhoneTime) / 1000 + "s");
                    int code = (int) ((Math.random() * 9 + 1) * 100000);
                    response.setContentType("text/html;charset=utf-8");
                    smsSend.send(phone, code);
                    session.removeAttribute("sendPhoneTime");
                    logger.info("发送成功");
                    phoneFrequency++;
                    request.getSession().setAttribute(phone, phoneFrequency);
                    request.getSession().setAttribute("sendPhoneTime", System.currentTimeMillis());
                    request.getSession().setAttribute("phone" + phone, phone);
                    request.getSession().setAttribute("code" + phone, String.valueOf(code));
                    request.getSession().setAttribute("time" + phone, System.currentTimeMillis());
                    logger.info("存入session");
                }
            } else {
                logger.info("无cookie");
                int code = (int) ((Math.random() * 9 + 1) * 100000);
                response.setContentType("text/html;charset=utf-8");
                smsSend.send(phone, code);
                session.removeAttribute("sendPhoneTime");
                logger.info("发送成功");
                phoneFrequency++;
                request.getSession().setAttribute(phone, phoneFrequency);
                request.getSession().setAttribute("sendPhoneTime", System.currentTimeMillis());
                request.getSession().setAttribute("phone" + phone, phone);
                request.getSession().setAttribute("code" + phone, String.valueOf(code));
                request.getSession().setAttribute("time" + phone, System.currentTimeMillis());
                logger.info("存入session");
            }
        }
    }

    @RequestMapping(value = "/register/phone", method = RequestMethod.POST)
    public String insertUser(HttpServletRequest request, UserLogin user, Model model) {
        String account = user.getAccount();
        String password = user.getPassword();
        String phone = user.getPhone();
        String code = String.valueOf(user.getCode());
        HttpSession session = request.getSession();
        String codeSession = (String) session.getAttribute("code" + phone);
        String phoneSession = (String) session.getAttribute("phone" + phone);
        Long time = (Long) session.getAttribute("time" + phone);
        if (codeSession == null || codeSession.trim().equals("")) {
            model.addAttribute("返回通知", "验证码不存在");
            return "register_phone";
        }
        //验证码10分钟有效
        if ((System.currentTimeMillis() - time) / 1000 / 60 >= 10) {
            model.addAttribute("返回通知", "验证码已过期");
            return "register_phone";
        }
        //发送验证码的邮箱与登陆时提交的邮箱不一致
        if (!phoneSession.trim().equalsIgnoreCase(phone)) {
            model.addAttribute("返回通知", "手机号码不一致");
            return "register_phone";
        }
        UserLogin userDB = userServiceImplLogin.selectUserLogin(account);
        if (codeSession.trim().equalsIgnoreCase(code)) {
            if (userDB != null) {
                model.addAttribute("返回通知", "用户名已存在");
                return "register_phone";
            } else if (!("".equals(password))) {
                int salt = (int) ((Math.random() * 9 + 1) * 100000);
                password = MD5Util.MD5(password + salt);
                user.setPassword(password);
                user.setSalt(salt);
                userServiceImplLogin.insertUserLoginPhoneCode(user);
                model.addAttribute("返回通知", "注册成功,请登陆");
                session.removeAttribute("code" + phone);
                session.removeAttribute("phone" + phone);
                session.removeAttribute("time" + phone);
                return "/login";
            } else {
                model.addAttribute("返回通知", "密码不能为空");
                return "register_phone";
            }
        } else {
            model.addAttribute("返回通知", "验证码错误");
            return "register_phone";
        }
    }

    @RequestMapping(value = "/verifyEmail", method = RequestMethod.GET)
    public String VerifyEmail() {
        return "register_email";
    }

    //邮箱验证
    @RequestMapping(value = "/verifyEmailCode", method = RequestMethod.GET)
    public void verifyEmailCode(HttpServletRequest request, HttpServletResponse response, UserLogin user) throws IOException {
        logger.info("....................邮箱验证....................");
        HttpSession session = request.getSession();
        Long nowTime = System.currentTimeMillis();
        String email = request.getParameter("emailNum");
        if (session.getAttribute(email) == null) {
            request.getSession().setAttribute(email, emailFrequency);
            session.setMaxInactiveInterval(60 * 60 * 24);//设置单位为秒，设置为-1永不过期;
        }
        emailFrequency = (int) session.getAttribute(email);
        if (emailFrequency > 3) {
            logger.info("本号码发送超过3次");
        } else {
            Long sendEmailTime = (Long) session.getAttribute("sendEmailTime");
            if (sendEmailTime != null) {
                if ((nowTime - sendEmailTime) < 6000) {
                    logger.info("时间不足，距上次发送：\t" + (nowTime - sendEmailTime) / 1000 + "s");
                } else {
                    logger.info("可以发送，距上次发送：\t" + (nowTime - sendEmailTime) / 1000 + "s");
                    int code = (int) ((Math.random() * 9 + 1) * 100000);
                    response.setContentType("text/html;charset=utf-8");
                    receiveDemo.sample(email, code);
                    session.removeAttribute("sendEmailTime");
                    logger.info("发送成功");
                    emailFrequency++;
                    request.getSession().setAttribute(email, emailFrequency);
                    request.getSession().setAttribute("sendEmailTime", System.currentTimeMillis());
                    request.getSession().setAttribute("email" + email, email);
                    request.getSession().setAttribute("code" + email, String.valueOf(code));
                    request.getSession().setAttribute("time" + email, System.currentTimeMillis());
                    logger.info("存入session");
                }
            } else {
                logger.info("无session");
                int code = (int) ((Math.random() * 9 + 1) * 100000);
                response.setContentType("text/html;charset=utf-8");
                receiveDemo.sample(email, code);
                session.removeAttribute("sendEmailTime");
                logger.info("发送成功");
                emailFrequency++;
                request.getSession().setAttribute(email, emailFrequency);
                request.getSession().setAttribute("sendEmailTime", System.currentTimeMillis());
                request.getSession().setAttribute("email" + email, email);
                request.getSession().setAttribute("code" + email, String.valueOf(code));
                request.getSession().setAttribute("time" + email, System.currentTimeMillis());
                logger.info("存入session");
            }
        }
    }

    @RequestMapping(value = "/register/email", method = RequestMethod.POST)
    public String email(UserLogin user, Model model, HttpServletResponse response, HttpServletRequest request) throws IOException {
        String account = user.getAccount();
        String password = user.getPassword();
        String email = user.getEmail();
        String code = String.valueOf(user.getCode());
        HttpSession session = request.getSession();
        String codeSession = (String) session.getAttribute("code" + email);
        String emailSession = (String) session.getAttribute("email" + email);
        Long time = (Long) session.getAttribute("time" + email);
        if (codeSession == null || codeSession.trim().equals("")) {
            model.addAttribute("返回通知", "验证码不存在");
            return "register_email";
        }
        //验证码10分钟有效
        if ((System.currentTimeMillis() - time) / 1000 / 60 >= 10) {
            model.addAttribute("返回通知", "验证码已过期");
            //response.sendRedirect("verifyEmail");
            return "register_email";
        }
        //发送验证码的邮箱与登陆时提交的邮箱不一致
        if (!emailSession.trim().equalsIgnoreCase(email)) {
            model.addAttribute("返回通知", "邮箱不一致");
            //response.sendRedirect("verifyEmail");
            return "register_email";
        }
        UserLogin userDB = userServiceImplLogin.selectUserLogin(account);
        if (codeSession.trim().equalsIgnoreCase(code)) {
            if (userDB != null) {
                model.addAttribute("返回通知", "用户名已存在");
                return "register_email";
            } else if (!("".equals(password))) {
                int salt = (int) ((Math.random() * 9 + 1) * 100000);
                password = MD5Util.MD5(password + salt);
                user.setAccount(account);
                user.setPassword(password);
                user.setSalt(salt);
                userServiceImplLogin.insertUserLoginEmailCode(user);
                model.addAttribute("返回通知", "注册成功,请登陆");
                session.removeAttribute("code" + email);
                session.removeAttribute("email" + email);
                session.removeAttribute("time" + email);
                return "/login";
            } else {
                model.addAttribute("返回通知", "密码不能为空");
                return "register_email";
            }
        } else {
            model.addAttribute("返回通知", "验证码错误");
            return "register_email";
        }
    }
    //@RequestMapping(value = "/notice", method = RequestMethod.GET)
    //public String notice() {
    //    return "notice";
    //}

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, UserLogin user, HttpServletResponse response) throws IOException {
        String account = user.getAccount();
        String password = user.getPassword();
        UserLogin userDB = userServiceImplLogin.selectUserLogin(account);
        //加密
        String accountDes = account + "|" + System.currentTimeMillis();
        String accountDesResult = DesUtil.encrypt(accountDes, CHARSET, SKEY);
        logger.info("password+userDB.getSalt():...." + MD5Util.MD5(password + userDB.getSalt()));
        logger.info("userDB.getPassword():....." + userDB.getPassword());
        if (userDB != null) {
            if (MD5Util.MD5(password + userDB.getSalt()).equals(userDB.getPassword())) {
                //创建cookie
                Cookie nameCookie = new Cookie("name", accountDesResult);
                nameCookie.setMaxAge(60 * 60 * 24);
                response.addCookie(nameCookie);
                String photoDB = userDB.getPhoto();
                if (photoDB == null) {
                    return "redirect:/u/verifyImage";
                }
                return "redirect:/u/t11";
            } else {
                model.addAttribute("返回通知", "账号或密码错误");
                return "/login";
            }
        } else {
            model.addAttribute("返回通知", "用户名不存在");
            return "/login";
        }
    }
    //@RequestMapping(value = "/u/uploadImage", method = RequestMethod.GET)
    //public String uploadImage() {
    //    return "no/uploadImage";
    //}

    @RequestMapping(value = "/u/verifyImage", method = RequestMethod.GET)
    public String VerifyImage() {
        return "register_image";
    }
    //@RequestMapping(value = "/u/qiniuImage", method = RequestMethod.GET)
    //public String qiniuImage() {
    //    return "no/qiniuImage";
    //}
    //@RequestMapping(value = "/qiniuImage", method = RequestMethod.POST)
    //public String upload(UserLogin user, HttpServletRequest request, @RequestParam("file") CommonsMultipartFile commonsMultipartFile) throws Exception {
    //    String loginCookieUserName;
    //    String cookieName = null;
    //    String time = null;
    //    Cookie[] cookies = request.getCookies();
    //    if (null != cookies) {
    //        for (Cookie cookie : cookies) {
    //            if ("name".equals(cookie.getName())) {
    //                loginCookieUserName = cookie.getValue();
    //                //进行解密
    //                loginCookieUserName = DesUtil.decrypt(loginCookieUserName, CHARSET, SKEY);
    //                String[] userParams = loginCookieUserName.split("\\|");
    //                cookieName = userParams[0];
    //                time = userParams[1];
    //            }
    //        }
    //    }
    //    File file = new File(String.valueOf(commonsMultipartFile.getOriginalFilename()));
    //    String fileName = file.getName();
    //    String prefix = fileName.substring(fileName.lastIndexOf("."));
    //    String name = time + prefix;
    //    user.setAccount(cookieName);
    //    user.setPhoto(name);
    //    userServiceImplLogin.updateUserLoginImage(user);
    //    System.out.println(".................key............" + name);
    //    qiNiuYunImage.upload(name, commonsMultipartFile.getInputStream());
    //    qiNiuYunImage.corsQiNiu();
    //    return "redirect:/u/t11";
    //}

    @RequestMapping(value = "/upImage", method = RequestMethod.POST)
    public String upDemo(UserLogin user, HttpServletRequest request, @RequestParam("file") CommonsMultipartFile commonsMultipartFile) throws Exception {
        String loginCookieUserName;
        String cookieName = null;
        String time = null;
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if ("name".equals(cookie.getName())) {
                    loginCookieUserName = cookie.getValue();
                    //进行解密
                    loginCookieUserName = DesUtil.decrypt(loginCookieUserName, CHARSET, SKEY);
                    String[] userParams = loginCookieUserName.split("\\|");
                    cookieName = userParams[0];
                    time = userParams[1];
                }
            }
        }
        File file = new File(String.valueOf(commonsMultipartFile.getOriginalFilename()));
        String fileName = file.getName();
        String prefix = fileName.substring(fileName.lastIndexOf("."));
        String name = time + prefix;
        user.setAccount(cookieName);
        user.setPhoto(name);
        //存储到数据库
        userServiceImplLogin.updateUserLoginImage(user);
        helloOSS.upImage(name, commonsMultipartFile.getInputStream());
        //策略模式
        context.operate(name, commonsMultipartFile.getInputStream());
        return "redirect:/u/t11";
    }
}
