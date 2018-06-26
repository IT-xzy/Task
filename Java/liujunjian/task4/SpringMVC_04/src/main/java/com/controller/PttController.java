package com.controller;

import com.pojo.Profession;
import com.service.PttDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PttController {
    @Autowired
    private PttDaoService pttDaoService;

    public Profession findProfession(String profession) {
        try {
            return pttDaoService.findProfession(profession);
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "/homePage")
    public String toHomePage(Model model) throws Exception {
        List<Profession> list1 = pttDaoService.findAll();
        int stuSum = 0;
        int graSum = 0;
        for (Profession profession : list1) {
            stuSum = stuSum + profession.getStu_number();
            graSum = graSum + profession.getGra_number();
        }
        model.addAttribute("stuSum", stuSum);
        model.addAttribute("graSum", graSum);
        List<String> list = new ArrayList();
        list.add("images/banner-1.jpg");
        list.add("images/banner-2.jpg");
        list.add("images/banner-3.jpg");
        list.add("images/banner-4.jpg");
        model.addAttribute("image", list);
        return "main";
    }

    @RequestMapping(value = "/profession")
    public String toProfession(Model model) {
        model.addAttribute("java", findProfession("java"));
        model.addAttribute("python", findProfession("python"));
        model.addAttribute("css", findProfession("css"));
        model.addAttribute("js", findProfession("js"));
        model.addAttribute("Android", findProfession("Android"));
        model.addAttribute("ios", findProfession("ios"));
        model.addAttribute("pm", findProfession("pm"));
        model.addAttribute("ui", findProfession("ui"));
        model.addAttribute("qa", findProfession("qa"));
        model.addAttribute("operator", findProfession("operator"));
        return "profession";
    }

    @RequestMapping(value = "/recommend")
    public String toRecommend() {
        return "recommend";
    }
}
