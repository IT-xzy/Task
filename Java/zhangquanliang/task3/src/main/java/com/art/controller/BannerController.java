package com.art.controller;

import com.art.pojo.Banner;
import com.art.service.BannerService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author suger
 * @date 2018-11-04
 */
@Controller

public class BannerController {

    private static final Logger logger= LogManager.getLogger(BannerController.class);
    @Autowired
    BannerService bannerService;

    @GetMapping(value = "a/u/banner/{id}")
    @ResponseBody
    public Map<String,Object> getBanner(@PathVariable Integer id) {
        Map<String,Object> result = new HashMap<String, Object>();
        Banner banner=bannerService.getBanner(id);
        if (banner!=null){
            result.put("message","查询成功");
            result.put("code",200);
            result.put("data",banner);

        }else {
            result.put("message","查询失败");
            result.put("code",400);
            result.put("data","ID对应的数据为空");
        }
        return result;
    }

    // 查询 banner 列表
    @GetMapping(value = "/a/u/banner")
    @ResponseBody
    public Map<String,Object> list(@RequestParam(value = "status",required = false) Boolean status,
                                   @RequestParam(value = "updateBy",required = false) String updateBy) {
        Map<String,Object> result = new HashMap<String, Object>();
        List<Banner> bannerList=bannerService.findBanners(status,updateBy);
        logger.info(bannerList);
        if (bannerList!=null){
            result.put("message","查询成功");
            result.put("code",200);
            result.put("data",bannerList);

        }else {
            result.put("message","查询失败");
            result.put("code",400);
            result.put("data","找不到对应的banner");
        }
        return result;
    }

    // 添加 banner
    @RequestMapping(value = "/a/u/banner",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> saveBanner(Banner banner){
        Map<String,Object> result = new HashMap<String, Object>();

        logger.info(banner);
        if (bannerService.insert(banner)){
            result.put("code",200);
            result.put("message","添加成功");
        }else {
            result.put("code",400);
            result.put("message","添加失败");
        }
        return result;
    }

    // 删除 banner
    @RequestMapping(value = "/a/u/banner/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object>  deleteBanner(@PathVariable Integer id){
        Map<String,Object> result = new HashMap<String, Object>();
        logger.info(id);
        if(bannerService.delete(id)) {
            result.put("code", 200);
            result.put("message", "删除成功");
        }else {
            result.put("code", 400);
            result.put("message", "删除失败");
        }
        return result;
    }

    //更新 banner
    @RequestMapping(value = "/a/u/banner/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> updateBanner(@PathVariable Integer id, Banner banner){
        Map<String,Object> result = new HashMap<String, Object>();
        logger.info(banner);
        if (bannerService.update(banner)){
            result.put("code", 200);
            result.put("message", "更新成功");
        }else {
            result.put("code", 400);
            result.put("message", "更新失败");
        }
        return result;
    }


}
