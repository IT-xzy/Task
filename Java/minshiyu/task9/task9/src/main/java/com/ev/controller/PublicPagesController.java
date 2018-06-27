package com.ev.controller;

import com.ev.entity.GoodOne;
import com.ev.entity.StudentGeneralInfo;
import com.ev.rmi.Distributor;
import com.ev.service.GoodOneService;
import com.ev.service.StudentGeneralInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PublicPagesController {

    @Autowired
    private Distributor rmiServer;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHomePage(Model model) throws Exception{
        StudentGeneralInfoService studentGeneralInfoService=rmiServer.getStudentGeneralInfoService();
        GoodOneService goodOneService=rmiServer.getGoodOneService();
        StudentGeneralInfo studentGeneralInfo=studentGeneralInfoService.selectMainInfo();
        List<GoodOne> goodOnes=goodOneService.selectGoodOne();
        model.addAttribute("info", studentGeneralInfo);
        model.addAttribute("goodone", goodOnes);
        return "studentList";
    }

    @RequestMapping(value = "/enterprise", method = RequestMethod.GET)
    public String getEnterprise() throws Exception{
        return "enterprise";
    }
}
