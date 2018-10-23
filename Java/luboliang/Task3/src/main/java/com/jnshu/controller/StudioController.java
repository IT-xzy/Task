package com.jnshu.controller;

import com.jnshu.model.Studio;
import com.jnshu.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class StudioController {
    @Autowired
    private StudioService studioService;

    @RequestMapping(value = "/studio/list", method = RequestMethod.GET)
    public String getStudio(Model model) {
        System.out.println(123);
        List<Studio> list = studioService.findAllStudio();
        System.out.println(list);
        model.addAttribute("code", 200);
        model.addAttribute("data", list);
        return "work";
    }

    @RequestMapping(value = "/studio/list", method = RequestMethod.POST)
    public String postStudio(Model model, Studio studio) {
        studio.setCreate_at(System.currentTimeMillis());
        studio.setUpdate_at(System.currentTimeMillis());
        long a = studioService.addStudio(studio);
        if (a > 0) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        System.out.println(studio);
        return "work";
    }

    @RequestMapping(value = "/studio/list", method = RequestMethod.PUT)
    public String putStudio(Model model, Studio studio) {
        studio.setUpdate_at(System.currentTimeMillis());
        if (studioService.updateStudio(studio)) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        return "work";
    }

    @RequestMapping(value = "/studio/list/{id}", method = RequestMethod.GET)
    public String findStudio(@PathVariable("id") long id, Model model) {
        Studio a = studioService.findByStudio(id);
        if (a != null) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        return "work";

    }

    @RequestMapping(value = "/studio/list/{id}", method = RequestMethod.DELETE)
    public String deleteStudio(@PathVariable("id") long id, Model model) {
        if (studioService.deleteStudio(id)) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        return "work";

    }
    
}
