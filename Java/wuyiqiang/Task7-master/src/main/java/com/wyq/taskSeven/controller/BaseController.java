package com.wyq.taskSeven.controller;

import com.wyq.taskSeven.verification.PhoneVerification;
import com.wyq.taskSeven.verification.PhoneVerificationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/authority")
public class BaseController {

    @Autowired
    public PhoneVerificationUtil phoneVerificationUtil;

    @Autowired
    public RedisTemplate redisTemplate;

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tiles_index");
        return modelAndView;
    }

    @RequestMapping("/sign_in")
    public ModelAndView signIn() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tiles_sign_in");
        return modelAndView;
    }

    @RequestMapping("/sign_up_by_phone")
    public ModelAndView signUpByPhone() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tiles_sign_up_by_phone");
        return modelAndView;
    }

    @RequestMapping(value = "/sign_up_by_phone/send_verification_code", method = RequestMethod.POST)
    public ModelAndView sendVerificationCode(@ModelAttribute("phoneVerification") PhoneVerification phoneVerification) {
        ModelAndView modelAndView = new ModelAndView();
//        校验注册信息
        boolean flag = phoneVerificationUtil.sendVerificationCode(phoneVerification);
        if (flag) {
//            输入验证码的界面
            modelAndView.addObject("phoneVerification", phoneVerification);
            modelAndView.setViewName("tiles_sign_up_by_phone_commit");
        } else {
//            注册页面
            modelAndView.setViewName("redirect:/authority/sign_up_by_phone");
        }
        return modelAndView;
    }

    @RequestMapping("/sign_up_by_phone/checking")
    public String checking(@RequestParam("phone") String phone, @RequestParam("verificationCodeClient") String verificationCodeClient) {
        Map<String, String> check = redisTemplate.opsForHash().entries(phone);
//        check验证码
        if ((check.get("verificationCodeService")).equals(verificationCodeClient)) {
//            跳转到用户信息页面
            return "redirect:/authority/u/personal_info";
        }
//        跳转到注册页面
        return "redirect:/authority/sign_up_by_phone";
    }

    @RequestMapping("/sign_up_by_email")
    public ModelAndView signUpByEmail() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tiles_sign_up_by_email");
        return modelAndView;
    }

    @RequestMapping("/sign_out")
    public ModelAndView signOut() {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    @RequestMapping("/u/personal_info")
    public ModelAndView personalInfo() {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }
}
