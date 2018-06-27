package com.ev.controller;

import com.ev.entity.User;
import com.ev.exception.CustomException;
import com.ev.exception.WrongPasswordException;
import com.ev.manager.RedisCache;
import com.ev.rmi.Distributor;
import com.ev.service.UserService;
import com.ev.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Controller
public class UserController {

    @Autowired
    private Distributor rmiServer;

    @Autowired
    private RedisCache redisCache;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin() throws Exception {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(HttpServletResponse response,
                          @RequestParam(value = "account") String account,
                          @RequestParam(value = "password") String password) throws Exception {
        UserService userService=rmiServer.getUserService();
        String resultPage;
        int expireMinutes = 30;
        if (userService.login(account, password)) {
            resultPage = "studentList";
            String token = (new JWTUtil()).createToken("msy", expireMinutes);
            Cookie cookie = new Cookie("mytoken", token);
            cookie.setMaxAge(expireMinutes * 60);
            response.addCookie(cookie);
            response.setContentType("text/html;charset=UTF-8");
            return resultPage;
        } else {
            throw new WrongPasswordException("Wrong account or password!");
        }
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String getSignUp(@RequestParam(value = "phoneNumber") String phoneNumber) throws Exception {
        // TODO: 2018/5/15 防止别人恶意刷短信：
        // 1、一分钟内只能发一次（extra：页面按钮倒计时，后台缓存上次该号码的发送时间）
        // 2、（不成熟）t时间内超过n次，暂时关闭短信功能
//        userService.getSmsCode(phoneNumber);
        // TODO: 2018/5/15 判断返回值是否发送成功
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String doSignUp(User user) throws Exception {
        UserService userService=rmiServer.getUserService();
        try {
            Long time = System.currentTimeMillis();
            user.setUpdateAt(time);
            user.setCreateAt(time);
            if (userService.signUp(user) < 0) {
                throw new CustomException("短信验证码错误");
            }
        } catch (CustomException e) {
            e.setMessage("注册失败");
        }
        return "login";
    }

    @RequestMapping(value = "/authMailCode", method = RequestMethod.GET)
    public String mailAuth(HttpServletRequest request, Model model) throws Exception {
        UserService userService=rmiServer.getUserService();
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        try {
            if (redisCache.getString(email).toString().equals(code)) {
                model.addAttribute("message", "验证成功。");
                User user = userService.findUser(email);
                user.setStatus(1);
                userService.setStatus(user);
            } else {
                model.addAttribute("message", "验证失败。");
            }
        }catch (NullPointerException e){
            model.addAttribute("message", "验证码已过期。");
        }
        return "mailAuth";
    }

    @RequestMapping(value = "/smsAuthCode", method = RequestMethod.GET)
    public String smsAuth() throws Exception {
        return "authCode";
    }
    @RequestMapping(value = "/forgetpassword", method = RequestMethod.GET)
    public String getForgetPasswordPage() throws Exception {
        return "forgetPassword";
    }

    @RequestMapping(value = "/forgetpassword", method = RequestMethod.POST)
    public String doForgetPasswordPage() throws Exception {
        return "redirect:login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("mytoken")) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        return "redirect:home";
    }

    @RequestMapping(value = "/avater", method = RequestMethod.GET)
    public String File() {
        return "avatar";
    }

    @RequestMapping(value = "/avatar", method = RequestMethod.POST)
    public String uploadAvatar(MultipartFile file, HttpServletRequest request) throws Exception {
        UserService userService=rmiServer.getUserService();
        if (file == null) {
            throw new CustomException("文件发送失败");
        }
        String userName = (String) request.getSession().getAttribute("name");
        String imgUrl = userService.uploadAvatar(file, userName);
        return "success";
    }
}
