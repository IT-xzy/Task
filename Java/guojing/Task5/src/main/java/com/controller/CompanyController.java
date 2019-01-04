package com.controller;


import com.entity.Company;
import com.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CompanyController {


    @Autowired
    CompanyService companyService;

    @RequestMapping(value = "/u/company", method = RequestMethod.GET)
    public ModelAndView findCompany() {
        System.out.println("哈哈哈，我来企业了！");
        ModelAndView modelAndView = new ModelAndView();
        List<Company> companyList = companyService.findCompany();
        System.out.println(companyList);
        modelAndView.addObject("data",companyList);
        modelAndView.addObject("item", "body2");
        modelAndView.setViewName("myView");
        return modelAndView;
    }


}
