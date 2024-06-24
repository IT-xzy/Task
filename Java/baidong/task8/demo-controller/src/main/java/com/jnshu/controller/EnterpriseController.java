package com.jnshu.controller;

import com.jnshu.model.Enterprise;

import com.jnshu.service.CareerService;
import com.jnshu.service.EnterpriseService;
import com.jnshu.util.RandomUntil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EnterpriseController {
    private static final Logger logger = Logger.getLogger(EnterpriseController.class);
    //            Map<String, Object> map = new HashMap<>();

    EnterpriseService enterpriseService;

    @RequestMapping(value = "/a/u/enterprise/list", method = RequestMethod.GET)
    public String selectAll(Model model) {

        if (RandomUntil.random() == 0) {
            try {
                ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-services.xml");
                enterpriseService = (EnterpriseService) applicationContext.getBean("enterprise");
            } catch (Exception e) {
                ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-services2.xml");
                enterpriseService = (EnterpriseService) applicationContext.getBean("enterprise1");
            }
        } else {
            try {
                ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-services2.xml");
                enterpriseService = (EnterpriseService) applicationContext.getBean("enterprise1");
            } catch (Exception e) {
                ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-services.xml");
                enterpriseService = (EnterpriseService) applicationContext.getBean("enterprise");
            }
        }


        try {
            List<Enterprise> enterprise = enterpriseService.selectAll();
//            map.put("code", 0000);
//            map.put("enterprise",enterprise);
            model.addAttribute("enterprise", enterprise);
            model.addAttribute("code", 0000);
            logger.info("输出" + enterprise);

        } catch (
                Exception e) {
//            map.put("code", 1000);

            model.addAttribute("code", 1000);

        }
        return "home";
    }

}

