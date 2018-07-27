package com.jnshu.tiles.controller;

import com.jnshu.tiles.entity.User;
import com.jnshu.tiles.service.BusinessServiceImpl;
import com.jnshu.tiles.tools.CookieUtil;
import com.jnshu.tiles.tools.DesUtil;
import com.jnshu.tiles.tools.JWTUtil;
import com.jnshu.tiles.tools.Md5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;


/**
 * @program: Tiles
 * @description: 登录注册
 * @author: Mr.Lee
 * @create: 2018-07-04 10:26
 **/
@Controller
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    BusinessServiceImpl businessService;


    @RequestMapping("registers")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String register(User user, Model model) throws Exception {
        String username = user.getUsername();
        String pwd = user.getPassword();
//        MD5加盐加密密码
        pwd = Md5Util.getSaltMD5(pwd);
        user.setPassword(pwd);

        log.info("用户名： " + user.getUsername());
        log.info( "密码：" + user.getPassword());

        if (businessService.findByUserName(username)==null){
            businessService.register(user);
            log.info("=========注册成功=======");
            return "viewLogin";
        }else {
            log.info("=========注册失败=======");
            model.addAttribute("message","用户名已存在，请重新注册");
            return "error";
        }
    }

    @GetMapping("viewLogin")
    public String viewLogin(){
        return "viewLogin";
    }


    @PostMapping("/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response,
                              String username, String password, ModelAndView mv, HttpSession session) throws Exception {

        log.info("用户名:" + username);
        log.info("密码:" + password);

        if (businessService.findByUserName(username)==null){
            // 登录失败，设置失败信息，并转到登录页面
            mv.addObject("message","用户名或密码错误，请重新输入");
            //  登录失败，跳转页面
            mv.setViewName("error");
        }
        else{
            //  获取用户名，在数据库中
            User user = businessService.login(username);
            String psw = user.getPassword();

            if (Md5Util.getSaltverifyMD5(password,psw)){
               // 登陆成功，将user对象设置到HttpSession作用范围域中
                //session.setAttribute("user",user);

                try {
                    String tokens = JWTUtil.createToken(user);
                    System.out.println(tokens);

                    response.addCookie(CookieUtil.getLoginCookie("tokens",tokens));
                    log.info(new Date() + ": 用户登录成功！");
                } catch (Exception e) {
                    log.info("生成token失败！");
                    e.printStackTrace();
                }

                /*//ID和登录时间作为原密文
                String str = user.getId() + ":" + System.currentTimeMillis();
                log.info("原密文：" + str);
                //进行DES加密
                String token = DesUtil.encrypt(str,DesUtil.getkey());
                log.info("  DES加密后   token："  +  token);
                //将密文存入cookie,回写给用户
                response.addCookie(CookieUtil.getLoginCookie("token",token));*/

                mv.setViewName("home");
            }
            else {

                // 登录失败，设置失败信息，并转到登录页面
                mv.addObject("message","用户名或密码错误，请重新输入");
//            登录失败，跳转页面
                mv.setViewName("error");
            }

        }
//          有JWT做验证，普通cookie可以不用
        return mv;
    }
}
