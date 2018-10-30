package com.jnshu.controller;

import com.jnshu.model.Banner;
import com.jnshu.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping(value = "/banner/list", method = RequestMethod.GET)
    public String getBanner(Model model) {
        System.out.println(123);
        List<Banner> list = bannerService.findAllBanner();
        System.out.println(list);
        model.addAttribute("code", 200);
        model.addAttribute("data", list);
        return "work";
    }

    @RequestMapping(value = "/banner/list", method = RequestMethod.POST)
    public String postBanner(Model model, Banner banner) {
        banner.setCreateAt(System.currentTimeMillis());
        banner.setUpdateAt(System.currentTimeMillis());
        long a = bannerService.addBanner(banner);
        if (a > 0) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        System.out.println(banner);
        return "work";
    }

    @RequestMapping(value = "/banner/list", method = RequestMethod.PUT)
    public String putBanner(Model model, Banner banner) {
        banner.setUpdateAt(System.currentTimeMillis());
        if (bannerService.updateBanner(banner)) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        return "work";
    }

    @RequestMapping(value = "/banner/list/{id}", method = RequestMethod.GET)
    public String findBanner(@PathVariable("id") long id, Model model) {
        Banner a = bannerService.findByBanner(id);
        if (a != null) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        return "work";

    }

    @RequestMapping(value = "/banner/list/{id}", method = RequestMethod.DELETE)
    public String deleteBanner(@PathVariable("id") long id, Model model) {
        if (bannerService.deleteBanner(id)) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        return "work";

    }


}
