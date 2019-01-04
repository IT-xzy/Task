package com.xiaobo.demo.controller;

import com.alibaba.fastjson.JSON;
import com.xiaobo.demo.pojo.ExcellentStudent;
import com.xiaobo.demo.pojo.Profession;
import com.xiaobo.demo.pojo.Response;
import com.xiaobo.demo.pojo.User;
import com.xiaobo.demo.service.CommonService;
import com.xiaobo.demo.service.ExcellentStudentService;
import com.xiaobo.demo.service.ProfessionService;
import com.xiaobo.demo.service.UserService;
import com.xiaobo.demo.util.CommonUtil;
import com.xiaobo.demo.util.CookieUtil;
import com.xiaobo.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/a")
public class ExcellentStudentController {
    private static Logger log = Logger.getLogger(ExcellentStudentController.class);
    @Autowired
    private ExcellentStudentService excellentStudentService;
    @Autowired
    private ExcellentStudent excellentStudent;
    @Autowired
    private ProfessionService professionService;
    @Autowired
    private Profession profession;
    @Autowired
    private User user;
    @Autowired
    private UserService userService;
    @Autowired
    private CommonUtil commonUtil;
    @Autowired
    private CommonService commonService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private CookieUtil cookieUtil;
    @GetMapping(value = "/u/home")
    public ModelAndView getHome(){

        ModelAndView modelAndView = new ModelAndView("home");
        Map<String,Object> pageData = new HashMap<>();
        pageData.put("offset",0);
        pageData.put("limit",4);
        Integer totolStudent = commonService.getTotal("excellent_student");
        ExcellentStudent excellentStudent = new ExcellentStudent();
        excellentStudent.setStatus(ExcellentStudent.EXCELLENT_STUDENT_STATUS_GRADUATED);
        Integer graduatedStudent = excellentStudentService.countData(excellentStudent);
        List<ExcellentStudent> excellentStudentList = excellentStudentService.selectBySalary(excellentStudent,pageData);
        modelAndView.addObject("data",excellentStudentList);
        modelAndView.addObject("totalStudent",totolStudent);
        modelAndView.addObject("graduatedStudent",graduatedStudent);
        return modelAndView;
    }
    @GetMapping(value = "/u/profession")
    public ModelAndView getProfession(){
        ModelAndView modelAndView = new ModelAndView("profession");
        Profession profession = new Profession();
        profession.setDevelopmentDirection(Profession.OPTION_DEVELOPMENT_DIRECTION_FRONTEND);
        List<Profession> professionList1 = professionService.selectByDevelopmentDirection(profession);
        ArrayList professionCountList1 = excellentStudentService.createCountArrayList(professionList1);

        profession.setDevelopmentDirection(Profession.OPTION_DEVELOPMENT_DIRECTION_BACKEND);
        List<Profession> professionList2 = professionService.selectByDevelopmentDirection(profession);
        ArrayList professionCountList2 = excellentStudentService.createCountArrayList(professionList2);

        profession.setDevelopmentDirection(Profession.OPTION_DEVELOPMENT_DIRECTION_OP);
        List<Profession> professionList3 = professionService.selectByDevelopmentDirection(profession);
        ArrayList professionCountList3 = excellentStudentService.createCountArrayList(professionList3);

        modelAndView.addObject("professionList1",professionList1);
        modelAndView.addObject("professionList2",professionList2);
        modelAndView.addObject("professionList3",professionList3);

        modelAndView.addObject("professionCountList1",professionCountList1);
        modelAndView.addObject("professionCountList2",professionCountList2);
        modelAndView.addObject("professionCountList3",professionCountList3);
        return modelAndView;
    }
    @GetMapping(value = "/login")
    public ModelAndView getLogin(){
        return new ModelAndView("login");
    }
    @PostMapping(value = "/login")
    public ModelAndView postLogin(User user, HttpServletResponse httpServletResponse){
        System.out.println(user);
        log.warn(user);
        ModelAndView modelAndView = new ModelAndView("response");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Response response;
        if(user.getUsername()==null||user.getUsername().length()==0||user.getPassword()==null||user.getPassword().length()==0){
            response = new Response(400,"用户名或密码不能为空");
        }else{
            User userResult = userService.getByUsername(user);
            if(userResult == null){
                response = new Response(400,"用户名不存在");
            }else if(!encoder.matches(user.getPassword(),userResult.getPassword())){
                response = new Response(400,"密码错误");
            }else{
                try{
                    String token = jwtUtil.createToken(userResult.getId().longValue());
                    System.out.println(token);
                    log.warn(token);
                    cookieUtil.addCookie(httpServletResponse,token);
                }catch(Exception e){
                    System.out.println(e);
                }
                return new ModelAndView("redirect:/a/u/home");
            }
        }
        modelAndView.addObject("data",response);
        return modelAndView;


    }
    @GetMapping(value = "/register")
    public ModelAndView getRegister(){
        return new ModelAndView("register");
    }
    @PostMapping(value = "/register")
    public ModelAndView postRegister(User user){
        System.out.println(user);
        log.warn(user);
        ModelAndView modelAndView = new ModelAndView("response");
        Response response;
        if(user.getUsername()==null||user.getUsername().length()==0||user.getPassword()==null||user.getPassword().length()==0){
            response = new Response(400,"用户名或密码不能为空");
        }else{
            Boolean result = commonService.isDataExist("user","username",user.getUsername());
            if(result){
                response = new Response(400,"用户名已存在");
            }else{
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                user.setPassword(encoder.encode(user.getPassword()));
                Boolean insertResult = userService.insert(user);
                response = insertResult? new Response():new Response(400,"数据库操作失败");
                return insertResult?new ModelAndView("redirect:/a/login"):new ModelAndView("response","data",response);
            }
        }
        modelAndView.addObject("data",response);
        return modelAndView;
    }
    @GetMapping(value = "/logout")
    public ModelAndView getLogout(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
        cookieUtil.deleteCookie(httpServletRequest,httpServletResponse);
        return new ModelAndView("logout");
    }
}
