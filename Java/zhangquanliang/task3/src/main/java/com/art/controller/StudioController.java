package com.art.controller;


import com.art.pojo.Banner;
import com.art.pojo.Studio;
import com.art.service.BannerService;
import com.art.service.StudioService;
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
 * @date 2018/11/6 20:08
 */
@Controller

@RequestMapping(value = "/a/u/studio")
public class StudioController {

    private static final Logger logger= LogManager.getLogger(StudioController.class);

    @Autowired
    StudioService studioService;
    @GetMapping(value = "/{id}")
    @ResponseBody
    public Map<String,Object> getBanner(@PathVariable Integer id) {
        Map<String,Object> result = new HashMap<String, Object>();
        Studio studio = studioService.getStudio(id);
        if (studio!=null){
            result.put("message","查询成功");
            result.put("code",200);
            result.put("data",studio);

        }else {
            result.put("message","查询失败");
            result.put("code",400);
            result.put("data","ID对应的数据为空");
        }
        return result;
    }

    // 查询 工作室简介 列表
    @GetMapping()
    @ResponseBody
    public Map<String,Object> list(@RequestParam(value = "status",required = false) Boolean status,
                                   @RequestParam(value = "updateBy",required = false) String updateBy) {
        Map<String,Object> result = new HashMap<String, Object>();
        List<Studio> studioList = studioService.getStudio(status,updateBy);
        logger.info(studioList);
        // 判断list是否为空
        // list == null---- list 不存在；list.isEmpty()----list中元素为空;  list.size()----返回元素的个数----list.size==0
        if (studioList == null || studioList.isEmpty()){
            logger.info("studiolist为空,工作室简介不存在");
            result.put("message","查询失败");
            result.put("code",400);
            result.put("data","找不到对应的studio,工作室简介不存在");

        }else {
            logger.info("进入studiolist查询");
            result.put("message","查询成功");
            result.put("code",200);
            result.put("data",studioList);
        }
        return result;
    }

    // 新增 工作室简介
    @PostMapping()
    @ResponseBody
    public Map<String,Object> saveStudio(Studio studio){
        Map<String,Object> result = new HashMap<String, Object>();

        logger.info(studio);
        if (studioService.insert(studio)){
            result.put("code",200);
            result.put("message","新增成功");
        }else {
            result.put("code",400);
            result.put("message","新增失败");
        }
        return result;
    }

    // 删除 工作室简介
    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public Map<String,Object>  deleteStudio(@PathVariable Integer id){
        Map<String,Object> result = new HashMap<String, Object>();
        logger.info(id);
        boolean tag = studioService.delete(id);
        if(tag) {
            result.put("code", 200);
            result.put("message", "删除成功");
        }else {
            result.put("code", 400);
            result.put("message", "删除失败,对应数据不存在，请确认输入！");
        }
        return result;
    }

    //更新 工作室简介
    @PutMapping(value = "/{id}")
    @ResponseBody
    public Map<String,Object> updateStudio(@PathVariable Integer id, Studio studio){
        Map<String,Object> result = new HashMap<String, Object>();
        logger.info(studio);
        if (studioService.update(studio)){
            result.put("code", 200);
            result.put("message", "更新成功");
        }else {
            result.put("code", 400);
            result.put("message", "更新失败");
        }
        return result;
    }

}
