package com.ptteng.controller;


import com.ptteng.entity.Bbs;
import com.ptteng.service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class BbsController {

    @Autowired
    private BbsService service;

    @RequestMapping(value = "/a/u/bbs",method = RequestMethod.POST)
    public ModelAndView insertBbs(Bbs bbs) {
        ModelAndView modelAndView=new ModelAndView();
        System.out.println("哈哈哈！我来了");
        System.out.println(bbs);
        try{service.insertBbs(bbs);
            System.out.println(bbs.getId());
            modelAndView.addObject("code",0);}
        catch(Exception e){
            modelAndView.addObject("code",-1);
        }
        modelAndView.setViewName("bbs");
        return modelAndView;
    }


    @RequestMapping(value = "/a/u/bbs", method = RequestMethod.GET)
    public ModelAndView findById(Bbs bbs) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("哈哈哈！我来了");
        System.out.println(bbs);
        List<Bbs> bbsList= service.findMessage(bbs);
        System.out.println(bbsList);
        modelAndView.addObject("data", bbsList);
        if (bbsList == null) {
            modelAndView.addObject("code", -1);
        } else {
            modelAndView.addObject("code", 0);
        }
        modelAndView.setViewName("bbs");

        return modelAndView;
    }



    @RequestMapping(value = "/a/u/bbs",method = RequestMethod.PUT)
    public ModelAndView updateBbs(Bbs bbs) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("哈哈哈！我来了");
        System.out.println(bbs);
        Boolean row = service.updateBbs(bbs);
        if (row = true) {
            modelAndView.addObject("code", 0);
        } else {
            modelAndView.addObject("code", -1);
        }
        modelAndView.setViewName("bbs");
        return modelAndView;
    }

    @RequestMapping(value = "/a/u/bbs/{id}", method = RequestMethod.DELETE)
    public ModelAndView deleteById(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("哈哈哈！我来了");
        System.out.println(id);
        Boolean row = service.deleteById(id);
        if (row = true) {
            modelAndView.addObject("code", 0);
        } else {
            modelAndView.addObject("code", -1);
        }
        modelAndView.setViewName("bbs");
        return modelAndView;
    }



}







