package com.controller;

import com.exception.MyException;
import com.getService.ServiceFactory;
import com.pojo.Profession;
import com.service.PttDaoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PttController {
    @Autowired
    private ServiceFactory serviceFactory;
    private Logger logger = Logger.getLogger(PttController.class.getName());

    @RequestMapping(value = "/homePage")
    public String toHomePage(Model model) {
        try {
            model.addAttribute("stuSum", serviceFactory.getPttDaoService().getStudentSum());
            model.addAttribute("graSum", serviceFactory.getPttDaoService().getGraduateSum());
            model.addAttribute("image", serviceFactory.getPttDaoService().getImageAddress());
            return "main";
        } catch (MyException e) {
            logger.error(e.getMessage());
        }
        return "main";
    }

    @RequestMapping(value = "/profession")
    public String toProfession(Model model) {
        try {
            List<Profession> list = serviceFactory.getPttDaoService().getAllProfession();
            model.addAttribute("java", list.get(0));
            model.addAttribute("python", list.get(1));
            model.addAttribute("css", list.get(2));
            model.addAttribute("js", list.get(3));
            model.addAttribute("Android", list.get(4));
            model.addAttribute("ios", list.get(5));
            model.addAttribute("pm", list.get(6));
            model.addAttribute("ui", list.get(7));
            model.addAttribute("qa", list.get(8));
            model.addAttribute("operator", list.get(9));
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
