package com.mutesaid.controller;

import com.mutesaid.pojo.Profession;
import com.mutesaid.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/job")
public class JobController {
    @Autowired
    private ProfessionService professionService;

    @RequestMapping(method = RequestMethod.GET)
    public String job(ModelMap model) {
        List<Profession> backList = professionService.getProfesList("后端开发");
        List<Profession> frontList = professionService.getProfesList("前端开发");
        List<Profession> operaList = professionService.getProfesList("运维");
        List<Profession> userList = professionService.getProfesList("用户体验");

        model.addAttribute("backList", backList);
        model.addAttribute("frontList", frontList);
        model.addAttribute("operaList", operaList);
        model.addAttribute("userList", userList);

        return "jobpage";
    }

}
