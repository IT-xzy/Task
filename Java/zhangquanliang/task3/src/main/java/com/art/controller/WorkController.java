package com.art.controller;

import com.art.pojo.Banner;
import com.art.pojo.Work;
import com.art.service.BannerService;
import com.art.service.WorkService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作品管理
 * @author suger
 * @date 2018/11/6 20:08
 */
@Controller
@RequestMapping(value = "/a/u/work")

public class WorkController {

    private static final Logger logger= LogManager.getLogger(WorkController.class);
    @Autowired
    WorkService workService;
    @GetMapping(value = "/{id}")
    @ResponseBody
    public Map<String,Object> getBanner(@PathVariable Integer id) {
        Map<String,Object> result = new HashMap<String, Object>();
        Work work = workService.getWork(id);
        if (work!=null){
            result.put("message","查询成功");
            result.put("code",200);
            result.put("data",work);

        }else {
            result.put("message","查询失败");
            result.put("code",400);
            result.put("data","ID对应的数据为空");
        }
        return result;
    }

    // 查询 作品列表
    @GetMapping()
    @ResponseBody
    public Map<String,Object> list(@RequestParam(value = "status",required = false) Boolean status,
                                   @RequestParam(value = "updateBy",required = false) String updateBy) {
        Map<String,Object> result = new HashMap<String, Object>();
        List<Work> workList = workService.getWork(status,updateBy);
        logger.info(workList);
        if (workList==null || workList.isEmpty()){

            result.put("message","查询失败");
            result.put("code",400);
            result.put("data","找不到对应的work");

        }else {
            result.put("message", "查询成功");
            result.put("code", 200);
            result.put("data", workList);
        }
        return result;
    }

    // 新增 作品
    //@RequestMapping(value = "/a/u/work",method = RequestMethod.POST)
    @PostMapping()
    @ResponseBody
    public Map<String,Object> saveBanner(Work work){
        Map<String,Object> result = new HashMap<String, Object>();

        logger.info(work);
        if (workService.insert(work)){
            result.put("code",200);
            result.put("message","添加成功");
        } else {
            result.put("code",400);
            result.put("message","添加失败");
        }
        return result;
    }

    // 删除 作品
    //@RequestMapping(value = "/a/u/work/{id}",method = RequestMethod.DELETE)
    @DeleteMapping()
    @ResponseBody
    public Map<String,Object>  deleteBanner(@PathVariable Integer id){
        Map<String,Object> result = new HashMap<String, Object>();
        logger.info("删除作品");
        logger.info(id);
        if(workService.delete(id)) {
            result.put("code", 200);
            result.put("message", "删除成功");
        }else {
            result.put("code", 400);
            result.put("message", "删除失败,对应作品不存在");
        }
        return result;
    }

    //更新 作品
   // @RequestMapping(value = "/a/u/work/{id}",method = RequestMethod.PUT)
    @PutMapping(value = "/{id}")
    @ResponseBody
    public Map<String,Object> updateBanner(@PathVariable Integer id, Work work){
        Map<String,Object> result = new HashMap<String, Object>();
        logger.info(work);
        if (workService.update(work)){
            result.put("code", 200);
            result.put("message", "更新成功");
        }else {
            result.put("code", 400);
            result.put("message", "更新失败");
        }
        return result;
    }

}
