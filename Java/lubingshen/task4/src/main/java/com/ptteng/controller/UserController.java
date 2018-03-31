package com.ptteng.controller;

import com.ptteng.bean.User;
import com.ptteng.exception.StudentException;
import com.ptteng.service.UserService;
import com.ptteng.utils.CheckBox;
import com.ptteng.utils.DesUtil;
import com.ptteng.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller    //加了这个就不需要显式实现接口了
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/registration\n", method = RequestMethod.GET)
    public String register() {
        return "registration";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
        //通过自定义标签+反射的方法检测数据合法性
        CheckBox.check(user,CheckBox.LOGIN);
        User result = userService.query(user.getUserName());
        //通过抛出自定义异常给前端适配器，然后分发给自定义异常处理器处理，最后反馈信息给用户
        if (result == null)
            throw new StudentException("用户不存在，请注册后登陆！");
        DesUtil desUtil = new DesUtil("java");
        if(!result.getUserKey().equals(Md5Util.getMd5(user.getUserKey())))
            throw new StudentException("密码错误，请重新输入！");
        //重新加密cookie，重生成token
        Long current = System.currentTimeMillis();
        result.setLoginAt(current);
        userService.modify(result);
        //中间加个","，方便spilt拆分
        String message = result.getUserName() + "," +current;
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
        //使得只有本次session，此cookie才生效
        //注意session关了浏览器才会关闭
        // 因为session的信息储存在服务器，下次重启浏览器时，session的信息(cookie)会发生变化（JSESSIONID）
        request.getSession().setAttribute("user", token);
        //重定向回到主页
        return "redirect:task4/home";
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String tryToRegister(User user) throws Exception {
        CheckBox.check(user,CheckBox.REGISTER);
        //加密，使得数据库和登录校核时，加密的规则和结果一致
        //也能防止运营人员窃取用户信息
        user.setUserKey(Md5Util.getMd5(user.getUserKey()));
        userService.register(user);
        return "redirect:/login";
    }
}
