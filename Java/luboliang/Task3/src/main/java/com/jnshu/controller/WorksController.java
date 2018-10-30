package com.jnshu.controller;

import com.jnshu.model.Workss;
import com.jnshu.service.ShowreelService;
import com.jnshu.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sun.awt.SunHints;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class WorksController {
    @Resource
    WorksService worksService;

    @RequestMapping(value = "/works/list", method = RequestMethod.GET)
    public String getWorks(Model model) {
        List<Workss> list = worksService.findAllWorkss();
        System.out.println(list);
        model.addAttribute("code", 200);
        model.addAttribute("data", list);
        return "work";
    }

    @RequestMapping(value = "/works/list", method = RequestMethod.POST)
    public String postWorks(Model model, Workss workss) {
        workss.setCreate_at(System.currentTimeMillis());
        workss.setUpdate_at(System.currentTimeMillis());
        long a = worksService.addWorkss(workss);
        if (a > 0) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        System.out.println(workss);
        return "work";
    }

    @RequestMapping(value = "/works/list", method = RequestMethod.PUT)
    public String putWorks(Model model, Workss workss) {
        workss.setUpdate_at(System.currentTimeMillis());
        if (worksService.updateWorkss(workss)) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        return "work";
    }

    @RequestMapping(value = "/works/list/{id}", method = RequestMethod.GET)
    public String findWorks(@PathVariable("id") long id, Model model) {
        Workss a = worksService.findByWorkss(id);
        if (a != null) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        return "work";

    }

    @RequestMapping(value = "/works/list/{id}", method = RequestMethod.DELETE)
    public String deleteWorks(@PathVariable("id") long id, Model model) {
        if (worksService.deleteWorkss(id)) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        return "work";

    }


}
