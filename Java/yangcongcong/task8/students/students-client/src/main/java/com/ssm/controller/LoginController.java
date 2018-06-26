package com.ssm.controller;

import com.ssm.model.UserRegister;
import com.ssm.service.UserRegisterService;
import com.ssm.utils.DesUtil;
import com.ssm.utils.GetBeanAndRandomSelect;
import com.ssm.utils.MD5Util2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    //跳转到登录页面
    @RequestMapping(value = "/land")
    public String toLogin() {
        return "loginPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("/login POST username:" + request.getParameter("username"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String content = "" + username + "." + System.currentTimeMillis();
        String token = DesUtil.encrypt(content);

        //随机调用
        UserRegisterService userRegisterService =
                (UserRegisterService) GetBeanAndRandomSelect.randomSelect("myRMIClientC12","myRMIClientC22");

        UserRegister userRegister = userRegisterService.getByName(username);

        if (userRegister != null) {
            if (MD5Util2.verify(password, userRegister.getPassword())) {
                Cookie cookie = new Cookie("token", token);
                cookie.setMaxAge(60 * 60 * 24);
                response.addCookie(cookie);
                return "redirect:/u/users";
            } else {
                return "loginPage";
            }
        } else {
            return "loginPage";
        }
    }
}
