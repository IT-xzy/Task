package com.jnshu.controller;

import com.jnshu.model.Banner;

import com.jnshu.service.BannerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class BannerController {
    private static final Logger logger = Logger.getLogger(BannerController.class);
    //            Map<String, Object> map = new HashMap<>();
    @Autowired
    BannerService bannerService;


    @RequestMapping(value = "/a/u/banner/list", method = RequestMethod.GET)
    public String selectAll(Model model) {
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
