package cn.wyq.controller;


import cn.wyq.pojo.Engineer;
import cn.wyq.service.EngineerService;
import cn.wyq.util.RmiServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EngineerController {
//    @Autowired
//    EngineerService engineerService;

    EngineerService engineerService = (EngineerService) new RmiServiceProxy().getEngineerService();
    ModelAndView modelAndView = new ModelAndView();

    @ResponseBody
    @RequestMapping(value = "/professions",method = RequestMethod.GET)
    public ModelAndView get(){
        List<Engineer> engineers = engineerService.get();
        modelAndView.addObject("engineers", engineers);
        modelAndView.setViewName("professions");
        return modelAndView;
    }
}
