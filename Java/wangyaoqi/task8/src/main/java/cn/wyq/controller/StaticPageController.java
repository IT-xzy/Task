package cn.wyq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StaticPageController {
    ModelAndView modelAndView = new ModelAndView();

    @RequestMapping(value = "/job")
    public ModelAndView job(){
        modelAndView.setViewName("job");
        return modelAndView;
    }
}
