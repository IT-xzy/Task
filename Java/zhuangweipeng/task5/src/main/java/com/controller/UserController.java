package com.controller;

import com.dao.UserMapper;
import com.entity.Excellent_Stu;
import com.entity.User;
import com.service.UserService;
import com.utils.DesUtil;
import com.utils.Md5Util;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    private static final Log logger = LogFactory.getLog(UserController.class);
    @Autowired
    private UserService userService;

    //@Autowired
    //private UserMapper userMapper;


    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String login(@Param("name") String name, @Param("password") String password, Model model, HttpServletRequest request, HttpServletResponse response, User user)
            throws Exception {
        logger.info("------进入login控制类------");

        if (userService.findUserByName(user.getName()) == null) {
            return "redirect:login/false.jsp";
        }
        boolean isUserEistence = userService.judgeUser(name, password);
        //验证用户名和密码，匹配登录成功
        //String login = null;
        if (isUserEistence) {
            String loginToken = userService.saveToken(name);
            //保存Cookie
            System.out.println(loginToken);
            Cookie tokenCookie = new Cookie("loginToken", loginToken);
            tokenCookie.setMaxAge(30 * 60);
            System.out.println(loginToken);
            response.addCookie(tokenCookie);


            //保存到session中
            HttpSession loginSession = request.getSession();
            DesUtil desUtil = new DesUtil("Hello");
            loginSession.setAttribute("loginSession", desUtil.decrypt(loginToken));
            //login = "success";
            List<Excellent_Stu> excellent_stus = userService.getAll();
            List<Excellent_Stu> limit = userService.limit();
            model.addAttribute("userService", userService);
            //
            //从优秀学员表中取出数据展示
            Excellent_Stu u = excellent_stus.get(1);
            //User user = new User();
            logger.info("User user = new User();user:" + user);
            //查询学习人数
            model.addAttribute("studynum", u.getStudynum());
            model.addAttribute("jobnum", u.getJobnum());
            model.addAttribute("limit", limit);
            model.addAttribute("name", user.getName());
            return "home";
        }
        return "redirect:login/false.jsp";
    }


    @RequestMapping(value = {"/home1"}, method = RequestMethod.GET)
    public String home(Model model) {

        //查询数据库优秀学员信息展示
        List<Excellent_Stu> excellent_stus = userService.getAll();
        List<Excellent_Stu> limit = userService.limit();
        model.addAttribute("userService", userService);

        //从优秀学员表中取出数据展示
        Excellent_Stu u = excellent_stus.get(1);

        //查询学习人数
        model.addAttribute("studynum", u.getStudynum());
        model.addAttribute("jobnum", u.getJobnum());
        model.addAttribute("limit", limit);
        return "home1";
    }


    //注册页面
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String register(User user) {
        logger.info("------register方法运行------" + user.toString());
        if (user.getName() != " " && user.getPassword() != " " && userService.findUserByName(user.getName()) == null) {
            userService.addUser(user);
            return "redirect:/register/success.jsp";
        } else {
            return "redirect:/register/error.jsp";
        }
    }

    ////注册页面
    //@RequestMapping(value = "/registration", method = RequestMethod.POST)
    //public String register(User user) {
    //    logger.info("------register方法运行------" + user.toString());
    //    if (user.getName() == " " || user.getPassword() == " " || userService.findUserByName(user.getName()) != null
    //            ||user.getName()==""||user.getPassword()=="") {
    //        return "redirect:/register/error.jsp";
    //
    //    } else {
    //        userService.addUser(user);
    //        return "redirect:/register/success.jsp";
    //    }
    //}

    //    登出页面
    @RequestMapping("/logout")
    public String logout(HttpSession session, HttpServletRequest httpServletRequest, HttpServletResponse response) throws Exception {
        Cookie[] cookies = httpServletRequest.getCookies();
        //清除session
        session.invalidate();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("loginToken")) {
                //logger.info("Cookie" + cookie.getName());
                Cookie newCookie = new Cookie("loginToken", null); //假如要删除名称为username的Cookie
                newCookie.setMaxAge(0); //立即删除型
                newCookie.setPath("/"); //项目所有目录均有效，这句很关键，否则不敢保证删除
                response.addCookie(newCookie);//重新写入，将覆盖之前的Cookie
            }
        }
        return "redirect:/login/reLogin.jsp";
    }
}