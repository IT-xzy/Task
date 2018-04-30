package task2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import task2.Main;
import task2.pojo.User;
import task2.service.UserService;

import java.util.logging.Logger;

@Controller
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;
    Logger logger = Logger.getLogger(Main.class.getName());

    @RequestMapping("/registered")
    public String toRegistered() {
        return ("registered");
    }
//注册
    @RequestMapping(value = "regist", method = RequestMethod.POST)
    public String regist(User user) {
        userService.regist(user);
        //注册成功后跳转index.jsp页面
        return ("redirect:/index.jsp");
    }
//登入
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String signin(@RequestParam String username, @RequestParam String password) {
        System.out.println(username);
        User user = userService.login(username,password);
        System.out.println(user);
        String pwd = user.getPassword();
        if (user != null) {
            if (pwd.equals(password)) {
                return ("redirect:/students");
            }else{
                logger.info("密码错误");
                return ("passwordwrong");
            }

        }
        logger.info("用户名错误");
        return ("wrong");

    }

}
