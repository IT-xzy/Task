package com.ptteng.controller;

import com.ptteng.model.Module;
import com.ptteng.service.ModuleService;
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
 * @ClassName ModuleController
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/1/27  12:31
 * @Version 1.0
 **/

@Controller
public class ModuleController {
    Logger logger = Logger.getLogger(ModuleController.class);
    Map<String, Object> map = new HashMap<>();
    @Autowired
    ModuleService moduleService;

    @ResponseBody
    @RequestMapping(value = "/module/list", method = RequestMethod.GET)
    public Map selectByDynamicCondition(String name) {
        logger.info(name);
        try {
            List<Module> modules = moduleService.selectByDynamicCondition(name);
            map.put("modules", modules);
            map.put("code", 1);
            map.put("message", "成功");
            return map;
        } catch (Exception e) {
            map.put("code", -1);
            map.put("message", "失败");
            return map;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/module", method = RequestMethod.POST)
    public Map insert(Module record) {
        logger.info(record);
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(1L);
            record.setUpdateBy(2L);
            moduleService.insert(record);
            map.put("code", 1);
            map.put("message", "成功");
            return map;
        } catch (Exception e) {
            map.put("code", -1);
            map.put("message", "失败");
            return map;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/module", method = RequestMethod.PUT)
    public Map updateByPrimaryKey(Module record) {
        logger.info(record);
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(1L);
            record.setUpdateBy(2L);
            moduleService.updateByPrimaryKey(record);
            map.put("code", 1);
            map.put("message", "成功");
            return map;
        } catch (Exception e) {
            map.put("code", -1);
            map.put("message", "失败");
            return map;
        }
    }
    @ResponseBody
    @RequestMapping(value = "/module",method = RequestMethod.DELETE)
    public Map deleteByPrimaryKey(Long id){
        logger.info(id);
        try{
            moduleService.deleteByPrimaryKey(id);
            map.put("code", 1);
            map.put("message", "成功");
            return map;
        } catch (Exception e) {
            map.put("code", -1);
            map.put("message", "失败");
            return map;
        }
    }


}
