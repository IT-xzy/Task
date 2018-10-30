package com.jnshu.controller;

import com.jnshu.entity.First;
import com.jnshu.service.FirstService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/a/u")
public class FirstController {
    Logger logger = LogManager.getLogger(FirstController.class.getName());
    //搜索获取作品列表
    @Autowired
    FirstService firstService;
    @RequestMapping(value = "/first/list", method = RequestMethod.GET)
    public ModelAndView findSelectiveFirst(boolean state ,String name , ModelAndView modelAndView){
        logger.info("findSelect====\n"+ "status====="
                + state + "\n+name=====" + name);
        First first = new First();
        first.setStatus(state);
        first.setName(name);
        List firstList = firstService.select(first);
        logger.info("findSelectiveFirst===========\n"+" firstService.select(first)\n");
        if (firstList != null) {
            modelAndView.addObject("first", firstList);
            modelAndView.addObject("code", 100);//查找成功
        }else{
            modelAndView.addObject("code", -101);//您所查找的记录不存在
        }
        modelAndView.setViewName("showFirstJsonFormat");
        return modelAndView;
    }
}
