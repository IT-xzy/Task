package com.ptteng.controller;


import com.ptteng.entity.Banner;
import com.ptteng.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BannerController {
    @Autowired
    private BannerService service;

    @RequestMapping(value = "/a/u/banner", method = RequestMethod.GET)
    public ModelAndView getBanner() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            List<Banner> bannerList = service.findBanner();
            System.out.println(bannerList);
            modelAndView.addObject("data",bannerList);
            modelAndView.addObject("code", 101);
        } catch (Exception e) {
            modelAndView.addObject("code", 102);
        }
        modelAndView.setViewName("banner");
        return modelAndView;
    }


    @RequestMapping(value = "/a/u/banner", method = RequestMethod.DELETE)
    public ModelAndView deleteByid(long id) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("哈哈哈！我来了");
        System.out.println(id);
        Boolean row = service.deleteById(id);
        if (row = true) {
            modelAndView.addObject("code", 0);
        } else {
            modelAndView.addObject("code", -1);
        }
        modelAndView.setViewName("banner");
        return modelAndView;
    }

    @RequestMapping(value = "/a/u/banner",method = RequestMethod.PUT)
    public ModelAndView updateBanner(Banner banner) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("哈哈哈！我来了");
        System.out.println(banner);
        Boolean row = service.updateBanner(banner);
        if (row = true) {
            modelAndView.addObject("code", 0);
        } else {
            modelAndView.addObject("code", -1);
        }
        modelAndView.setViewName("banner");
        return modelAndView;
    }

    @RequestMapping(value = "/a/u/banner",method = RequestMethod.POST)
    public ModelAndView insertBanner(Banner banner){
        ModelAndView modelAndView=new ModelAndView();
        System.out.println("哈哈哈！我来了");
        System.out.println(banner);
        try{
            service.insertBanner(banner);
            modelAndView.addObject("code",0);
        }
        catch(Exception e){
            modelAndView.addObject("code",-1);
        }
        modelAndView.setViewName("banner");
        return modelAndView;
    }




}
