package com.ptteng.controller;

import com.ptteng.model.Occupation;
import com.ptteng.model.SignedUser;
import com.ptteng.model.Student;
import com.ptteng.model.User;
import com.ptteng.rmi.server.ServerA;
import com.ptteng.service.OccupationService;
import com.ptteng.service.SignUserService;
import com.ptteng.service.UserService;
import com.ptteng.util.GetCookieFromRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping
public class HomeController {
    @Autowired
    ServerA serverA;



    @Autowired
    GetCookieFromRequest cookieFromRequest;

    @RequestMapping(value = "/home1")
    public String home(Model model) throws Exception {
        OccupationService occupationService = serverA.getOccupationService() ;
        List<Student> students = occupationService.get1();
        model.addAttribute("list", students);
        return "home";
    }

    @RequestMapping(value = "/home2", method = RequestMethod.GET)
    public String home2(Model model) throws Exception {
        OccupationService occupationService = serverA.getOccupationService() ;
        List<Occupation> list = list = occupationService.get();
        model.addAttribute("list", list);
        return "home2";
    }

    @RequestMapping(value = "/u/home3", method = RequestMethod.GET)
    public String home3() throws Exception {
        return "home3";
    }


    //home4是个人页面。用来给报名课程的学员的查看当前信息。
    @RequestMapping(value = "/u/home4", method = RequestMethod.GET)
    public String home4(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        SignUserService signUserService = serverA.getSignUserService();
        Cookie cookie = cookieFromRequest.getCookie(request);
        long id = cookieFromRequest.getIdFromCookie(cookie);
        SignedUser signedUser = signUserService.getById(id);
        model.addAttribute("signedUser", signedUser);
        return "home4";
    }


    @RequestMapping(value = "/u/signin", method = RequestMethod.GET)
    public String signin(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserService userService = serverA.getUserService();
        Cookie cookie = cookieFromRequest.getCookie(request);
        long id = cookieFromRequest.getIdFromCookie(cookie);
        model.addAttribute("user", userService.getUserById(id));
        return "signin";
    }

    @RequestMapping(value = "/u/signin", method = RequestMethod.POST)
    @ResponseBody
    public boolean signin(HttpServletRequest request, User user) throws Exception {
        UserService userService = serverA.getUserService();
        System.out.println(user.toString());
        Cookie cookie = cookieFromRequest.getCookie(request);
        long id = cookieFromRequest.getIdFromCookie(cookie);
        user.setId(id);
        return userService.update(user);
    }
}
