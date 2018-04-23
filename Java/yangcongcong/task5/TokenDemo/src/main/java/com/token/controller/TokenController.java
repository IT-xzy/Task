package com.token.controller;

import com.token.model.Home;
import com.token.model.Profession;
import com.token.model.UserInfo;
import com.token.service.HomeService;
import com.token.service.ProfessionService;
import com.token.service.UserInfoService;
import com.token.utils.DesUtil;
import com.token.utils.MD5Util2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class TokenController {
    private final Logger logger = LoggerFactory.getLogger(TokenController.class);

    @Autowired
    private HomeService homeService;
    @Autowired
    private ProfessionService professionService;
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/home")
    public String landing(Model model) {
        List<Home> homeList = homeService.getAll();
        model.addAttribute("homeList", homeList);

        Home home = homeList.get(homeList.size()-1);
        model.addAttribute("home", home);

        long time=System.currentTimeMillis();
        model.addAttribute("time", time);
        return "t10";
    }

    @RequestMapping("/u/home/profession")
    public String profession(Model model) {
        List<Profession> professionList = professionService.getAll();
        model.addAttribute("professionList", professionList);
        long time=System.currentTimeMillis();
        model.addAttribute("time", time);
        return "t11";
    }

    //登陆页面
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(UserInfo userInfo, HttpServletResponse response) throws Exception {
        logger.info("/login POST  the username is={},pwd is ={}",userInfo.getUsername(),userInfo.getPassword());

        //加密username和登录时间，添加cookie
        String content=""+userInfo.getUsername()+"."+System.currentTimeMillis();
        String token = DesUtil.encrypt(content);

        //验证用户名和密码是否正确
        UserInfo queriedUser = userInfoService.getByName(userInfo.getUsername());
        if (queriedUser != null) {
            if (MD5Util2.verify(userInfo.getPassword(), queriedUser.getPassword())) {
                    Cookie cookie = new Cookie("token", token);
                    cookie.setMaxAge(999999);
                    response.addCookie(cookie);
                return "redirect:/u/home/profession";
            } else {
                return "userLogin";
            }
        } else {
            return "userLogin";
        }
    }

    //注册用户，并返回登陆页面
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(UserInfo userInfo) {
        logger.info("/register POST the UserInfo is ======{}",userInfo.getUsername());
        userInfo.setPassword(MD5Util2.md5Salt(userInfo.getPassword()));
        userInfo.setCreate_at(System.currentTimeMillis());
        userInfo.setUpdate_at(System.currentTimeMillis());
        userInfoService.add(userInfo);
        return "redirect:/land";
    }

    //跳转到登陆
    @RequestMapping(value = "/land", method = RequestMethod.GET)
    public String toLogin() {
        return "userLogin";
    }

    //跳转到注册
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String toRegister() {
        return "userRegister";
    }

    @RequestMapping("/")
    public String welcome() {
        return "welcome";
    }

}
