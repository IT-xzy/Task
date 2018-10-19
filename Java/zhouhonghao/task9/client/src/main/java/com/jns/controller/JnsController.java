package com.jns.controller;

import com.jns.entity.Jns;
import com.jns.service.JnsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
//所有响应请求的方法都是以该地址作为父路径。
@RequestMapping("")
public class JnsController {

    //借助slf4j记录日志
    Logger logger= LoggerFactory.getLogger(JnsController.class);
    ModelAndView modelAndView=new ModelAndView();


    //调用service层的JnsService类
    @Autowired
    JnsService jnsService;


    //指定请求的实际地址，请求的method类型
    //首页
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public ModelAndView Home(HttpServletRequest request) throws UnsupportedEncodingException {
        HttpSession session=request.getSession();
        System.out.println("session值"+session.getAttribute("name"));
        modelAndView.setViewName("home");
        return modelAndView;
    }


    //职位页面
    @RequestMapping(value = "/job",method = RequestMethod.GET)
    public String Job(Model model){
        List<Jns> jnt=jnsService.list();
        model.addAttribute("subject",jnt);
        return "job";
    }


    //推荐页面
    @RequestMapping(value = "/offer",method = RequestMethod.GET)
    public ModelAndView Offer(){
        modelAndView.setViewName("offer");
        return modelAndView;
    }
}
