package com.controller;


import com.model.Company;
import com.model.People;
import com.model.Profession;
import com.service.CompanyService;
import com.service.ProfService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @Author qmz
 * @Description
 * @Data 2018/7/26$ 23:35$
 **/
@Controller
public class IndexController {
    private static Logger logger = Logger.getLogger("IndexController.class");
    @Autowired
    private UserService userService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private ProfService profService;


    /**
     * @param
     * @return
     * @mathodName selectPeople
     * @Description 学员页
     * @date 2018/7/30 15:02
     */
    @RequestMapping(value = "/people")
    public ModelAndView selectPeople(ModelAndView modelAndView) {
        //在学人数
        int i = userService.selectAll();
        //就业人数
        int b = userService.findJob();
        List<People> peo = userService.listJob();

        logger.info("selectPeople:在学人数" + i);
        logger.info("selectPeople:就业人数" + b);
        logger.info("selectPeople:peo" + peo.size());

        modelAndView.addObject("i", i);
        modelAndView.addObject("b", b);
        modelAndView.addObject("peo", peo);
        modelAndView.addObject("item", "body1");
        modelAndView.setViewName("myView");
        return modelAndView;
    }

    /**
     * @param
     * @return
     * @mathodName selectCompany
     * @Description 合作企业页
     * @date 2018/7/30 15:26
     */
    @RequestMapping(value = "/u/company")
    public ModelAndView selectCompany(ModelAndView modelAndView) {
        //查询所有公司
        List<Company> companies = companyService.listCompany();

        logger.info("selectCompany:companies" + companies.size());

        modelAndView.addObject("companies", companies);
        modelAndView.addObject("item", "body2");
        modelAndView.setViewName("myView");
        return modelAndView;
    }

    /**
     * @param
     * @return
     * @mathodName selectProfession
     * @Description 修真类型页
     * @date 2018/7/30 15:27
     */
    @RequestMapping(value = "/u/profession")
    public ModelAndView selectProfession(ModelAndView modelAndView) {
        //查询所有修真类型
        List<Profession> list = profService.group();

        logger.info("selectProfession:list" + list.size());

        List<Profession> list1 = new ArrayList<>();
        List<Profession> list2 = new ArrayList<>();
        List<Profession> list3 = new ArrayList<>();
        //开发方向分组
        for (Profession p : list) {
            switch (p.getProfGroup()) {
                case "1":
                    list1.add(p);
                    break;
                case "2":
                    list2.add(p);
                    break;
                case "3":
                    list3.add(p);
                    break;
            }
        }
        modelAndView.addObject("list", list);
        modelAndView.addObject("list1", list1);
        modelAndView.addObject("list2", list2);
        modelAndView.addObject("list3", list3);
        modelAndView.addObject("item", "body4");
        modelAndView.setViewName("myView");
        return modelAndView;
    }
}

