package com.controller;

import com.checkGroups.LoginGroup;
import com.checkGroups.RegisterGroup;
import com.entity.User;
import com.service.CompanyService;
import com.service.ProfessionService;
import com.service.StudentsService;
import com.service.UserService;
import com.util.DateUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes("currentUser") //把当前用户留在session中
@RequestMapping("/jnshu")
public class Controller01 {
    @Autowired
    private ProfessionService professionService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private StudentsService studentsService;
    @Autowired
    private UserService userService;

    @RequestMapping("/main")
    public String main(Model model){
        model.addAttribute("allStudents",studentsService.countAll());//历史总人数
        model.addAttribute("onlineStudents",studentsService.count(1));//在线学习人数
        model.addAttribute("jobStudents",studentsService.count(2));//找到工作人数
        model.addAttribute("goodStudents",studentsService.listGood());//在状态2中随即抽取4个
        return "main";
    }

    @RequestMapping("/profession")
    public String profession(Model model){
        model.addAttribute("前端",professionService.findByStyle("前端"));
        model.addAttribute("后端",professionService.findByStyle("后端"));
        model.addAttribute("移动端",professionService.findByStyle("移动端"));
        model.addAttribute("全站",professionService.findByStyle("全站"));
        model.addAttribute("运维",professionService.findByStyle("运维"));
        return "profession";
    }
    @RequestMapping("/u/recommend")
    public String recommend(Model model,User user){
        model.addAttribute("company",companyService.findAll());
        return "recommend";
    }

    @RequestMapping("/date")
    public String tag(Model model){
        Long time = System.currentTimeMillis();
        Date date = new Date(time);
        String strTime = DateUtil.dateToYMDHMS(date);
        model.addAttribute("time1",time);
        model.addAttribute("time2",date);
        model.addAttribute("time4",DateUtil.dateToYMD(date));
        model.addAttribute("time5",DateUtil.dateToYMDHMS(date));
        model.addAttribute("time6",DateUtil.dateToYMDhms(date));
        model.addAttribute("time8",DateUtil.YMDToDate(strTime));
        model.addAttribute("time9",DateUtil.YMDHMSToDate(strTime));
        return "date";
    }

    Logger logger = Logger.getLogger(Controller01.class);

    /*进入登录页面*/
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    /*登录*/
    @RequestMapping("/toLogin")
    public String toLogin(HttpServletResponse response, HttpSession session, Model model,
                          @Validated({LoginGroup.class}) User user, BindingResult bindingResult){
        /*BindingResult是Errors的子类,专用来捕捉Validation验证错误*/
        if (bindingResult.hasErrors()){
            logger.info("输入信息格式有误");
            List<ObjectError> errors = bindingResult.getAllErrors();
            for(ObjectError error:errors)
                logger.info(error);
                model.addAttribute("error",errors);
                //有误返回登录页面
                return "login";
        }
        User result = userService.findByName(user.getName());
        if (null != result){
            session.setAttribute("sessionId",result.getId());
            session.setAttribute("loginName",result.getName());
            session.setAttribute("user",result);
            return "redirect:/jnshu/u/recommend";
        }else {
            model.addAttribute("message","用户名或密码错误,请重新登录");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout(Model model,HttpServletRequest request,HttpServletResponse response){
        userService.logout(response,request);
        model.addAttribute("message","已退出登录");
        return "login";
    }


    /*进入注册页面*/
    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/toRegister")
    public String toRegister(Model model,@Validated({RegisterGroup.class})User user,
                             BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info("输入格式错误");
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError error:errors)
                logger.info(error);
            model.addAttribute("errors",errors);
            return "register";
        }
        if (null != userService.findByName(user.getName())){
            logger.info("用户名已存在");
            model.addAttribute("message","用户名已存在");
            return "register";
        }else {
            logger.info("注册中...");
            Boolean flag = userService.register(user);
            if (!flag){
                logger.info("输入信息有误");
                model.addAttribute("message","输入信息有误");
                return "register";
            }
            logger.info("注册成功");
            model.addAttribute("message","注册成功,请登录");
            return "login";
        }
    }

}
