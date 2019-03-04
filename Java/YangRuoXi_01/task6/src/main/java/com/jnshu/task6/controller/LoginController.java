package com.jnshu.task6.controller;

import com.jnshu.task6.beans.Login;
import com.jnshu.task6.service.LoginService;
import com.jnshu.task6.utils.Md5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {




    Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private LoginService loginService;



    @RequestMapping(value = "/testLoginJson" , method = RequestMethod.GET)
    public String textLoginJson(Model model){

//        Login login = new Login();
//        login.setLoginName("zzz");
//        login.setPwd("321");
//        model.addAttribute("login",login);
        return "json";
    }
    @RequestMapping(value = "/testReg",method = RequestMethod.POST)
    public String testRegJson(){
//        Login login = new Login();
//        login.setName("123");
//        login.setPwd("123");
//        login.setEmail("123@123.com");
//        login.setQq("111");
//        login.setPhone("321");
//        loginService.addlogin(login);
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("login",login);
        return "json";
    }

//    /**
//     * 去往注册页面
//     * @return 去登陆login.jsp页面
//     */
//    @RequestMapping(value = "/registration")
//    public String registration(){
//
//        return "registration";
//    }

    /**
     *  去往注册页面功能
     * @return registration.jsp页面
     *
     */
    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public String toRegistrationPage(){
        return "registration";
    }



    /**
     *  注册功能
     * @return 注册成功,重定向到home页,失败重定向会注册页面;
     *
     */
    @RequestMapping(value = "/registration",method = RequestMethod.POST)
    public String registration( Login login, String loginName,String pwd ,Errors errors){

//        Login login = new Login();

        //去重登陆名称
        if(loginService.selectLoginByName(loginName) != null ){
            logger.error("message","用户名已注册,请重新注册");
            return "redirect:/registration";
        }
        login.setLoginName(loginName);
        String md5Pwd = Md5Util.digest(pwd);
        login.setPwd(Md5Util.digest(pwd));
        logger.info(" new login = " + login);
        loginService.addLoginAndPwd(login);
        return "redirect:/home";
    }

    /**
     *  去往登陆页面功能
     * @return login.jsp页面
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String toLoginPage(HttpServletRequest request){
        StringBuffer url = request.getRequestURL();
        logger.info("url = " + url);
        return "login";
    }

    /**
     * 实现登陆功能
     * @param request request域,
     * @param model model对象
     * @param loginName 用户输入的用户名
     * @param pwd 用户输入的密码
     * @return 登陆成功,进入到职业页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request, Model model, String loginName, String pwd){
        //登陆:
        Login login = loginService.selectLoginByName(loginName);
        StringBuffer url= request.getRequestURL();
        System.out.println(url);
        //验证用户名和密码
        logger.info(loginName);
        System.out.println(login);
        String md5Pwd = Md5Util.digest(pwd);
        logger.info("用户输入密码" + pwd);
        logger.info("加密后的密码"+ md5Pwd);

        if (md5Pwd.equals(login.getPwd())){
            request.getSession().setAttribute("loginName",loginName);
            logger.info("loginController + " + loginName);
            return "redirect:/home";
        } else {
            model.addAttribute("message","登陆失败");
            logger.info("logincontroller Error"  + loginName );
            return "redirect:/home";
        }
    }




    @RequestMapping(value = "/loginout" )
    public String loginout(HttpSession session){
        session.removeAttribute("isLogin");
        session.removeAttribute("loginName");
        session.invalidate();
        return "redirect:/home";
    }

}
