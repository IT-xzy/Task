package com.ptteng.controller;

import com.ptteng.entity.Classify;
import com.ptteng.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Controller
public class ClassifyController {
    @Autowired
    private ClassifyService service;

    @RequestMapping(value = "/a/u/classify/list", method = RequestMethod.GET)
    public ModelAndView getClassify(int page, int size, String keyword, Long collectionId) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("哈哈哈！我来了");
        System.out.println("page===" + page + ",size===" + size + ",keyword===" + keyword+",collectionId==" + collectionId);
        try {
            List<Classify> classifies = service.findPageClassify(page, size, keyword, collectionId);
            System.out.println(classifies);
            modelAndView.addObject("code", 0);
            modelAndView.addObject("data", classifies);
        } catch (Exception e) {
            modelAndView.addObject("code", -1);
        }
        int allPage = service.findClassifyAllPage(size);
        modelAndView.addObject("allPage",allPage);
        modelAndView.addObject("page",page);
        modelAndView.setViewName("classify");
        return modelAndView;
    }


    @RequestMapping(value = "/a/u/classify/search", method = RequestMethod.GET)
    public ModelAndView findById(long id) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("哈哈哈！我来了");
        System.out.println(id);
        Classify classify = service.findById(id);
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("star", classify);
        modelAndView.addObject("data",hashMap);
        System.out.println(hashMap);
        if (classify == null) {
            modelAndView.addObject("code", -1);
        } else {
            modelAndView.addObject("code", 0);
        }
        modelAndView.setViewName("classify");

        return modelAndView;
    }

    @RequestMapping(value = "/a/u/classify", method = RequestMethod.DELETE)
    public ModelAndView deleteById(long id) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("哈哈哈！我来了");
        System.out.println(id);
        Boolean row = service.deleteById(id);
        if (row = true) {
            modelAndView.addObject("code", 0);
        } else {
            modelAndView.addObject("code", -1);
        }
        modelAndView.setViewName("classify");
        return modelAndView;
    }

    @RequestMapping(value = "/a/u/classify",method = RequestMethod.PUT)
    public ModelAndView updateClassify(Classify classify) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("哈哈哈！我来了");
        System.out.println(classify);
        Boolean row = service.updateClassify(classify);
        if (row = true) {
            modelAndView.addObject("code", 0);
        } else {
            modelAndView.addObject("code", -1);
        }
        modelAndView.setViewName("classify");
        return modelAndView;
    }

    @RequestMapping(value = "/a/u/classify",method = RequestMethod.POST)
    public ModelAndView insertClassify(Classify classify){
        ModelAndView modelAndView=new ModelAndView();
        System.out.println("哈哈哈！我来了");
        System.out.println(classify);
        try{
            service.insertClassify(classify);
            modelAndView.addObject("code",0);
        }
        catch(Exception e){
            modelAndView.addObject("code",-1);
        }
        modelAndView.setViewName("classify");
        return modelAndView;
    }





}
