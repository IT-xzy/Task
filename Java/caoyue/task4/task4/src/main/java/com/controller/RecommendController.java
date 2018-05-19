package com.controller;

import com.POJO.Company;
import com.service.GreatStudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author: 曹樾
 * @program: task4
 * @description: 推荐合作企业页面
 * @create: 2018/4/24 上午9:26
 */

@Controller
public class RecommendController {
    @Autowired
    GreatStudentServiceImpl greatStudentServiceImpl;
    @RequestMapping("/recommend")
    public String select(Model model) throws Exception {
        List<Company> companies = greatStudentServiceImpl.findCompany();
        System.out.println(companies);
        model.addAttribute("Company",companies);
        return "third";
    }
}
