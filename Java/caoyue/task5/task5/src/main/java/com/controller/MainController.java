package com.controller;

import com.Impl.OtherPageServiceImpl;
import com.POJO.Cooperation;
import com.POJO.GreatStudent;
import com.POJO.HowToStudy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author: 曹樾
 * @program: task5-module
 * @description: 首页控制器
 * @create: 2018/5/7 下午5:31
 */

@Controller
public class MainController {
    @Autowired
    private OtherPageServiceImpl otherPageServiceImpl;
    @RequestMapping("/u/index")
    public String select(Model model) throws Exception {
        List<GreatStudent> greatStudents = otherPageServiceImpl.findStudentByName();
        List<Cooperation> cooperation = otherPageServiceImpl.findCooperation();
        List<HowToStudy> howToStudies = otherPageServiceImpl.findStudy();
        
        model.addAttribute("lists", greatStudents);
        model.addAttribute("cooperation", cooperation);
        model.addAttribute("study", howToStudies);
        
        return "first";
    }
}
