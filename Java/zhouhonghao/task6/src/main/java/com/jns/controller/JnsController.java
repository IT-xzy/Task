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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
    //HttpServletRequest接受客户端发送的数据
    //HttpServletResponse负责向客户端发送的数据
    public ModelAndView Home(HttpServletRequest request) throws UnsupportedEncodingException {
        //由于每次打开一个会话，就会有一个新的session生成，但是cookie中保存着一个cookieid。
        //根据这个信息，借助cookie获取上一个session
        //获取cookie中的数据
        modelAndView.setViewName("home");
        Cookie[] cookies=request.getCookies();
        if(cookies!=null){
            for(Cookie cookie : cookies){
                //判断cookie中是否存在一个自定义名称是phone的数据
                if(cookie.getName().equals("phone")){
                    //把这个名是phone的数据的真实值设置成服务器端的session的属性值
                    request.getSession().setAttribute("name", URLDecoder.decode(cookie.getValue(),"utf-8"));
                    return modelAndView;
                } else {
                    request.getSession().setAttribute("name",null);
                }
            }
        }
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
