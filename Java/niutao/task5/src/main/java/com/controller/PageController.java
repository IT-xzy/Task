package com.controller;

import com.mapper.StudentMapper;
import com.service.GetCollege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class PageController {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    GetCollege getCollege;

    @RequestMapping("/u/t10")
    public String index10(ModelMap map) {

        int learnNum = studentMapper.selectByStatus(1);
        int workNum = studentMapper.selectByStatus(0);
        Map<Integer, String> collegemap = getCollege.GetCollegeMap();
        //加入属性值
        map.addAttribute("learner", learnNum);
        map.addAttribute("worker", workNum);
        map.addAttribute("name0", collegemap.get(0));
        map.addAttribute("name1", collegemap.get(1));
        map.addAttribute("name2", collegemap.get(2));
        map.addAttribute("name3", collegemap.get(3));
        return "t10";
    }

    @RequestMapping("/t11")
    public String index11(ModelMap map) {
        int classnumqianduan = studentMapper.selectByclass("前端");
        map.addAttribute("learnnum",classnumqianduan);
        return "t11";
    }


}
