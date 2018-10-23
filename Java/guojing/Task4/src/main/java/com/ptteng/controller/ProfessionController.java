package com.ptteng.controller;

import com.ptteng.entity.Profession;
import com.ptteng.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
@Controller
public class ProfessionController {

    @Autowired
    private ProfessionService professionService;

    @RequestMapping(value = "/profession",method = RequestMethod.GET)
    public ModelAndView findProfession(){
        System.out.println("哈哈哈，我来职业了！");
        ModelAndView modelAndView=new ModelAndView();
//        获取所有的职业列表信息
        List<Profession> professions=professionService.findProfession();
        List<Profession> list1=new ArrayList<>();
        List<Profession> list2=new ArrayList<>();
//        循环遍历所有的职业列表信息，方向为前端的放在一个list集合里面……
        for(Profession p:professions){
            switch (p.getDirection()){
                case "前端开发方向":
                    list1.add(p);
                    break;
                case "后端开发方向":
                    list2.add(p);
                    break;
            }
        }
        System.out.println(list1);
        System.out.println(list2);
        modelAndView.addObject("item","body3");
        modelAndView.addObject("data1",list1);
        modelAndView.addObject("data2",list2);
        modelAndView.setViewName("myView");
        return modelAndView;
    }



}
