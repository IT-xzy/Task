package com.controller;

import com.aliyuncs.exceptions.ClientException;
import com.exception.MyException;
import com.pojo.User;
import com.service.UserDaoService;
import com.tools.MailUtil;
import com.tools.PictureUpLoadingUtil;
import com.tools.RedisUtil;
import com.tools.ShortMessageUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class UpdateController {
    private UserDaoService userDaoService;
    private RedisUtil redisUtil;
    private ShortMessageUtil shortMessageUtil;
    private MailUtil mailUtil;
    private PictureUpLoadingUtil pictureUpLoadingUtil;
    private Logger logger = Logger.getLogger(UpdateController.class.getName());

    @Autowired
    public UpdateController(UserDaoService userDaoService, RedisUtil redisUtil, ShortMessageUtil shortMessageUtil,
                            MailUtil mailUtil, PictureUpLoadingUtil pictureUpLoadingUtil) {
        this.userDaoService = userDaoService;
        this.redisUtil = redisUtil;
        this.shortMessageUtil = shortMessageUtil;
        this.mailUtil = mailUtil;
        this.pictureUpLoadingUtil = pictureUpLoadingUtil;
    }

    @RequestMapping("/updateInformation")
    public String toUpdateInformation(User user, Model model) {
        try {
            model.addAttribute("user", userDaoService.getUser(user.getUsername()));
        } catch (MyException e) {
            logger.error(e.getMessage());
            model.addAttribute("message", e.getMessage());
        }
        return "update";
    }

    @RequestMapping(value = "/updateInformationResult", method = RequestMethod.POST)
    public String updateUser(User user, Model model) {
        try {
            boolean flag = userDaoService.update(user);
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
            String url = pictureUpLoadingUtil.upLoading(image, user.getUsername());
            if (url != null) {
                user.setHeadURL(url);
                try {
                    userDaoService.update(user);
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
            model.addAttribute("user", userDaoService.getUser(user.getUsername()));
            model.addAttribute("phone", user.getPhoneNumber());
            String whoseCode = user.getUsername() + "phoneCode";
            String phoneCode = shortMessageUtil.sendShortMessage(user.getPhoneNumber());
            redisUtil.setString(whoseCode, phoneCode, 300);
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
        if (redisUtil.getString(whoseCode).equals(code)) {
            try {
                if (userDaoService.update(user)) {
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
            model.addAttribute("user", userDaoService.getUser(user.getUsername()));
            model.addAttribute("mail", user.getMailAddress());
            String whoseCode = user.getUsername() + "mailCode";
            String mailCode = mailUtil.sendMail(user.getMailAddress());
            redisUtil.setString(whoseCode, mailCode, 300);
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
        if (redisUtil.getString(whoseCode).equals(code)) {
            try {
                if (userDaoService.update(user)) {
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
