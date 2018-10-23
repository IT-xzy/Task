package com.ptteng.controller;


import com.ptteng.entity.Workroom;
import com.ptteng.service.WorkroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WorkroomController {
    @Autowired
    private WorkroomService service;


    @RequestMapping(value = "/a/u/workroom/list", method = RequestMethod.GET)
    public ModelAndView findWorkroom(String type) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("type===" + type);
        try {
            List<Workroom> workrooms = service.findWorkroom(type);
            System.out.println(workrooms);
            modelAndView.addObject("data", workrooms);
            modelAndView.addObject("code", 0);
        } catch (Exception e) {
            modelAndView.addObject("code", -1);
        }
        modelAndView.setViewName("workroom");
        return modelAndView;
    }


    @RequestMapping(value = "/a/u/workroom/{id}", method = RequestMethod.GET)
    public ModelAndView findById(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("哈哈哈！我来了");
        System.out.println(id);
        Workroom workroom = service.findById(id);
        if (workroom == null) {
            modelAndView.addObject("code", -1);
        } else {
            modelAndView.addObject("code", 0);
        }
        modelAndView.setViewName("workroom");

        return modelAndView;
    }

    @RequestMapping(value = "/a/u/workroom/{id}", method = RequestMethod.DELETE)
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
        modelAndView.setViewName("workroom");
        return modelAndView;
    }

    @RequestMapping(value = "/a/u/workroom",method = RequestMethod.PUT)
    public ModelAndView updateWorkroom(Workroom workroom) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("哈哈哈！我来了");
        System.out.println(workroom);
        Boolean row = service.updateWorkroom(workroom);
        if (row = true) {
            modelAndView.addObject("code", 0);
        } else {
            modelAndView.addObject("code", -1);
        }
        modelAndView.setViewName("workroom");
        return modelAndView;
    }

    @RequestMapping(value = "/a/u/workroom",method = RequestMethod.POST)
    public ModelAndView insertWorkroom(Workroom workroom){
        ModelAndView modelAndView=new ModelAndView();
        System.out.println("哈哈哈！我来了");
        System.out.println(workroom);
        try{
            service.insertWorkroom(workroom);
            modelAndView.addObject("code",0);
        }
        catch(Exception e){
            modelAndView.addObject("code",-1);
        }
        modelAndView.setViewName("workroom");
        return modelAndView;
    }












}
