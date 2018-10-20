package com.jnshu.controller;

import com.jnshu.entity.Banner;
import com.jnshu.service.BannerService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/a/u")
public class BannerController {
    Logger logger = LogManager.getLogger(BannerController.class.getName());
    @Autowired
    BannerService bannerService;
    //获得单个banner
    @RequestMapping(value = "/banner/{id}", method = RequestMethod.GET)
    public ModelAndView findOneBanner(@PathVariable long id , ModelAndView modelAndView) {
        logger.info("findAllArts===========\n"+"id======"+id+"\n");
        if (id > 0 && id%1==0) {
            Banner banner = bannerService.selectByPrimaryKey(id);
            if(banner!=null){
                logger.info(banner.toString());
                //  modelAndView.addObject("message", "findAll success");
                //JSP页面接收数据的是一个array,因此需要用map对对象进行封装
                Map<String, Object> map = new HashMap<>();
                map.put("banner", banner);
                modelAndView.addObject("banner", map);
                modelAndView.addObject("code", 100);//查找成功
            }else{
                logger.info("您所查找的记录不存在\n");
                modelAndView.addObject("code", -101);//您所查找的记录不存在
            }
        } else {
            modelAndView.addObject("code", -100);//请输入一个正整数
            //modelAndView.addObject("message", "findAll failed");
            //不存在的时候将返回给jsp页面的data值设置为空，如果不设置，会显示data中以前残留的数据
        }
        modelAndView.setViewName("showBannerJsonFormat");
        return modelAndView;
    }
//按条件获得Banner列表
    @RequestMapping(value = "/banner/list", method = RequestMethod.GET)
    public ModelAndView findSelectiveBanner( boolean state,boolean type ,ModelAndView modelAndView){
        logger.info("findSelectiveBanner=====\n"+ "state=====" + state + "\n type======"+type);
        Banner banner = new Banner();
        banner.setState(state);
        banner.setType(type);
        List<Banner> bannerList = bannerService.select(banner);
        logger.info("findSelectiveBanner===========\n"+" bannerService.select(banner)\n");
        if (bannerList != null) {
                modelAndView.addObject("banner", bannerList);
                modelAndView.addObject("code", 100);//查找成功
            }else{
                modelAndView.addObject("code", -101);//您所查找的记录不存在
            }
        modelAndView.setViewName("showBannerJsonFormat");
        return modelAndView;
    }
}