package com.ptteng.controller;

import com.ptteng.pojo.exception.ForbiddenException;
import com.ptteng.pojo.exception.UnacceptableException;
import com.ptteng.pojo.exception.UnavailableException;
import com.ptteng.pojo.model.Email;
import com.ptteng.pojo.model.Login;
import com.ptteng.pojo.model.User;
import com.ptteng.rmi.Distributor;
import com.ptteng.service.LoginService;
import com.ptteng.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

//加了这个就不需要显式实现接口了
@Controller
@RequestMapping(value = "/a")
// TODO 对于一些高频率发生的业务错误，最好别用异常来处理，会导致性能下降，最好分支判断后直接返回json数据，这个项目我就偷下懒
public class LoginController {
    @Autowired
    private Distributor rmiServer;
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login.page";
    }

    @RequestMapping(value = "/sigin", method = RequestMethod.GET)
    public String register() {
        return "sigin.page";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response, Login login) throws Exception {
        LoginService loginService = rmiServer.getLoginService();
        login.setIp(IPUtil.getIP(request));
        if (logger.isDebugEnabled()) {
            logger.debug("登录接收参数:" + login);
        }
        //获取返回的token
        Map<String, String> map = loginService.checkLogin(login);
        String token = map.get("token");
        String name = map.get("name");
        //考虑到日志文件有可能被窃取，可以不打密码
        if (logger.isInfoEnabled()) {
            logger.info("登录信息： 用户名：" + name + "  用户密码：" + login.getKey() + "  登录时间："
                    + DateUtil.longToString(System.currentTimeMillis(), "yyyy年MM月dd日 HH时mm分ss秒"));
        }
        //必须设置，不然半小时左右就过期了
        request.getSession().setMaxInactiveInterval(60 * 60 * 3);
        request.getSession().setAttribute("name", name);
        //然后添加cookie,注意顺序(其实这里token不需要由Login加密生成，加密一个ip的String对象就行了)
        CookieUtil.addTokenCookie(response, token);
        return "success";
    }


    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Object name = request.getSession().getAttribute("name");
        if (name == null) {
            return "login.page";
        }
        if (logger.isInfoEnabled()) {
            logger.info("登出信息： 用户名：" + name
                    + "  登出时间：" + DateUtil.longToString(System.currentTimeMillis(), "yyyy年MM月dd日 HH时mm分ss秒"));
        }
        CookieUtil.clearTokenCookie(response);
        request.getSession().removeAttribute("name");
        return "login.page";
    }


    /*返回结果详情见异常处理器类（com.ptteng.manager.ExceptionResolver）*/
    @RequestMapping(value = "/cellphone/code")
    public String PhoneCodeShake(HttpServletRequest request, User user) throws Exception {
        LoginService loginService = rmiServer.getLoginService();
        if (logger.isDebugEnabled()) {
            logger.debug("手机验证码端口接收参数:" + user);
        }
        String ip = IPUtil.getIP(request);
        String phoneCode = loginService.sendPhoneCode(user, ip);
        //往session里面添加数据
        HttpSession session = request.getSession();
        session.setAttribute("phoneCode", phoneCode);
        session.setAttribute("userName", user.getUserName());
        session.setAttribute("cellphone", user.getCellphone());
        //十分钟过后该验证码失效
        final Timer timer = new Timer();
        try {
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    session.removeAttribute("phoneCode");
                    session.removeAttribute("userName");
                    session.removeAttribute("cellphone");
                    timer.cancel();
                }
            }, 10 * 60 * 1000);
        } catch (Exception e) {
            throw new UnavailableException("移除验证码信息失败");
        }
        return "success";
    }

    /*返回结果详情见异常处理器类（com.ptteng.manager.ExceptionResolver）*/
    @RequestMapping(value = "/cellphone/check")
    public String phoneCodeCheck(HttpSession session, String cellphone, String userName, String phoneCode) {
        if (logger.isDebugEnabled()) {
            logger.debug("手机注册端口接收参数:"
                    + " cellphone: " + cellphone + " userName: " + userName + " phoneCode: " + phoneCode);
        }
        if (cellphone == null || userName == null || phoneCode == null) {
            throw new UnacceptableException("无效注册表单");
        }
        String phoneCode2 = (String) session.getAttribute("phoneCode");
        String cellphone2 = (String) session.getAttribute("cellphone");
        String userName2 = (String) session.getAttribute("userName");
        if (phoneCode2 == null || cellphone2 == null || userName2 == null) {
            throw new UnacceptableException("验证码过期，请重新发送");
        }
        if (phoneCode.equals(phoneCode2) && userName.equals(userName2) && cellphone.equals(cellphone2)) {
            return "success";
        }
        throw new UnacceptableException("验证码与账号信息不匹配");
    }

    @RequestMapping(value = "/sign/cellphone", method = RequestMethod.POST)
    public String registerByCellphone(HttpSession session, User user) throws Exception {
        LoginService loginService = rmiServer.getLoginService();
        if (logger.isDebugEnabled()) {
            logger.debug("注册接收参数:" + user);
        }
        //重新检测该会话是否含有合法的手机注册验证码
        String phoneCode = (String) session.getAttribute("phoneCode");
        String cellphone = (String) session.getAttribute("cellphone");
        String userName = (String) session.getAttribute("userName");
        if (phoneCode == null || cellphone == null || userName == null) {
            throw new ForbiddenException("非法的注册请求,用户名：" + user.getUserName());
        }
        Long id = loginService.registerByPhone(user);
        if (logger.isInfoEnabled()) {
            logger.info("手机注册成功，注册信息： 用户名：" + user.getUserName() + " id： " + id +
                    "  注册时间：" + DateUtil.longToString(System.currentTimeMillis(), "yyyy年MM月dd日 HH时mm分ss秒"));
        }
        //销毁之前的注册信息
        session.removeAttribute("phoneCode");
        session.removeAttribute("userName");
        session.removeAttribute("cellphone");
        return "redirect:/a/login";
    }

    /*返回结果详情见异常处理器类（com.ptteng.manager.ExceptionResolver）*/
    @RequestMapping(value = "/mail/check")
    public String checkSigningMail(User user) throws Exception {
        LoginService loginService = rmiServer.getLoginService();
        loginService.checkSigningMail(user);
        return "success";
    }

    /*返回结果详情见异常处理器类（com.ptteng.manager.ExceptionResolver）*/
    @RequestMapping(value = "/mail/link")
    public String sendActivateMail(HttpServletRequest request, Email email) throws Exception {
        LoginService loginService = rmiServer.getLoginService();
        if (logger.isDebugEnabled()) {
            logger.debug("邮件注册端口接收参数:" + email);
        }
        String ip = IPUtil.getIP(request);
        email.setIp(ip);
        String basePath = IPUtil.getBasePath(request);
        String envId = loginService.sendActivateMail(email, basePath);
        if (logger.isInfoEnabled()) {
            logger.info("成功发送一封注册邮件，注册邮箱：" + email.getMailbox() + "，流水单号：" + envId);
        }
        return "success";
    }

    @RequestMapping(value = "/mail/success")
    public String afterSendMail() {
        //成功发送完邮件后回显的页面，我懒得做了，就这样子吧
        return "success";
    }

    /*返回结果详情见异常处理器类（com.ptteng.manager.ExceptionResolver）*/
    @RequestMapping(value = "/mail/activation")
    public String registerByMail(HttpServletRequest request, String token) throws Exception {
        LoginService loginService = rmiServer.getLoginService();
        String ip = IPUtil.getIP(request);
        User user = loginService.registerByMail(token, ip);
        //懒得写成功页面，错误页面了，直接跳转到登录页面吧！
        if (logger.isInfoEnabled()) {
            logger.info("邮箱注册成功，注册信息： 用户名：" + user.getUserName() + " id： " + user.getId() +
                    "  注册时间：" + DateUtil.longToString(System.currentTimeMillis(), "yyyy年MM月dd日 HH时mm分ss秒"));
        }
        return "redirect:/a/login";
    }
}
