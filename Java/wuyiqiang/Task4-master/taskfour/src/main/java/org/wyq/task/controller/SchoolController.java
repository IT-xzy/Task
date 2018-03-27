package org.wyq.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.wyq.task.pojo.Profession;
import org.wyq.task.pojo.Salary;
import org.wyq.task.pojo.Students;
import org.wyq.task.service.BaseService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private BaseService schoolService;

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        List<Students> list = schoolService.selectStudentsByEvaluate();
        Integer graduated = schoolService.countStudentsByStatus(2);
        Integer count = schoolService.countStudentsByStatus(1) + graduated;
        mav.addObject("students", list);
        mav.addObject("count", count);
        mav.addObject("graduated", graduated);
        mav.addObject("datetag", System.currentTimeMillis());
//        mav.setViewName("index");
        mav.setViewName("tiles_index");
        return mav;
    }

    @RequestMapping("/profession")
    public ModelAndView profession() {
        ModelAndView mav = new ModelAndView();
        List<String> directionCategoryList = schoolService.directionCategoryList();
        List<Profession> professionList = schoolService.selectProfessionAll();
        List<Salary> salaryList = schoolService.selecSalarytAll();
        List<Students> studentsList = schoolService.selectStudentsAll();

        Map countStudents = new HashMap();
        for(Students s : studentsList){
            countStudents.put(s.getProfession(), schoolService.countStudentsByProfession(s.getProfession()));
        }

//        List<Profession> frontAnd = schoolService.selectProfessionByDirection("前端开发");
//        List<Profession> backAnd = schoolService.selectProfessionByDirection("后端开发");
//        List<Profession> mobile = schoolService.selectProfessionByDirection("移动开发");
//        List<Profession> wholePoint = schoolService.selectProfessionByDirection("整站开发");
//        List<Profession> operationAndMaintenance = schoolService.selectProfessionByDirection("运营维护");
//        professionList.add(frontAnd);
//        professionList.add(backAnd);
//        professionList.add(mobile);
//        professionList.add(wholePoint);
//        professionList.add(operationAndMaintenance);
//        List<Salary> salaryList = schoolService.selecSalarytAll();

        mav.addObject("directionCategoryList", directionCategoryList);
        mav.addObject("professionList", professionList);
        mav.addObject("salaryList", salaryList);
        mav.addObject("countStudents", countStudents);
        mav.addObject("datetag", System.currentTimeMillis());
//        mav.setViewName("profession");
        mav.setViewName("tiles_profession");
        return mav;
    }
}
