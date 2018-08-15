package com.fgh.task2.controller;

import com.fgh.task2.Utils.SmsDemo;
import com.fgh.task2.Utils.buildRandom;
import com.fgh.task2.Utils.cache.RedisUtils;
import com.fgh.task2.service.login.LoginService;
import com.fgh.task2.tool.ChinaPhone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.fgh.task2.Utils.buildRandom.Random;

@Controller
public class SmsController {
    @Autowired
    private SmsDemo smsDemo;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private LoginService loginService;

    Logger logger=LoggerFactory.getLogger(SmsController.class);

    @RequestMapping(path = "/sms")
    public String sms() throws Exception {
        return "/smsTest";
    }

    @RequestMapping(path = "/sendms",method = RequestMethod.POST)
    @ResponseBody
    public Boolean smsTest(@RequestParam String phone) throws Exception {
        logger.info("电话："+phone);
        if (phone != null) {
            String code = buildRandom.Random(6);
            smsDemo.sendSmsUtil(phone, code);
            redisUtils.add(phone,code);
            return true;
        }
        else
            return false;
    }

    @RequestMapping(path = "/verify",method = RequestMethod.POST)
    public String sms(HttpServletRequest request, Model model, RedirectAttributes attributes){
        String name = request.getParameter("name");
        logger.info("phone: "+name);
        if (!ChinaPhone.isPhoneLegal(name)){
            logger.debug("用户名格式不符！");
//            model.addAttribute("illegal","用户名不合法");
            return "smsTest";
        }
        if ( loginService.quaryByName(name)==null){
            logger.debug("用户不存在,请前往注册!");
            model.addAttribute("inExist","用户不存在");
            return "smsTest";
        }
        String code = request.getParameter("RandCode");
        logger.info("code: "+code);
        String phoneCode = (String) redisUtils.getkey(name);
        logger.info("phoneCode: "+phoneCode);
        if (phoneCode.equals(code)){
            return "redirect:/user";
        }else {
            logger.debug("验证码不正确！");
            model.addAttribute("MsgCode","验证码错误！");
            return "smsTest";
        }
    }

}
