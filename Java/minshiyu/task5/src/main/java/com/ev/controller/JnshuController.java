package com.ev.controller;

import com.ev.entity.GoodOne;
import com.ev.entity.Occupation;
import com.ev.entity.StudentGeneralInfo;
import com.ev.service.GoodOnesService;
import com.ev.service.OccupationService;
import com.ev.service.StudentGeneralInfoService;
import com.ev.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class JnshuController {

    Logger log = LoggerFactory.getLogger(JnshuController.class);

    @Autowired
    GoodOnesService goodOnesService;

    @Autowired
    OccupationService occupationService;

    @Autowired
    StudentGeneralInfoService studentGeneralInfoService;


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHomePage(Model model) throws Exception {
        StudentGeneralInfo studentGeneralInfo = studentGeneralInfoService.selectMainInfo();
        List<GoodOne> goodOnes = goodOnesService.selectGoodOnes();
        model.addAttribute("info", studentGeneralInfo);
        model.addAttribute("goodone", goodOnes);
        return "studentList";
    }

    @RequestMapping(value = "/enterprise", method = RequestMethod.GET)
    public String getEnterprise() throws Exception {
        return "enterprise";
    }

    //需要登陆的页面
    @RequestMapping(value = "/u/occupation", method = RequestMethod.GET)
    public String getOccupation(Model model) throws Exception {
        List<Occupation> occupations = occupationService.selectOccupation();
        model.addAttribute("occupations", occupations);
        return "occupation";
    }


}
