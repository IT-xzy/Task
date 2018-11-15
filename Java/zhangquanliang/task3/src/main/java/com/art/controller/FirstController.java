package com.art.controller;

import com.art.pojo.Banner;
import com.art.pojo.First;
import com.art.service.BannerService;
import com.art.service.FirstService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作品集管理
 * @author suger
 * @date 2018/11/6 20:07
 */
@Controller
@RequestMapping("/a/u/first")
public class FirstController {

    private static final Logger logger= LogManager.getLogger(FirstController.class);
    @Autowired
    FirstService firstService;

    // 查询单个作品集
    @GetMapping(value = "/{id}")
    @ResponseBody
    public Map<String,Object> getFirst(@PathVariable Integer id) {
        Map<String,Object> result = new HashMap<String, Object>();

        First first = firstService.getFirst(id);
        if (first!=null){
            result.put("message","查询成功");
            result.put("code",200);
            result.put("data",first);
        }else {
            result.put("message","查询失败");
            result.put("code",400);
            result.put("data","ID对应的数据为空");
        }
        return result;
    }

    // 查询 first 作品集
    @GetMapping
    @ResponseBody
    public Map<String,Object> list(@RequestParam(value = "status",required = false) Boolean status,
                                   @RequestParam(value = "updateBy",required = false) String updateBy) {
        Map<String,Object> result = new HashMap<String, Object>();
        List<First> firstList = firstService.getFirst(status,updateBy);
        logger.info(firstList);
        if (firstList!=null){
            result.put("message","查询成功");
            result.put("code",200);
            result.put("data",firstList);

        }else {
            result.put("message","查询失败");
            result.put("code",400);
            result.put("data","找不到对应的作品集（first)");
        }
        return result;
    }

    // 添加 作品集
    @PostMapping
    @ResponseBody
    public Map<String,Object> saveFirst(First first){
        Map<String,Object> result = new HashMap<String, Object>();

        logger.info(first);
        if (firstService.insert(first)){
            result.put("code",200);
            result.put("message","添加成功");
        }else {
            result.put("code",400);
            result.put("message","添加失败");
        }
        return result;
    }

    // 删除 作品集
    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public Map<String,Object>  deleteFirst(@PathVariable Integer id){
        Map<String,Object> result = new HashMap<String, Object>();
        logger.info(id);
        if(firstService.delete(id)) {
            result.put("code", 200);
            result.put("message", "删除成功");
        }else {
            result.put("code", 400);
            result.put("message", "删除失败");
        }
        return result;
    }

    //更新 作品集
    @PutMapping(value = "/{id}")
    @ResponseBody
    public Map<String,Object> updateBanner(@PathVariable Integer id, First first){
        Map<String,Object> result = new HashMap<String, Object>();
        logger.info(first);
        if (firstService.update(first)){
            result.put("code", 200);
            result.put("message", "更新成功");
        }else {
            result.put("code", 400);
            result.put("message", "更新失败");
        }
        return result;
    }
}
