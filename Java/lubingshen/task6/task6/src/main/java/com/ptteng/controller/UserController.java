package com.ptteng.controller;

import com.ptteng.pojo.model.User;
import com.ptteng.pojo.exception.StudentException;
import com.ptteng.service.UserService;
import com.ptteng.utils.DataCheckUtil;
import com.ptteng.utils.DateUtil;
import com.ptteng.utils.DesUtil;
import com.ptteng.utils.Md5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.Objects;

@Controller    //加了这个就不需要显式实现接口了
@RequestMapping(value = "/a")
public class UserController {
    @Autowired
    private UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String register() {
        return "registration";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
        //通过自定义标签+反射的方法检测数据合法性
        if (logger.isDebugEnabled()) {
            logger.debug("登录接收参数:" + user);
        }
        DataCheckUtil.check(user, DataCheckUtil.LOGIN);
        String userName = user.getUserName();
        String userKey = user.getUserKey();
        User result = userService.query(userName);
        //通过抛出自定义异常给前端适配器，然后分发给自定义异常处理器处理，最后反馈信息给用户
        if (result == null) {
            throw new StudentException("用户不存在，请注册后登陆");
        }
        DesUtil desUtil = new DesUtil("java");
        if (!Objects.equals(result.getUserKey(), Md5Util.getMd5(userKey))) {
            throw new StudentException("密码错误，请重新输入");
        }
        //重新加密cookie，重生成token
        long current = System.currentTimeMillis();
        //考虑到日志文件有可能被窃取，可以不打密码
        if (logger.isInfoEnabled()) {
            logger.info("登录信息： 用户名：" + userName + "  用户密码：" + userKey
                    + "  登录时间：" + DateUtil.longToString(current, "yyyy年MM月dd日 HH时mm分ss秒"));
        }
        result.setLoginAt(current);

        if (!userService.modify(result)) {
            throw new RuntimeException("未知原因，更新登录时间失败");
        }

        //中间加个","，方便spilt拆分
        String message = userName + "," + current;
        //加密，注意DES是需要解密的
        String token = desUtil.encrypt(message);
        Cookie cookie = new Cookie("Token", token);
        //设置为"/"时，全服务器都能访问到这个cookie。也可以具体化，使只能有一个webapp才能访问
        cookie.setPath("/");
        //存活时间，删除时设置为0即可（别忘记设置vaule为null）
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
        //更新数据库login_at,使之匹配,防御重放攻击
        userService.modify(result);
        /*使得只有本次session，此cookie才生效
        注意session关了浏览器才会关闭
        因为session的信息储存在服务器，下次重启浏览器时，session的信息(cookie)会发生变化（JSESSIONID）*/
        request.getSession().setAttribute("user", token);
        request.getSession().setAttribute("username", userName);
        //重定向回到主页
        return "redirect:/a/u/task2/student/list";
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String tryToRegister(User user) throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("注册接收参数:" + user);
        }
        DataCheckUtil.check(user, DataCheckUtil.REGISTER);
        /*加密，使得数据库和登录校核时，加密的规则和结果一致
        也能防止运营人员窃取用户信息*/
        String password = user.getUserKey();
        user.setUserKey(Md5Util.getMd5(user.getUserKey()));
        userService.register(user);
        if (logger.isInfoEnabled()) {
            logger.info("注册信息： 用户名：" + user.getUserName() + "  用户密码：" + password
                    + "  注册时间：" + DateUtil.longToString(System.currentTimeMillis(), "yyyy年MM月dd日 HH时mm分ss秒"));
        }
        return "redirect:login";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            //筛选排除无关cookie
            if (!Objects.equals(cookie.getName(), "Token")) {
                continue;
            }
            Object username = request.getSession().getAttribute("username");
            if (username == null) {
                return "login";
            }
            if (logger.isInfoEnabled()) {
                logger.info("登出信息： 用户名：" + username
                        + "  登出时间：" + DateUtil.longToString(System.currentTimeMillis(), "yyyy年MM月dd日 HH时mm分ss秒"));
            }
            cookie.setValue(null);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
            request.getSession().removeAttribute("username");
            request.getSession().removeAttribute("Token");
            break;
        }
        return "login";
    }

}
