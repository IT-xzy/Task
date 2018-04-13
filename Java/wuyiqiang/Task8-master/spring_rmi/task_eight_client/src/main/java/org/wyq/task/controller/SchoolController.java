package org.wyq.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.wyq.task.pojo.Profession;
import org.wyq.task.pojo.Salary;
import org.wyq.task.pojo.Students;
import org.wyq.task.service.BaseService;
import org.wyq.task.tuscany.Client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/school")
public class SchoolController {

//    @Autowired
//    private RmiSelect rmiSelect;

    @Autowired
    private Client clinet;

    @RequestMapping("/index")
    public ModelAndView index() throws RemoteException, NotBoundException, MalformedURLException {
        BaseService schoolServiceRmi = clinet.getBaseService();
        ModelAndView mav = new ModelAndView();
        List<Students> list = schoolServiceRmi.selectStudentsByEvaluate();
        Integer graduated = schoolServiceRmi.countStudentsByStatus(2);
        Integer count = schoolServiceRmi.countStudentsByStatus(1) + graduated;
        mav.addObject("students", list);
        mav.addObject("count", count);
        mav.addObject("graduated", graduated);
        mav.addObject("dateTag", System.currentTimeMillis());
//        mav.setViewName("index");
        mav.setViewName("tiles_index");
        return mav;
    }

    @RequestMapping("/profession")
    public ModelAndView profession() throws RemoteException, NotBoundException, MalformedURLException {
        BaseService schoolServiceRmi = clinet.getBaseService();
        ModelAndView mav = new ModelAndView();
        List<String> directionCategoryList = schoolServiceRmi.directionCategoryList();
        List<Profession> professionList = schoolServiceRmi.selectProfessionAll();
        List<Salary> salaryList = schoolServiceRmi.selecSalarytAll();
        List<Students> studentsList = schoolServiceRmi.selectStudentsAll();

        Map countStudents = new HashMap();
        for(Students s : studentsList){
            countStudents.put(s.getProfession(), schoolServiceRmi.countStudentsByProfession(s.getProfession()));
        }

        mav.addObject("directionCategoryList", directionCategoryList);
        mav.addObject("professionList", professionList);
        mav.addObject("salaryList", salaryList);
        mav.addObject("countStudents", countStudents);
        mav.addObject("dateTag", System.currentTimeMillis());
//        mav.setViewName("profession");
        mav.setViewName("tiles_profession");
        return mav;
    }

    @RequestMapping("/index/sign_in")
    public String signIn(){
        return "tiles_index_sign_in";
    }
}
