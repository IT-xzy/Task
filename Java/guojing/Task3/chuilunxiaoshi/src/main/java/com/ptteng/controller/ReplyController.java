package com.ptteng.controller;


import com.ptteng.entity.Reply;
import com.ptteng.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ReplyController {
@Autowired
    private ReplyService service;

    @RequestMapping(value = "/a/u/reply", method = RequestMethod.GET)
    public ModelAndView getReply(long bbsId) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("哈哈哈！我来了");
        System.out.println("message===" + bbsId);

        try {
            List<Reply> replyList = service.findReply(bbsId);
            System.out.println(replyList);
            modelAndView.addObject("data", replyList);
            modelAndView.addObject("code", 0);
        } catch (Exception e) {
            modelAndView.addObject("code", -1);
        }

        modelAndView.setViewName("reply");
        return modelAndView;
    }



    @RequestMapping(value = "/a/u/reply", method = RequestMethod.DELETE)
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
        modelAndView.setViewName("reply");
        return modelAndView;
    }

    @RequestMapping(value = "/a/u/reply",method = RequestMethod.PUT)
    public ModelAndView updateReply(Reply reply) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("哈哈哈！我来了");
        System.out.println(reply);
        Boolean row = service.updateReply(reply);
        if (row = true) {
            modelAndView.addObject("code", 0);
        } else {
            modelAndView.addObject("code", -1);
        }
        modelAndView.setViewName("reply");
        return modelAndView;
    }

    @RequestMapping(value = "/a/u/reply",method = RequestMethod.POST)
    public ModelAndView insertReply(Reply reply){
        ModelAndView modelAndView=new ModelAndView();
        System.out.println("哈哈哈！我来了");
        System.out.println(reply);
        try{
            service.insertReply(reply);
            modelAndView.addObject("code",0);
        }
        catch(Exception e){
            modelAndView.addObject("code",-1);
        }
        modelAndView.setViewName("reply");
        return modelAndView;
    }




}
