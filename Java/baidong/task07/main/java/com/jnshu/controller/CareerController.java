package com.jnshu.controller;

import com.jnshu.model.Career;
import com.jnshu.service.CareerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CareerController {
    private static final Logger logger = Logger.getLogger(CareerController.class);
    //    Map<String, Object> map = new HashMap<>();
    @Autowired
    CareerService careerService;


    @RequestMapping(value = "/a/u/career/list", method = RequestMethod.GET)
    public String selectAll(Model model) {
        try {
            List<Career> career = careerService.selectAll();
//            map.put("code", 0000);
//            map.put("banner", career);

            model.addAttribute("career", career);
            model.addAttribute("code", 0000);
            logger.info("输出" + career);
        } catch (Exception e) {
            model.addAttribute("code", 1000);

        }
        return "home2";
    }

}

