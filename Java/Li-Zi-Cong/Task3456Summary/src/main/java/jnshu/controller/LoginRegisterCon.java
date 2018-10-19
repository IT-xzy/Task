package jnshu.controller;

import jnshu.api.SmtpEmail;
import jnshu.dao.AccountMapper;
import jnshu.pojo.LoginAccount;
import jnshu.pojo.RegisterAccount;
import jnshu.service.CompoundService;
import jnshu.util.MD5;
import jnshu.util.MemcacheUtil;
import jnshu.util.RandomCode;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import redis.clients.jedis.Jedis;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
    @RequestMapping(value = "/u/listStudent", method = RequestMethod.GET)
    public String listStudent(Model model) {
        return "随便吧";
    }

    //网页右上角登录按钮路由
    @RequestMapping(value = "/loginRegister", method = RequestMethod.GET)
    public String first(Model model) {
        return "Register";
    }

    //处理注册页数据
    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    public String Register(RegisterAccount registerAccount, Model model,HttpServletRequest request) {
        try {
            System.out.println(request.getParameter("account"));
            System.out.println(registerAccount.toString());
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
    public String checkLogin(LoginAccount loginAccount, HttpServletResponse response,HttpSession session) {
        try {
            Cookie cookie = compoundService.checkLogin(loginAccount);
            if (cookie!=null){
                response.addCookie(cookie);
                session.setAttribute("userName",loginAccount.getAccount());
            }
            return "redirect:/";
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
        }
        return null;
    }

    @RequestMapping(value = "/code",method = RequestMethod.POST)
    public void code(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        PrintWriter out = response.getWriter();
        String emailAddr = request.getParameter("addressee");
        Integer code = Integer.parseInt(RandomCode.createCode());

        //邮件工具类
//        new SmtpEmail(emailAddr,code.toString());

        Jedis redis = new Jedis("localhost",6379);
        redis.set(emailAddr,code.toString());

        System.out.println(new Date());

        out.print(emailAddr+"/"+code.toString());
    }

    @RequestMapping(value = "/checkAccount",method = RequestMethod.POST)
    public void checkAccount(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        PrintWriter out = response.getWriter();
        System.out.println("收到要验证的账号"+request.getParameter("checkAccount"));
        if (request.getParameter("checkAccount").equals("abcd")){
            out.print(1);
            System.out.println("验证返回1");
        }else {
            out.print(0);
            System.out.println("验证返回0");

        }
    }

    @RequestMapping(value = "/checkToken",method = RequestMethod.POST)
    public void checkToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String code =request.getParameter("code");
        String addressee =request.getParameter("addressee");
        System.out.println("code:\t"+code+"\n"+
        "email:\t"+addressee);
        Jedis redis = new Jedis("localhost",6379);
        if (redis.get(addressee).equals(code)){
            redis.del(addressee);
            out.print(1);
        }else {
            out.print(0);
        }
    }


    @RequestMapping(value = "/cancellation",method = RequestMethod.GET)
    public String cancellation(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws Exception {
        session.setAttribute("userName",null);
        Cookie cookie = new Cookie("token","");
        cookie.setMaxAge(0);//设置其生命周期
        response.addCookie(cookie);
        return "redirect:/";
    }
}
