package task07.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import task07.pojo.UserLogin;
import task07.pojo.UserLoginGroup1;
import task07.services.EmailByAliyunServices;
import task07.services.SMSVerifyServices;
import task07.services.UserLoginOut;
import task07.services.UserLoginServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.nio.charset.Charset;

/**
 * ${file_name} Create on ${date}
 * Copyright (c) ${date} by taotaosoft
 *
 * @author <a href="1070800859@qq.com">* @Author: Mr.huang </a>
 * @version 1.0
 */


@Controller
public class UserLoginController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserLoginController.class);
    private static final Charset CHARSET = Charset.forName("gb2312");
    @Autowired
    public UserLoginServices userLoginServices;
    @Autowired
    public SMSVerifyServices smsVerifyServices;
    @Autowired
    public EmailByAliyunServices emailByAliyunServices;
    @Autowired
    public UserLoginOut userLoginOut;
    private UserLogin userLogin;

    //    实现跳转至登录界
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        // 存储当前时间
        long date = System.currentTimeMillis();
        logger.info("------------------ 跳转至登录界面 ----------------");
        mav.addObject("date", date);
        // 设定跳转页面
        mav.setViewName("SignIn");
        return mav;
    }

    //实现跳转至注册界面
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register1() {
        ModelAndView mav = new ModelAndView();
        // 存储当前时间
        long date = System.currentTimeMillis();
        logger.info("------------------ 跳转至注册界面 ----------------");
        mav.addObject("date", date);
        // 设定跳转页面
        mav.setViewName("register");
        return mav;
    }


    @RequestMapping(value = "/toregister", method = RequestMethod.POST)
    public String register(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           UserLogin userLogin, Model model, String reKey) {

        if (userLoginServices.queryByName(userLogin.getName()) != null) {
            model.addAttribute("BackendNotification", "用户已存在");
            return "redirect:/toregister";
        }
        if (!userLoginServices.UserRegister(httpServletRequest, httpServletResponse, userLogin, reKey)) {
            model.addAttribute("BackendNotification", "验证码不对，请重新输入！");
            return "redirect:/toregister";
        }
        model.addAttribute("BackendNotification", "注册成功，请登录");
        return "redirect:/login";

    }


    @RequestMapping(value = "tologin", method = RequestMethod.POST)
    public String tologinbase(Model model, UserLogin userLogin, HttpServletResponse response,
                              HttpServletRequest request) {
        if (userLoginServices.queryByName(userLogin.getName()) != null) {
            if (userLoginServices.UserLogin(request, response, userLogin)) {
                return "redirect:/u/occupation";//一个登陆成功的页面
            } else {
                model.addAttribute("返回通知", "账户或密码不对");
                return "redirect:/login";
            }
        } else {
            model.addAttribute("返回通知", "账户或密码不对");
            return "redirect:/login";
        }

    }


    @RequestMapping(value = "/register/verifyBySMS", method = RequestMethod.POST
            , produces = {"text/html;charset=UTF-8;", "application/json;"})
    public void verifyBySMS(HttpServletRequest httpServletRequest,
                            HttpServletResponse httpServletResponse,
                            @Validated(value = UserLoginGroup1.class) UserLogin userLogin,
                            BindingResult bindingResult
    ) throws Exception {
        String smsStatus = "";

        // 判断注册信息是否正确
        smsStatus = smsVerifyServices.getSMSVerifyJudgment(userLogin, bindingResult);
        logger.info("1." + smsStatus);

        // 返回前端的信息
        if (smsStatus.equals("")) {
            if (smsVerifyServices.getSMSVerify(httpServletRequest, httpServletResponse, userLogin)) {
                smsStatus = "您的验证码发送成功！";
                logger.info("2." + smsStatus);
            } else {
                smsStatus = "您的验证码已发送至你手机，请稍等！如为收到，请于2分钟后重试！";
                logger.info("3." + smsStatus);
            }
        }
        logger.info("最后返回到前端的信息 ：" + smsStatus);

        // 封装返回前端的数据
        PrintWriter out = httpServletResponse.getWriter();
        out.print(smsStatus);
        out.flush();
        out.close();

    }


    @RequestMapping(value = "/register/verifyByEmail", method = RequestMethod.POST, produces = {"text/html;charset=UTF-8;", "application/json;"})
    public void verifyByEmail(HttpServletRequest httpServletRequest,
                              HttpServletResponse httpServletResponse,
                              @Validated(value = UserLoginGroup1.class) UserLogin userLogin,
                              BindingResult bindingResult) throws Exception {
        String emailStatus = "";

        // bindingResult.rejectValue("name","请输入3位字符以上的用户名");

        // 判断注册信息是否正确
        emailStatus = emailByAliyunServices.getEmailVerifyJudgment(userLogin, bindingResult);
        logger.info("1." + emailStatus);

        // 返回前端的信息
        if (emailStatus.equals("")) {
            if (emailByAliyunServices.getEmailVerify(httpServletRequest, httpServletResponse, userLogin)) {
                emailStatus = "您的邮箱验证码发送成功！";
                logger.info("2." + emailStatus);
            } else {
                emailStatus = "您的邮箱验证码已发送，请稍等！如为收到，请于2分钟后重试！";
                logger.info("3." + emailStatus);
            }
        }
        logger.info("最后返回到前端的信息 ：" + emailStatus);

        // 封装返回前端的数据
        PrintWriter out = httpServletResponse.getWriter();
        out.print(emailStatus);
        out.flush();
        out.close();

    }

    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    public ModelAndView loginOut(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        // 登出，删除session 和 cookie
        userLoginOut.userLoginout(request, response);

        ModelAndView mav = new ModelAndView();
        // 存储当前时间
        long date = System.currentTimeMillis();
        logger.info("------------------ 跳转至登录界面 ----------------");
        mav.addObject("date", date);
        // 设定跳转页面
        mav.setViewName("page01");
        return mav;

    }


}