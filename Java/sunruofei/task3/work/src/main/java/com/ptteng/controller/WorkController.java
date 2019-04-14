package com.ptteng.controller;

import com.ptteng.model.Work;
import com.ptteng.service.WorkRoomService;
import com.ptteng.service.WorkService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName WorkController
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/1/27  17:01
 * @Version 1.0
 **/

@Controller
public class WorkController {
    Logger logger = Logger.getLogger(WorkController.class);
    Map<String , Object> map = new HashMap<>();
    @Autowired
    WorkService workService;
    @ResponseBody
    @RequestMapping(value = "/work/list",method = RequestMethod.GET)
    public Map selectByDynamicCondition(String name,Long state){
        logger.info(name);
        logger.info(state);
        try{


            List<Work> works = workService.selectByDynamicCondition(name,state);
            map.put("works",works);
            map.put("code",1);
            map.put("message","成功");
            return map;
        }catch (Exception e){
            map.put("code",-1);
            map.put("message","失败");
            return map;
        }
    }
    @ResponseBody
    @RequestMapping(value = "/work",method = RequestMethod.DELETE)
    public Map deleteByPrimaryKey(Long id){
        logger.info(id);
        try{
            workService.deleteByPrimaryKey(id);
            map.put("code",1);
            map.put("message","成功");
            return map;
        }catch (Exception e){
            map.put("code",-1);
            map.put("message","失败");
            return map;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/work",method = RequestMethod.PUT)
    public Map updateByPrimaryKey(Work record){
        logger.info(record);
        try{
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(1L);
            record.setUpdateBy(2L);
            workService.updateByPrimaryKey(record);
            map.put("code",1);
            map.put("message","成功");
            return map;
        }catch (Exception e){
            map.put("code",-1);
            map.put("message","失败");
            return map;
        }

    }



    @ResponseBody
    @RequestMapping(value = "/work",method = RequestMethod.POST)
    public Map insert(Work record){
        logger.info(record);
        try{
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(1L);
            record.setUpdateBy(2L);
            workService.insert(record);
            map.put("code",1);
            map.put("message","成功");
            return map;
        }catch (Exception e){
            map.put("code",-1);
            map.put("message","失败");
            return map;
        }
    }
}
