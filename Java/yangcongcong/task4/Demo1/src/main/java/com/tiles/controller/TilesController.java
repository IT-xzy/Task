package com.tiles.controller;

import com.tiles.model.Home;
import com.tiles.model.Profession;
import com.tiles.service.HomeService;
import com.tiles.service.ProfessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TilesController {

    @Autowired
    private HomeService homeService;

    @Autowired
    private ProfessionService professionService;

    @RequestMapping(value = "/home")
    public String body2(Model model) {
        List<Home> homeList = homeService.getAll();
        model.addAttribute("homeList", homeList);

        Home home = homeList.get(homeList.size()-1);
        model.addAttribute("home", home);

        long time=System.currentTimeMillis();
        model.addAttribute("time", time);
        return "index";
    }

    @RequestMapping(value = "/home/profession")
    public String profession(Model model) {
        List<Profession> professionList = professionService.getAll();
        model.addAttribute("professionList", professionList);

        long time=System.currentTimeMillis();
        model.addAttribute("time", time);
        return "profession";
    }

    @RequestMapping("/")
    public String index() {
        return "shouye";
    }

}
