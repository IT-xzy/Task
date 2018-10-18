package com.jnshu.controller;

import com.jnshu.entity.Workroom;
import com.jnshu.service.WorkroomService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("a/u/")
public class WorkroomController {
    Logger logger = LogManager.getLogger(ArtController.class.getName());
    @Autowired
    WorkroomService workroomService;
    @RequestMapping(value = "/workroom/list", method = RequestMethod.GET)
    public ModelAndView findSelectiveWorkRoom(boolean state, boolean type , ModelAndView modelAndView){
        logger.info("findSelectiveWorkRoom=====\n"+ "state=====" + state + "\n type======"+type);
        Workroom workroom = new Workroom();
        workroom.setStatus(state);
        workroom.setType(type);
        List<Workroom> workroomList = workroomService.select(workroom);
        logger.info("findSelectiveWorkRoom===========\n"+ workroomList +"\n");
        if (workroomList != null) {
            modelAndView.addObject("workroom", workroomList);
            modelAndView.addObject("code", 100);//查找成功
        }else{
            modelAndView.addObject("code", -101);//您所查找的记录不存在
        }
        modelAndView.setViewName("showWorkroomJsonFormat");
        return modelAndView;
    }
}
