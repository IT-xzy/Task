package com.wyz.task5.controller;

import com.wyz.task5.domain.entity.StuInfo;
import com.wyz.task5.serviec.ProfService;
import com.wyz.task5.serviec.StuInfoService;
import com.wyz.task5.serviec.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class StuInfoController {

    private static Logger logger = LoggerFactory.getLogger(StuInfoController.class);

    @Autowired
    StuInfoService stuInfoService;
    @Autowired
    ProfService profService;
    @Autowired
    UsersService usersService;

    /**
     * 主页链接
     * @Param Model
     */
    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public String listStudent(Model model) {

        //根据学习状态查找学生数目
        StuInfo stu = new StuInfo();
        stu.setStatus("在学");
        int countstudy = stuInfoService.selectStudyWork(stu);
        stu.setStatus("工作");
        int countwork = stuInfoService.selectStudyWork(stu);

        //使用Map接收，然后加入model
        Map info = new HashMap();
        info.put("countwork", countwork);
        info.put("countstudy", countstudy);

        //查找学生信息
        StuInfo one = new StuInfo();
        StuInfo two = new StuInfo();
        StuInfo three = new StuInfo();
        StuInfo four = new StuInfo();
        one.setId(1);
        two.setId(2);
        three.setId(3);
        four.setId(4);
        one = stuInfoService.getById(one);
        two = stuInfoService.getById(two);
        three = stuInfoService.getById(three);
        four = stuInfoService.getById(four);
        info.put("one", one);
        info.put("two", two);
        info.put("three", three);
        info.put("four", four);
        model.addAllAttributes(info);
        return "homepage";
    }

    /**
     * 职业页面链接
     * @Param Model
     */
    //原版不使用缓存
    @RequestMapping(value = "/u/profession", method = RequestMethod.GET)
    public String listProf(Model model) {
        model.addAttribute("prof", profService.getByProf("java后端工程师"));
        return "profession";
    }
}
