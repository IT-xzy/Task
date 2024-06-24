package com.jnshu.controller;

import com.jnshu.model.Career;
import com.jnshu.service.BannerService;
import com.jnshu.service.CareerService;
import com.jnshu.util.RandomUntil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CareerController {
    private static final Logger logger = Logger.getLogger(CareerController.class);
    //    Map<String, Object> map = new HashMap<>();

    CareerService careerService;

    @RequestMapping(value = "/a/u/career/list", method = RequestMethod.GET)
    public String selectAll(Model model) {
        if (RandomUntil.random() == 0) {
            try {
                ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-services.xml");
                careerService = (CareerService) applicationContext.getBean("career");
            } catch (Exception e) {
                ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-services2.xml");
                careerService = (CareerService) applicationContext.getBean("career1");
            }
        } else {
            try {
                ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-services2.xml");
                careerService = (CareerService) applicationContext.getBean("career1");
            } catch (Exception e) {
                ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-services.xml");
                careerService = (CareerService) applicationContext.getBean("career");
            }
        }
        try {
            List<Career> career = careerService.selectAll();
//            map.put("code", 0000);
//            map.put("banner", career);

            model.addAttribute("career", career);
            model.addAttribute("code", 0000);
            logger.info("输出" + career);
        } catch (Exception e) {
            model.addAttribute("code", 1000);

        }
        return "home2";
    }

}

