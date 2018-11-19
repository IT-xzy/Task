package com.art.controller;

import com.art.pojo.Banner;
import com.art.pojo.Second;
import com.art.service.SecondService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作品分类
 * @author suger
 * @date 2018/11/6 20:07
 */
@RestController

public class SecondController {

    private static final Logger logger= LogManager.getLogger(SecondController.class);
    @Autowired
    SecondService secondService;

    // 查询 单个作品分类
    @GetMapping(value = "a/u/second/{id}")
    @ResponseBody
    public Map<String,Object> getBanner(@PathVariable Integer id) {
        Map<String,Object> result = new HashMap<String, Object>();
        Second second = secondService.getSecond(id);
        if (second!=null){
            result.put("message","查询成功");
            result.put("code",200);
            result.put("data",second);

        }else {
            result.put("message","查询失败");
            result.put("code",400);
            result.put("data","ID对应的数据为空");
        }
        return result;
    }

    // 查询 作品分类 列表
    @GetMapping(value = "/a/u/second")
    @ResponseBody
    public Map<String,Object> list(@RequestParam(value = "status",required = false) Boolean status,
                                   @RequestParam(value = "updateBy",required = false) String updateBy) {
        Map<String,Object> result = new HashMap<String, Object>();
        List<Second> secondList = secondService.getSecond(status,updateBy);
        logger.info(secondList);
        if (secondList.size()==0 || secondList == null){
            result.put("message","查询失败");
            result.put("code",400);
            result.put("data","找不到对应的作品列表");
        }else {
            result.put("message","查询成功");
            result.put("code",200);
            result.put("data",secondList);
        }
        return result;
    }

    // 添加 作品集
    @PostMapping(value = "/a/u/second")
    @ResponseBody
    public Map<String,Object> saveSecond(Second second){
        Map<String,Object> result = new HashMap<String, Object>();

        logger.info("插入："+second);
        if (secondService.insert(second)){
            result.put("code",200);
            result.put("message","添加成功");
        }else {
            result.put("code",400);
            result.put("message","添加失败");
        }
        return result;
    }

    // 删除 作品集
    @RequestMapping(value = "/a/u/second/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object>  deleteSecond(@PathVariable Integer id){
        Map<String,Object> result = new HashMap<String, Object>();
        logger.info(id);
        if(secondService.delete(id)) {
            result.put("code", 200);
            result.put("message", "删除成功");
        }else {
            result.put("code", 400);
            result.put("message", "删除失败");
        }
        return result;
    }

    //更新 作品集
    @RequestMapping(value = "/a/u/second/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> updateBanner(@PathVariable Integer id, Second second){
        Map<String,Object> result = new HashMap<String, Object>();
        logger.info(second);
        if (secondService.update(second)){
            result.put("code", 200);
            result.put("message", "更新成功");
        }else {
            result.put("code", 400);
            result.put("message", "更新失败");
        }
        return result;
    }
}
