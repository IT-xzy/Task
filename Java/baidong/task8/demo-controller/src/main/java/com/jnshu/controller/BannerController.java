package com.jnshu.controller;

import com.jnshu.model.Banner;
import com.jnshu.service.BannerService;
import com.jnshu.util.RandomUntil;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.context.ApplicationContext;

import java.util.List;


@Controller
public class BannerController {
    private static final Logger logger = Logger.getLogger(BannerController.class);
    //            Map<String, Object> map = new HashMap<>();

    BannerService bannerService;

    @RequestMapping(value = "/a/u/banner/list", method = RequestMethod.GET)
    public String selectAll(Model model) {

        if (RandomUntil.random() == 0) {
            try {
                ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-services.xml");
                bannerService = (BannerService) applicationContext.getBean("banner");
            } catch (Exception e) {
                ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-services2.xml");
                bannerService = (BannerService) applicationContext.getBean("banner1");
            }
        } else {
            try {
                ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-services2.xml");
                bannerService = (BannerService) applicationContext.getBean("banner1");
            } catch (Exception e) {
                ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-services.xml");
                bannerService = (BannerService) applicationContext.getBean("banner");
            }
        }


        try {
            List<Banner> banner = bannerService.selectAll();
//            map.put("code", 0000);
//            map.put("banner", bannerservice);
            model.addAttribute("banner", banner);
            model.addAttribute("code", 0000);
            logger.info("输出" + model);

        } catch (Exception e) {
//            map.put("code", 1000);
            model.addAttribute("code", 1000);
        }
        return "home";
    }

}
