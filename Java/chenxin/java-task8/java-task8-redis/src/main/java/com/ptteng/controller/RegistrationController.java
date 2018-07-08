package com.ptteng.controller;

import com.ptteng.model.User;
import com.ptteng.rmi.server.ServerA;
import com.ptteng.service.UserService;
import com.ptteng.util.DESAlgorithm;
import com.ptteng.util.MD5CipherTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private static ServerA serverA;


    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String showRegistrationPage() throws Exception{
        return "register";
    }

    @RequestMapping(value = "/emailRegister",method = RequestMethod.GET)
    public String showEmailRegistrationPage() throws Exception{
        return "emailRegister";
    }

    @RequestMapping(value= "/registerProcess",method = RequestMethod.POST)
//    public String  registerProcess(HttpServletRequest request, HttpServletResponse response,User user) throws Exception {
    public String  registerProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserService userService = serverA.getUserService();
        User user = (User) request.getSession().getAttribute("user");
        String result = null;
        String message = "";
        if (user.getUsername() != "" && user.getPassword() != ""){
            boolean isExist = userService.isExist(user);
            if (!isExist){
                DESAlgorithm des = new DESAlgorithm();
                String key = "chenxin@#*";
                MD5CipherTest MD5 = new MD5CipherTest();
                //从登录表单里拿出密码并加密。
                String  passward = des.encrypt(user.getPassword(), key);
                //加密密码后MD5加盐。
                String salt = "j@)o8&*0@";
                passward=MD5.cipherMethod(passward+salt);
                user.setPassword(passward);
                user.setCreatedAt(System.currentTimeMillis());
                boolean i = userService.register(user);
                if (i) {
                    result = "registerSuccess";
                } else {
                    result = "register";
                }
            }else {
                message = "用户名已存在";
                request.setAttribute("message", message);
                result = "register";
            }

        }else {
            message = "用户名和密码不能为空";
            request.setAttribute("message", message);
            result = "register";
        }
        return result;
    }
}
