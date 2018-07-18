package com.controller;

import com.aliyuncs.exceptions.ClientException;
import com.exception.MyException;
import com.getService.ServiceFactory;
import com.pojo.User;
import com.service.UserDaoService;
import com.tools.PictureUpLoadingUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class UpdateController {
    @Autowired
    private ServiceFactory serviceFactory;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private PictureUpLoadingUtil upLoadingUtil;
    private Logger logger = Logger.getLogger(UpdateController.class.getName());


    @RequestMapping("/updateInformation")
    public String toUpdateInformation(User user, Model model) {
        try {
            model.addAttribute("user", serviceFactory.getUserDaoService().getUser(user.getUsername()));
        } catch (MyException e) {
            logger.error(e.getMessage());
            model.addAttribute("message", e.getMessage());
        }
        return "update";
    }

    @RequestMapping(value = "/updateInformationResult", method = RequestMethod.POST)
    public String updateUser(User user, Model model) {
        try {
            boolean flag = serviceFactory.getUserDaoService().update(user);
            if (flag) {
                model.addAttribute("message", "更新成功");
                return "redirect:/personalInformation";
            }
        } catch (MyException e) {
            logger.error(e.getMessage());
            model.addAttribute("message", e.getMessage());
        }
        return "personalInformation";
    }

    @RequestMapping("/updateHeadResult")
    public String uploading(MultipartFile image, User user, Model model) {
        try {
            String url = upLoadingUtil.upLoading(image, user.getUsername());
            if (url != null) {
                user.setHeadURL(url);
                try {
                    serviceFactory.getUserDaoService().update(user);
                    model.addAttribute("message", "上传成功");
                    return "redirect:/personalInformation";
                } catch (MyException e) {
                    model.addAttribute("message", e.getMessage());
                }
            } else {
                model.addAttribute("message", "上传失败");
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
            model.addAttribute("", "上传失败");
        }
        return "personalInformation";
    }

    @RequestMapping("/updatePhoneNumber")
    public String toUpdatePhoneNumber(User user, Model model) {
        try {
            model.addAttribute("user", serviceFactory.getUserDaoService().getUser(user.getUsername()));
            model.addAttribute("phone", user.getPhoneNumber());
            String whoseCode = user.getUsername() + "phoneCode";
            String phoneCode = serviceFactory.getUserDaoService().sendPhoneCheckCode(user.getPhoneNumber());
            redisTemplate.opsForValue().set(whoseCode, phoneCode, 300);
        } catch (MyException e) {
            logger.error(e.getMessage());
            model.addAttribute("message", e.getMessage());
        } catch (ClientException e) {
            logger.error(e.getMessage());
            model.addAttribute("message", "验证码发送失败");
        }
        return "update";
    }

    @RequestMapping(value = "/updatePhoneNumberResult", method = RequestMethod.POST)
    public String updatePhone(User user, Model model, String code) {
        String whoseCode = user.getUsername() + "phoneCode";
        if (redisTemplate.opsForValue().get(whoseCode).equals(code)) {
            try {
                if (serviceFactory.getUserDaoService().update(user)) {
                    model.addAttribute("message", "更新成功");
                    return "redirect:/personalInformation";
                }
            } catch (MyException e) {
                logger.error(e.getMessage());
                model.addAttribute("message", e.getMessage());
            }
        } else {
            model.addAttribute("message", "验证码错误");
        }
        return "personalInformation";
    }

    @RequestMapping("/updateMailAddress")
    public String toUpdateMailAddress(User user, Model model) {
        try {
            model.addAttribute("user", serviceFactory.getUserDaoService().getUser(user.getUsername()));
            model.addAttribute("mail", user.getMailAddress());
            String whoseCode = user.getUsername() + "mailCode";
            String mailCode = serviceFactory.getUserDaoService().sendMailCheckCode(user.getMailAddress());
            redisTemplate.opsForValue().set(whoseCode, mailCode, 300);
        } catch (MyException e) {
            logger.error(e.getMessage());
            model.addAttribute("message", e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
            model.addAttribute("message", "验证码发送失败");
        }
        return "update";
    }

    @RequestMapping(value = "/updateMailAddressResult", method = RequestMethod.POST)
    public String updateMail(User user, Model model, String code) {
        String whoseCode = user.getUsername() + "mailCode";
        if (redisTemplate.opsForValue().get(whoseCode).equals(code)) {
            try {
                if (serviceFactory.getUserDaoService().update(user)) {
                    model.addAttribute("message", "更新成功");
                    return "redirect:/personalInformation";
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
                model.addAttribute("message", e.getMessage());
            }
        } else {
            model.addAttribute("message", "验证码错误");
        }
        return "personalInformation";
    }

}
