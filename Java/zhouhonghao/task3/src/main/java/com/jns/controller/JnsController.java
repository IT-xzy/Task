package com.jns.controller;

import com.jns.pojo.Jns;
import com.jns.service.JnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("")
public class JnsController {
    @Autowired
    JnsService jnsService;

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public ModelAndView Home(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        if(cookies!=null){
            for(Cookie cookie : cookies){
                System.out.println("cookie"+cookie.getName());
                if(cookie.getName().equals("session")){
                    System.out.println("session:"+cookie.getName()+cookie.getValue());
                    request.getSession().setAttribute("name",cookie.getValue());
                }
                if(!cookie.getName().equals("token") &&cookies.length<3){
                    System.out.println("session:"+cookie.getName()+cookie.getValue());
                    request.getSession().setAttribute("name",null);
                    ModelAndView modelAndView=new ModelAndView();
                    modelAndView.setViewName("home");
                    return modelAndView;
                }
            }
        }
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }
    @RequestMapping(value = "/u/job",method = RequestMethod.GET)
    public String Job(Model model){
        List<Jns> jnt=jnsService.list();
        model.addAttribute("subject",jnt);
        return "job";
    }
    @RequestMapping(value = "/offer",method = RequestMethod.GET)
    public ModelAndView Offer(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("offer");
        return modelAndView;
    }
    @RequestMapping(value = "/about",method = RequestMethod.GET)
    public ModelAndView About(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("about");
        return modelAndView;
    }

}
