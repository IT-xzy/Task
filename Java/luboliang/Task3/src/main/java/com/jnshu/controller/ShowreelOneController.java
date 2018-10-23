package com.jnshu.controller;

import com.jnshu.model.ShowreelOne;
import com.jnshu.service.ShowreelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ShowreelOneController {
    @Autowired
    ShowreelService showreelService;

    @RequestMapping(value = "/showreelone/list", method = RequestMethod.GET)
    public String getShowreelOne(Model model) {
        System.out.println(123);
        List<ShowreelOne> list = showreelService.findAllShowreelOne();
        System.out.println(list);
        model.addAttribute("code", 200);
        model.addAttribute("data", list);
        return "showreelone";
    }

    @RequestMapping(value = "/showreelone/list", method = RequestMethod.POST)
    public String postShowreelOne(ShowreelOne showreelOne, Model model) {
        showreelOne.setCreate_at(System.currentTimeMillis());
        showreelOne.setUpdate_at(System.currentTimeMillis());
        long a = showreelService.addShowreelOne(showreelOne);
        if (a > 1) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        return "showreelone";
    }
    @RequestMapping(value = "/showreelone/list", method = RequestMethod.PUT)
    public String putShowreelOne(Model model, ShowreelOne showreel) {
        showreel.setUpdate_at(System.currentTimeMillis());
        if (showreelService.updateShowreelOne(showreel)) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        return "showreelone";
    }

    @RequestMapping(value = "/showreelone/list/{id}", method = RequestMethod.GET)
    public String findShowreelOne(@PathVariable("id") long id, Model model) {
        ShowreelOne a = showreelService.findByShowreelOne(id);
        if (a != null) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        return "showreelone";

    }

    @RequestMapping(value = "/showreelone/list/{id}", method = RequestMethod.DELETE)
    public String deleteShowreelOne(@PathVariable("id") long id, Model model) {
        if (showreelService.deleteShowreelOne(id)) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        return "showreelone";

    }

}
