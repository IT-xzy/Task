package com.controller;

import com.encryption.JWT;
import com.encryption.RegularExpression;
import com.pojo.OccupationReunite;
import com.pojo.SignIn;
import com.pojo.Student;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
public class UserController {
    @Autowired
    public UserService userService;
    //跳转主页面
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(){
        return "home";
    }
    //T0页面
    @RequestMapping(value = "/T0",method = RequestMethod.GET)
    public String T0(Model model){
        //优秀的学生
        List<Student> list=userService.queryStudent("满意");
        //累计在学人数
        model.addAttribute("accumulativeLearning",userService.statisticsInLearning("在学"));
        //找到满意工作的人数
        model.addAttribute("accumulativeWork",userService.statisticaljobSatisfaction("满意"));
        //model封装优秀学员
        model.addAttribute("list",list);
        return "T0Layout";
    }
    //T1页面
    @RequestMapping(value = "/u/T1",method = RequestMethod.GET)
    public String T1(Model model){
        //职业列表
        List<OccupationReunite> occupationReuniteList=userService.queryOccupationReunite("前端开发");

        //model封装职业
        model.addAttribute("list",occupationReuniteList);
        return "T1Layout";
    }
    //登录按键控制器，按下按键跳转到登录表单页面
    @RequestMapping(value = "/Login",method = RequestMethod.GET)
    public ModelAndView SignIn()
    {
        ModelAndView modelAndView=new ModelAndView();
        //进入登录表单页面
        modelAndView.setViewName("Login");

        return modelAndView;
    }

    //登录接收form表单控制器
    @RequestMapping(value = "/success",method = RequestMethod.POST)
    public ModelAndView success(Student student, HttpServletResponse response){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("loginInformation");

        Student student1=userService.signIn(student);
        if (student1!=null) {
            //设置登录页面信息
            modelAndView.addObject("information", "登录成功");
            //因为JWT没有加密机制，所以登录类封装用户的非私密信息作为荷载
            SignIn signIn=new SignIn();
            signIn.setId(student1.getId());
            signIn.setName(student1.getName());
            //使用cookie封装JWT给到客户端浏览器
            Cookie cookie=new Cookie("JWT",JWT.sign(signIn,1000L*60L*30L));
            //将Cookie丢给浏览器
            cookie.setPath("/");
            response.addCookie(cookie);
        } else {
            modelAndView.addObject("information", "登录失败");
        }
        return modelAndView;
    }
    //注销登录信息
    @RequestMapping(value = "/remove",method = RequestMethod.GET)
    public String remove(HttpServletResponse response){
        //通过设置生存期为0,删除掉客户端的Cookie
        Cookie cookie=new Cookie("JWT","");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }

    //跳转注册控制器
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    //注册控制器
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String Submission(Student student,Model model){
        if(RegularExpression.checkUsername(student.getAccountNumber())&&
                RegularExpression.checkPwd(student.getPassword())) {
            try {
                userService.registerStudent(student);
            }catch (Exception e){
                model.addAttribute("prompt","账号已存在");
                return "registerError";
            }

        }else {
            model.addAttribute("prompt","账号或密码格式错误");
            return "registerError";
        }
        return "redirect:/";
    }
}
