package com.mutesaid.controller;

import com.mutesaid.pojo.Usr;
import com.mutesaid.service.UsrService;
import com.mutesaid.utils.ResponseBo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
public class SignupController {
    @Autowired
    private UsrService usrService;

    private Logger logger = LogManager.getLogger(SignupController.class);

    @GetMapping("/signupPage")
    public String signupPage() {
        return "signPage";
    }

    @GetMapping("/signEmailPage")
    public String signEmailPage() {
        return "signEmailPage";
    }

    @PostMapping("/signupPhone")
    public String signupPhone(String phone) {
        logger.info("send msg phone is [{}]", phone);
        try {
            usrService.phoneCode(phone);
            logger.info("send msg success");
            return "redirect:/signupPage";
        } catch (IllegalArgumentException argE) {
            logger.error(argE.getMessage());
            logger.error("send msg known error");
            return "redirect:errorPage";
        } catch (Throwable t) {
            logger.error(t.getMessage());
            logger.error("send msg unknown error");
            return "redirect:errorPage";
        }
    }

    @PostMapping("/signupEmail")
    public String signupEmail(Usr usr) {
        logger.info("send email = [{}]", usr.getEmail());
        try {
            usrService.sendEmail(usr);
            return "redirect:/signEmailPage";
        } catch (IllegalArgumentException argE) {
            logger.error(argE.getMessage());
            logger.error("send email error");
        } catch (Throwable t) {
            logger.error(t.getMessage());
            logger.error("send email unknown error");
        }
        return "redirect:errorPage";
    }

    @GetMapping("/signEmail")
    public String signEmail(String token) {
        logger.info("Email sign up token is [{}]", token);
        try {
            Usr usr = usrService.matchEmail(token);
            usrService.insert(usr, null);
            logger.info("Email sign up success");
            return "redirect:/loginPage";
        } catch (IllegalArgumentException argE) {
            logger.error(argE.getMessage());
            logger.error("email signup error");
            return "redirect:/signEmailPage";
        } catch (Throwable t) {
            logger.error(t.getMessage());
            logger.error("email signup unknown error");
            return "redirect:errorPage";
        }
    }


    @PostMapping("/signup")
    public String signup(RedirectAttributes model, @Validated Usr usr, BindingResult error, String code) {
        logger.info("signup : usr = [{}]", usr);
        try {
            usrService.isTrueCode(code, usr);
            usrService.insert(usr, error);
            logger.info("signup success");
            return "redirect:/loginPage";
        } catch (IllegalArgumentException argE) {
            logger.error(argE.getMessage());
            logger.error("signup parameters error");
            Map json = ResponseBo.msg(argE.getMessage());
            model.addFlashAttribute("json", json);
            return "redirect:/signupPage";
        } catch (Throwable t) {
            logger.error(t.getMessage());
            logger.error("signup unknown error");
            Map json = ResponseBo.msg("Unknow.Exception");
            model.addFlashAttribute("json", json);
            return "redirect:errorPage";
        }
    }
}
