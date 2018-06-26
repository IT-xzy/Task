package com.task.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/fun")
public class FunController {

//    private static final Logger logger = LoggerFactory.getLogger(FunController.class);


    @RequestMapping(value = "/manage",method = RequestMethod.GET)
    public ModelAndView getManage(){

        ModelAndView mav = new ModelAndView();
//        logger.info("getManage");

        mav.addObject("manage","getManage");
        mav.setViewName("funList");
        return mav;

    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public ModelAndView getUser(){

//        logger.info("getUser");

        ModelAndView mav = new ModelAndView();
        mav.addObject("req","getUser");

        mav.setViewName("funList");
        return mav;
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public ModelAndView addUser(){
//        logger.info("addUser");
        ModelAndView mav = new ModelAndView();
        mav.addObject("req","addUser");
        mav.setViewName("funList");

        return mav;
    }

    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public ModelAndView deleteUser(){
//        logger.info("deleteUser");
        ModelAndView mav = new ModelAndView();
        mav.addObject("req","deleteUser");
        mav.setViewName("redirect:/fun/manage");

        return mav;
    }

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public ModelAndView updateUser(){
//        logger.info("updateUser");

        ModelAndView mav = new ModelAndView();

        mav.addObject("req","updateUser");

        mav.setViewName("redirect:/fun/manage");

        return mav;
    }
}
