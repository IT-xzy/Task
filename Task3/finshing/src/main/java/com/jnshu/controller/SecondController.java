package com.jnshu.controller;


import com.jnshu.entity.Second;
import com.jnshu.service.SecondService;
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
public class SecondController {
    Logger logger = LogManager.getLogger(FirstController.class.getName());
    //搜索获取作品列表
    @Autowired
    SecondService secondService;
    //搜索作品类型获取作品集分类列表(二级标题接口)
    @RequestMapping(value = "/second/list", method = RequestMethod.GET)
    public ModelAndView findSelectiveSecond(boolean state , String name , Long firstId,ModelAndView modelAndView){
        logger.info("findSelect====\n"+ "state====="
                + state + "\n+name=====" + name+"\nfirstId"+firstId);
        Second second = new Second();
        second.setStatus(state);
        second.setName(name);
        second.setFirstId(firstId);
        List secondList = secondService.select(second);
        logger.info("findSelectiveSecond===========\n"+"secondList"+secondList);
        if (secondList != null) {
            modelAndView.addObject("second", secondList);
            modelAndView.addObject("code", 100);//查找成功
        }else{
            modelAndView.addObject("code", -101);//您所查找的记录不存在
        }
        modelAndView.setViewName("showSecondJsonFormat");
        return modelAndView;
    }
}
