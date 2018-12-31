package com.mutesaid.controller;

import com.mutesaid.pojo.Usr;
import com.mutesaid.service.UsrService;
import com.mutesaid.utils.CookieUtil;
import com.mutesaid.utils.ResponseBo;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private UsrService usrService;

    private Logger logger = LogManager.getLogger(LoginController.class);

    @GetMapping(value = "/loginPage")
    public String loginPage() {
        return "loginPage";
    }

    @PostMapping(value = "/login")
    public String login(HttpServletResponse response, RedirectAttributes model,
                        String name, String pwd) {
        logger.info("login : name = [{}] password = [{}]", name, pwd);
        try {
            Usr usr = usrService.isTrue(name, pwd);
            Cookie cookie = usrService.setToken(usr);
            response.addCookie(cookie);
            logger.info("login success");
            return "redirect:u/student";
        } catch (IllegalArgumentException argE) {
            logger.error(argE.getMessage());
            logger.error("login parameters error");
            Map json = ResponseBo.msg(argE.getMessage());
            model.addFlashAttribute("json", json);
            return "redirect:loginPage";
        } catch (Throwable t) {
            logger.error(t.getMessage());
            logger.error("login unknown error");
            Map json = ResponseBo.msg("Unknow.Exception");
            model.addFlashAttribute("json", json);
            return "redirect:errorPage";
        }
    }

    @GetMapping(value = "/logout")
    public String logout(HttpServletResponse response) {
        response.addCookie(CookieUtil.killCookie("token"));

        return "redirect:loginPage";
    }
}
