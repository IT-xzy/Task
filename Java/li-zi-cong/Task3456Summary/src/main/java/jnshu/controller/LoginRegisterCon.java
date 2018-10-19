package jnshu.controller;

import jnshu.dao.AccountMapper;
import jnshu.pojo.LoginAccount;
import jnshu.pojo.RegisterAccount;
import jnshu.service.CompoundService;
import jnshu.util.MD5;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class LoginRegisterCon {

    @Autowired
    private CompoundService compoundService;

    Logger logger = Logger.getLogger(LoginRegisterCon.class);


    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/listStudent", method = RequestMethod.GET)
    public String listStudent(Model model) {
        return "拦截器验证成功会修改";
    }

    //网页右上角登录按钮路由
    @RequestMapping(value = "/loginRegister", method = RequestMethod.GET)
    public String first(Model model) {
        return "Register";
    }

    //处理注册页数据
    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    public String Register(RegisterAccount registerAccount, Model model) {
        try {
            compoundService.Register(registerAccount);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
        }
        return "redirect:/";
    }

    //从注册页面跳转到登录页
    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public String Login(Model model) {
        System.out.println("从注册页面跳转到登录页路由");
        return "Login";
    }

    //处理登录页数据
    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
    public String checkLogin(LoginAccount loginAccount, Model model, HttpServletRequest request, HttpServletResponse response) {
        try {
            Cookie token = compoundService.checkLogin(loginAccount);
            if (token!=null){
                response.addCookie(token);
                return "redirect:/ ";
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
        }
        return null;
    }
}
