package com.controller;

import com.Impl.OtherPageServiceImpl;
import com.POJO.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author: 曹樾
 * @program: task5-module
 * @description: 合作企业页控制器
 * @create: 2018/5/7 下午5:33
 */

@Controller
public class RecommendController {
    @Autowired
    private OtherPageServiceImpl otherPageServiceImpl;
    @RequestMapping("/recommend")
    public String select(Model model) throws Exception {
        List<Company> companies = otherPageServiceImpl.findCompany();
        model.addAttribute("Company",companies);
        return "third";
    }
}
