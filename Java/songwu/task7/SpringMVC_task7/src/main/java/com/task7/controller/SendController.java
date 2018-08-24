package com.task7.controller;

import com.aliyuncs.exceptions.ClientException;
import com.task7.pojo.MessageException;
import com.task7.pojo.Person;
import com.task7.service.LoginService;
import com.task7.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * Create by SongWu on 2018/8/7
 */
@Controller
public class SendController {
    @Autowired
    LoginService loginService;
    @Autowired
    MessageUtil messageUtil;
    @Autowired
    EmailUtil emailUtil;
    @Autowired
    ImageUtil imageUtil;
    @Autowired
    MemcacheUtil memcacheUtil;
    @Autowired
    RedisUtil redisUtil;

    //显示个人信息
    @RequestMapping(value = "/u/personal")

    public String personal(HttpServletRequest request, Model model) {
        String username = (String) request.getSession().getAttribute("username");
        Person person = loginService.selectLogin(username);
        model.addAttribute("person", person);
        return "personal";
    }

    //绑定手机
    @RequestMapping(value = "/phone")
    public String phone(Person person, Model model) {

        System.out.println("person" + person);
        if (person.getPhone() == ""){
            model.addAttribute("message", "请输入手机号");
            return "loginMessage";

        } else {
            System.out.println("用户数据："+loginService.selectLogin(person.getUsername()).getPhone());

            if (loginService.selectLogin(person.getUsername()).getPhone() == null
                    || loginService.selectLogin(person.getUsername()).getPhone() == "") {
                try {

                    String code = RandomUtil.random(6);
                    redisUtil.set(person.getUsername(), code, 5 * 60 * 1000L);
                    redisUtil.set(person.getPassword()+person.getUsername(),person.getPhone(),5 * 60 * 1000L);
                    String message = messageUtil.sendSms(person.getPhone(), code);
                    model.addAttribute("message", message);
                } catch (ClientException e) {
                    e.printStackTrace();
                    model.addAttribute("message", "出现异常");

                }
                return "codeContext";
            }
            System.out.println("手机号是否一样："+loginService.selectLogin(person.getUsername()).getPhone().equals(person.getPhone()));
            if (!(loginService.selectLogin(person.getUsername()).getPhone().equals(person.getPhone()))) {
                model.addAttribute("message", "账号已经绑定别的手机号");
                return "loginMessage";
            }
            model.addAttribute("message", "此手机号已经绑定");
            return "loginMessage";
        }


    }
//验证手机验证码进行绑定
    @RequestMapping(value = "/phoneCode")
    public String phoneCode(HttpServletRequest request, @RequestParam(value = "phoneCode") String phoneCode, Model model) {
        String username = (String) request.getSession().getAttribute("username");
        Person person = loginService.selectLogin(username);
        String redisCode = (String)redisUtil.get(username);
        System.out.println("验证码：" + redisCode);
        System.out.println(person);
        System.out.println(phoneCode);
        System.out.println("验证码是否正确" + phoneCode.equals(redisCode));
        if (phoneCode.equals(redisCode)) {
            String redisPhone = (String) redisUtil.get(person.getPassword()+person.getUsername());
            person.setPhone( redisPhone );
            if (loginService.updatePerson(person)) {
                model.addAttribute("message", "绑定成功");
            } else {
                model.addAttribute("message", "验证码正确，更新手机号失败");
            }

        } else {
            model.addAttribute("message", "验证码错误");
        }

        return "loginMessage";
    }

