package com.jnshu.controller;

import com.jnshu.model.ShowreelTwo;
import com.jnshu.service.ShowreelTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ShowreelTwoController {
    @Autowired
    private ShowreelTwoService showreelTwoService;

    @RequestMapping(value = "/showreelTwo/list", method = RequestMethod.GET)
    public String getShowreelTwo(Model model) {
        System.out.println(123);
        List<ShowreelTwo> list = showreelTwoService.findAllShowreelTow();
        System.out.println(list);
        model.addAttribute("code", 200);
        model.addAttribute("data", list);
        return "work";
    }

    @RequestMapping(value = "/showreelTwo/list", method = RequestMethod.POST)
    public String postShowreelTwo(Model model, ShowreelTwo showreelTwo) {
        showreelTwo.setCreate_at(System.currentTimeMillis());
        showreelTwo.setUpdate_at(System.currentTimeMillis());
        long a = showreelTwoService.addShowreelTow(showreelTwo);
        if (a > 0) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        System.out.println(showreelTwo);
        return "work";
    }

    @RequestMapping(value = "/showreelTwo/list", method = RequestMethod.PUT)
    public String putShowreelTwo(Model model, ShowreelTwo showreelTwo) {
        showreelTwo.setUpdate_at(System.currentTimeMillis());
        if (showreelTwoService.updateShowreelTow(showreelTwo)) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        return "work";
    }

    @RequestMapping(value = "/showreelTwo/list/{id}", method = RequestMethod.GET)
    public String findShowreelTwo(@PathVariable("id") long id, Model model) {
        ShowreelTwo a = showreelTwoService.findByShowreelTow(id);
        if (a != null) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        return "work";

    }

    @RequestMapping(value = "/showreelTwo/list/{id}", method = RequestMethod.DELETE)
    public String deleteShowreelTwo(@PathVariable("id") long id, Model model) {
        if (showreelTwoService.deleteShowreelTow(id)) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        return "work";

    }
    
}
