package com.jnshu.controller;

import com.jnshu.entity.Art;
import com.jnshu.service.ArtService;
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
public class ArtController {
    Logger logger = LogManager.getLogger(ArtController.class.getName());
    @Autowired
    ArtService artService;
    //获取作品详情
    @RequestMapping(value = "/art/{id}", method = RequestMethod.GET)
    public ModelAndView findAllArts(@PathVariable long id , ModelAndView modelAndView) {
        logger.info("findAllArts===========\n"+"id======"+id+"\n");
        if (id > 0 && id%1 == 0) {
            Art art = artService.selectByPrimaryKey(id);
            if(art!=null){
                logger.info(art.toString());
                //  modelAndView.addObject("message", "findAll success");
                //JSP页面接收数据的是一个array,因此需要用map对对象进行封装
                Map<String, Object> map = new HashMap<>();
                map.put("art", art);
                modelAndView.addObject("art", map);
                modelAndView.addObject("code", 100);//查找成功
            }else{
                logger.info("您所查找的作品不存在\n");
                modelAndView.addObject("code", -101);//您所查找的作品不存在
            }
        } else {
            logger.info("请输入一个正整数\n");
            modelAndView.addObject("code", -100);//请输入一个正整数
            //modelAndView.addObject("message", "findAll failed");
            //不存在的时候将返回给jsp页面的data值设置为空，如果不设置，会显示data中以前残留的数据
        }
            modelAndView.setViewName("showArtJsonFormat");
        return modelAndView;
    }
    //搜索获取作品列表
    @RequestMapping(value = "/art/list", method = RequestMethod.GET)
    public ModelAndView findSelectiveArt(String name, ModelAndView modelAndView){
        logger.info("findSelectiveArt====\n"+ "name=====" + name);
        if(name !=null){
             Art art = new Art();
           /* art.setFirstId(Long.parseLong("name"));
            art.setSecondId(Long.parseLong("name"));*/
            art.setName(name);
            art.setIntroduce(name);
            logger.info("art===========\n"+art.toString()+" \n");
            List<Art> artList = artService.findArtSelective(art);
            if (artList != null) {
                Map<String, Object> map = new HashMap<>();
                map.put("art", artList);
                modelAndView.addObject("code", 100);//查找成功
            }else {
                modelAndView.addObject("code", -101);//您所查找的记录不存在
            }
        }else {
            modelAndView.addObject("code", 101);//没有搜索条件时展示默认的图片
        }
        modelAndView.setViewName("showArtJsonFormat");
        return modelAndView;
    }
}
