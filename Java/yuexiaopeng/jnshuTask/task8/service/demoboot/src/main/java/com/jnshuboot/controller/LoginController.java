package com.jnshuboot.controller;

import com.jnshuboot.pojo.Login;
import com.jnshuboot.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String homeLogin(@ModelAttribute("login") Login login) {
        login.setLoginName("haha");
        return "login";
    }

    //任何账号登录；
    @RequestMapping("/login/u/login")
    public String logining(@ModelAttribute("login") Login login,
                           Model model) {
        boolean boo = loginService.logining(login);
        if (!boo) {
//            model.addAttribute("login",login);
//            model.addAttribute("status","账号或密码错误");
            String status = "账号或密码错误";
            model.addAttribute("status", status);
            return "login";
        }
        return "success";
    }

    //通用账号注册；
    @RequestMapping("/login/u/register/a")
    public String registerAccount(@ModelAttribute("login") Login login,
                                  Model model) {
        int i = loginService.register(login);
        if (i <= 0) {
            //model.addAttribute("login",login);
            if (login.getLoginAccount() != null) {
                String status = "注册账号或密码格式错误";
                model.addAttribute("status", status);
            }
            return "registerAccount";
        }
        return "success";
    }

    //手机发送验证码；
    @RequestMapping("/login/u/register/mb")
    public String registerMobile(@ModelAttribute("login") Login login,
                                 HttpSession session,
                                 Model model) {
        String tip = "暂时只支持11位中国区手机号码";
        if (login.getLoginMobile() != null) {
            String mobileCode = loginService.verifyMobile(login.getLoginMobile());
            //错误，返回同页面
            tip = "验证码已发送";
            if (mobileCode.equals("-2500")) {
                //手机号格式不正确；
                tip = "手机号输入错误，请重新输入";
            }
            //正确情况；
            model.addAttribute("tip", tip);
            session.setAttribute("mobileCode", mobileCode);
            return "registerMobile";
        }
        //没有任何值过来
        model.addAttribute("tip", tip);
        return "registerMobile";
    }

    //提交手机及相关信息进行注册
    @RequestMapping("/login/u/register/mbing")
    public String registerMobileing(@ModelAttribute("login") Login login,//用户提交的账户信息
                                    @ModelAttribute("loginCode") String loginCode,//用户提交的手机验证码
                                    Model model,//用户提交的
                                    HttpSession session) {
        String status = "验证码错误";
        String mobileCode = (String) session.getAttribute("mobileCode");
        if (mobileCode != null && loginCode != null) {
            if (mobileCode.equals(loginCode)) {
                int i = loginService.register(login);
                //注册失败，返回同页面
                if (i < 0) {
                    //注册失败；
                    status = "密码格式错误或手机号已存在";
                    model.addAttribute("status", status);
                    return "registerMobile";
                }
                //正确进入success页面；
                return "success";
            }
        }
        //验证码错误；
        model.addAttribute("status", status);
        return "registerMobile";
    }

    //邮箱发送验证码；
    @RequestMapping("/login/u/register/ma")
    public String registerMail(@ModelAttribute("login") Login login,
                               HttpSession session, Model model) {
        String tip = "请输入有效的邮箱";
//        log.info(login);
        if (login.getLoginMail() != null) {
            String mailCode = loginService.verifyMail(login.getLoginMail());
            //错误，返回同页面
            tip = "邮箱验证码已发送";
            if (mailCode.equals("-3000")) {
                //邮箱号格式不正确；
                tip = "邮箱输入错误，请重新输入";
            }
            //正确情况；
            model.addAttribute("tip", tip);
            session.setAttribute("mailCode", mailCode);
            return "registerMail";
        }
        //没有任何值过来
        model.addAttribute("tip", tip);
        return "registerMail";
    }

    //提交手机及相关信息进行注册
    @RequestMapping("/login/u/register/maing")
    public String registerMailing(@ModelAttribute("login") Login login,
                                  @ModelAttribute("loginCode") String loginCode,
                                  HttpSession session, Model model) {
        String status = "邮箱验证码错误";
        String mailCode = (String) session.getAttribute("mailCode");
        if (mailCode != null && loginCode != null) {
            if (session.getAttribute("mailCode").equals(loginCode)) {
                int i = loginService.register(login);
                //注册失败，返回同页面
                if (i < 0) {
                    //注册失败；
                    status = "密码格式错误或账号已存在";
                    model.addAttribute("status", status);
                    return "registerMail";
                }
                //正确进入success页面；
                return "success";
            }
        }
        //验证码错误；
        model.addAttribute("status", status);
        return "registerMail";
    }
}
