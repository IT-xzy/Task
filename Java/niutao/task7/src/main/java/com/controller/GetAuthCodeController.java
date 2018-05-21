package com.controller;

import com.mapper.StudentMapper;
import com.pojo.Student;
import com.util.AuthCode;
import com.validator.Verify;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class GetAuthCodeController {
    @Autowired
    StudentMapper studentMapper;

    Logger logger = (Logger) LoggerFactory.getLogger(GetAuthCodeController.class);

    //注册验证码
    @RequestMapping("/authcode")
    public void getauthcode(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String authCode = AuthCode.getAuthCode();
        httpServletRequest.getSession().setAttribute("authCode", authCode); //将验证码保存到session中，用于验证。
        try {
            //发送图片
            ImageIO.setUseCache(false);  //tomcat temp/目录禁止更改，所以使用内存作为图片缓存。
            ImageIO.write(AuthCode.getAuthImg(authCode), "JPEG", httpServletResponse.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    @RequestMapping(value = "/authcodeajax",method = RequestMethod.GET)
//    public Model postauthcode(String inputCode,HttpServletRequest httpServletRequest,Model model){
//        String authCode = (String) httpServletRequest.getSession().getAttribute("authCode");
//        logger.info("session"+httpServletRequest.getSession().getAttribute("authCode"));
//        logger.info("input"+ inputCode);
//        if(authCode.equalsIgnoreCase(inputCode)){
//            logger.info("验证成功");
//            model.addAttribute("验证码正确");
//        }else {
//            logger.info("验证失败");
//            model.addAttribute("验证码错误");
//        }
//        return model;
//    }
    @RequestMapping(value = "/phoneverify", method = RequestMethod.GET)
    public String getphoneverigy() {
        return "phoneverify";
    }

    @RequestMapping(value = "/phoneverify", method = RequestMethod.POST)
    public String  postphoneverigy(Model model, @Validated({Verify.class}) Student student,
                                   BindingResult bindingResult, String inputCode,
                                   HttpServletRequest httpServletRequest,
                                   RedirectAttributes attr) {

        //数据校验
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError fieldError : errors) {
                httpServletRequest.setAttribute("ERR_" + fieldError.getField(), fieldError.getDefaultMessage());
            }
        }

        String authCode = (String) httpServletRequest.getSession().getAttribute("authCode");
        logger.info("session" + httpServletRequest.getSession().getAttribute("authCode"));
        logger.info("input" + inputCode);
        logger.info("手机号", student.getPhoneNumber());
        int i = studentMapper.selectByUnique(student);
        if (i == 1) {
            model.addAttribute("shoujihao", "手机已经被注册了");
            return "phoneverify";
        } else {
            //手机没有被注册，对验证码进行校验。
            if (authCode.equalsIgnoreCase(inputCode)) {
                logger.info("验证成功");
                model.addAttribute("yanzhengma", "验证通过");
                attr.addFlashAttribute("phone",student.getPhoneNumber());
                return "redirect:/register";
            } else {
                logger.info("验证失败");
                model.addAttribute("yanzhengma", "验证错误");
            }
        }
        return "phoneverify";
    }
}
