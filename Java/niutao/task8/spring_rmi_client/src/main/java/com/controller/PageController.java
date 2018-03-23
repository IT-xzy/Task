package com.controller;


import com.model.Student;
import com.service.StudentService;
import com.util.RMI;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class PageController {


    @RequestMapping("/u/t10")
    public String index10(Model model) {
                int learnNum = RMI.getService().selectByStatus(1);
                int workNum = RMI.getService().selectByStatus(0);
                List<Student> collegeList = RMI.getService().GetCollegeList();
                //加入属性值
                System.out.println(collegeList);
                model.addAttribute("learner", learnNum);
                model.addAttribute("worker", workNum);
                model.addAttribute("college0",collegeList.get(0));
                model.addAttribute("college1",collegeList.get(1));
                model.addAttribute("college2",collegeList.get(2));
                model.addAttribute("college3",collegeList.get(3));
                model.addAttribute("url",RMI.getService().geturl());
                return "t10";
    }

    @RequestMapping("/t11")
    public String index11(ModelMap map) {
        int classnumqianduan = 0;
        classnumqianduan = RMI.getService().selectByclass("前端");
        map.addAttribute("learnnum", classnumqianduan);
        return "t11";
    }
}
