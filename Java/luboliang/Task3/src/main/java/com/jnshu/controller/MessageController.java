package com.jnshu.controller;

import com.jnshu.model.Message;
import com.jnshu.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class MessageController {
    @Resource
    MessageService messageService;
    @RequestMapping(value = "/message/list", method = RequestMethod.GET)
    public String getMessage(Model model) {
        List<Message> list = messageService.findAllMessage();
        System.out.println(list);
        model.addAttribute("code", 200);
        model.addAttribute("data", list);
        return "work";
    }

    @RequestMapping(value = "/message/list", method = RequestMethod.POST)
    public String postMessage(Model model, Message message) {
        message.setMessage_time(System.currentTimeMillis());
        message.setUpdate_at(System.currentTimeMillis());
        long a = messageService.addMessage(message);
        if (a > 0) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        System.out.println(message);
        return "work";
    }

    @RequestMapping(value = "/message/list", method = RequestMethod.PUT)
    public String putMessage(Model model, Message message) {
        message.setUpdate_at(System.currentTimeMillis());
        if (messageService.updateMessage(message)) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        return "work";
    }

    @RequestMapping(value = "/message/list/{id}", method = RequestMethod.GET)
    public String findMessage(@PathVariable("id") long id, Model model) {
        Message a = messageService.findByMessage(id);
        if (a != null) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        return "work";

    }

    @RequestMapping(value = "/message/list/{id}", method = RequestMethod.DELETE)
    public String deleteMessage(@PathVariable("id") long id, Model model) {
        if (messageService.deleteMessage(id)) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        return "work";

    }

}
