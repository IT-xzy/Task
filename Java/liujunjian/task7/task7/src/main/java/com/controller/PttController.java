package com.controller;

import com.exception.MyException;
import com.service.PttDaoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PttController {
    private PttDaoService pttDaoService;
    private Logger logger = Logger.getLogger(PttController.class.getName());

    @Autowired
    public PttController(PttDaoService pttDaoService) {
        this.pttDaoService = pttDaoService;
    }

    @RequestMapping(value = "/homePage")
    public String toHomePage(Model model) {
        try {
            model.addAttribute("stuSum", pttDaoService.getStudentSum());
            model.addAttribute("graSum", pttDaoService.getGraduateSum());
            model.addAttribute("image", pttDaoService.getImageAddress());
            return "main";
        } catch (MyException e) {
            logger.error(e.getMessage());
        }
        return "main";
    }

    @RequestMapping(value = "/profession")
    public String toProfession(Model model) {
        try {
            model.addAttribute("list", pttDaoService.getAllProfession());
            return "profession";
        } catch (MyException e) {
            logger.error(e.getMessage());
        }
        return "profession";
    }

    @RequestMapping(value = "/u")
    public String toRecommend() {
        return "recommend";
    }
}