    //绑定邮箱
    @RequestMapping(value = "/email")
    public String email(Person person, Model model) {
        System.out.println("person" + person);
        if (person.getEmail() == ""){
            model.addAttribute("message", "请输入邮箱号");
            return "loginMessage";

        } else {
            System.out.println("用户数据："+loginService.selectLogin(person.getUsername()).getEmail());

            if (loginService.selectLogin(person.getUsername()).getEmail() == null
                    || loginService.selectLogin(person.getUsername()).getEmail() == "") {
                try {

                    String code = RandomUtil.random(6);
                    redisUtil.set(person.getUsername(), code, 5 * 60 * 1000L);
                    redisUtil.set(person.getPassword()+person.getUsername(),person.getEmail(),5 * 60 * 1000L);
                    String message = emailUtil.send_common_with_attachment(person.getEmail(), code);
                    model.addAttribute("message", message);
                } catch (Exception e) {
                    e.printStackTrace();
                    model.addAttribute("message", "出现异常");

                }
                return "codeContext";
            }
            System.out.println("邮箱号是否一样："+loginService.selectLogin(person.getUsername()).getEmail().equals(person.getEmail()));
            if (!(loginService.selectLogin(person.getUsername()).getEmail().equals(person.getEmail()))) {
                model.addAttribute("message", "账号已经绑定别的邮箱号");
                return "loginMessage";
            }
            model.addAttribute("message", "此邮箱号已经绑定");
            return "loginMessage";
        }


    }
//验证邮箱验证码进行绑定
    @RequestMapping(value = "/emailCode")
    public String emailCode(HttpServletRequest request, @RequestParam(value = "emailCode") String emailCode, Model model) {
        String username = (String) request.getSession().getAttribute("username");
        Person person = loginService.selectLogin(username);
        String redisCode = (String) redisUtil.get(person.getUsername());
        System.out.println("验证码：" + redisCode );
        System.out.println(person);
        System.out.println(emailCode);
        System.out.println("验证码是否正确" + emailCode.equals(redisCode ));
        if (emailCode.equals(redisCode )) {
            String redisEmail = (String) redisUtil.get(person.getPassword()+person.getUsername());
            person.setEmail(redisEmail);
            if (loginService.updatePerson(person)) {
                model.addAttribute("message", "绑定成功");

            } else {
                model.addAttribute("message", "验证码正确，更新邮箱号失败");
            }


        } else {
            model.addAttribute("message", "验证码错误");

        }

        return "loginMessage";
    }



//    文件上传
    @RequestMapping(value = "/i/picture",method=RequestMethod.POST)

    public String picture(HttpServletRequest request, @ModelAttribute("image") MultipartFile image,@ModelAttribute("username") String username, Model model ) {
        try {
            System.out.println(image);
            System.out.println(username);
            String url = imageUtil.upLoading(image, username);
            System.out.println("url:" + url);
            Person person = new Person();
            person.setUsername(username);
            person.setPicture(url);
            loginService.updatePerson(person);
            model.addAttribute("image", url);
            return "image";
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message" + "出现错误");
            return "loginMessage";
        }

    }

//    文件类型不匹配跳转至此页面
    @RequestMapping(value = "typeErro")
    public String fileType(Model model) {
        model.addAttribute("message", "文件类型错误,只支持jpg,png,ico,bmp,jpeg");
        return "loginMessage";
    }

    //    修改手机号
    @RequestMapping(value = "/phoneModify")
    public String phoneModify(Person person, Model model) throws Exception{

        if (person.getPhone() == null||person.getPhone()=="") {
            throw new MessageException("没有绑定别手机号不能修改");
        }

        try {
            String code = RandomUtil.random(6);
           redisUtil.set(person.getPhone(), code, 5 * 60 * 1000L);
            String message = messageUtil.sendSms(person.getPhone(), code);
            model.addAttribute("message", message);
            return "codeContext";
        } catch (ClientException e) {

            e.printStackTrace();
            model.addAttribute("message", "出现异常");
        }
        return "codeContext";
    }

//    对比验证码进行修改
    @RequestMapping(value = "/phoneModifyResult")
    public String phoneModifyResult(HttpServletRequest request, String newPhone, String phoneCode, Model model) {
        String username = (String) request.getSession().getAttribute("username");
        Person person = loginService.selectLogin(username);
        if (newPhone == null || newPhone == "") {
            model.addAttribute("message", "请填入新的手机号");
            return "loginMessage";

        }
        String redisCode = (String) redisUtil.get(person.getPhone());

        if (phoneCode.equals(redisCode)) {
            person.setPhone(newPhone);

            if (loginService.updatePerson(person)) {
                model.addAttribute("message", "修改绑定成功");
            } else {
                model.addAttribute("message", "验证码正确，更新手机号失败");
            }

        } else {
            model.addAttribute("message", "验证码错误");
        }

        return "loginMessage";
    }

}