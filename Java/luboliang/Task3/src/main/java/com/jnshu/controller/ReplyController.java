package com.jnshu.controller;

import com.jnshu.model.Reply;
import com.jnshu.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @RequestMapping(value = "/reply/list", method = RequestMethod.GET)
    public String getReply(Model model) {
        System.out.println(123);
        List<Reply> list = replyService.findAllReply();
        System.out.println(list);
        model.addAttribute("code", 200);
        model.addAttribute("data", list);
        return "reply";
    }

    @RequestMapping(value = "/reply/list", method = RequestMethod.POST)
    public String postReply(Model model, Reply reply) {
        reply.setCreate_at(System.currentTimeMillis());
        reply.setUpdate_at(System.currentTimeMillis());
        reply.setReply_time(System.currentTimeMillis());
        long a = replyService.addReply(reply);
        if (a > 0) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        System.out.println(reply);
        return "reply";
    }

    @RequestMapping(value = "/reply/list", method = RequestMethod.PUT)
    public String putReply(Model model, Reply reply) {
        reply.setUpdate_at(System.currentTimeMillis());
        if (replyService.updateReply(reply)) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        return "reply";
    }

    @RequestMapping(value = "/reply/list/{id}", method = RequestMethod.GET)
    public String findReply(@PathVariable("id") long id, Model model) {
        Reply a = replyService.findByReply(id);
        if (a != null) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        return "reply";

    }

    @RequestMapping(value = "/reply/list/{id}", method = RequestMethod.DELETE)
    public String deleteReply(@PathVariable("id") long id, Model model) {
        if (replyService.deleteReply(id)) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        return "reply";

    }

}
