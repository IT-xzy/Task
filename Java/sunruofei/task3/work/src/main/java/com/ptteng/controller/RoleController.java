package com.ptteng.controller;

import com.ptteng.model.Role;
import com.ptteng.service.RoleService;
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
 * @ClassName RoleController
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/1/27  15:08
 * @Version 1.0
 **/

@Controller
public class RoleController {
    Logger logger = Logger.getLogger(RoleController.class);
    Map<String, Object> map = new HashMap<>();
    @Autowired
    RoleService roleService;

    @ResponseBody
    @RequestMapping(value = "/role/list", method = RequestMethod.GET)
    public Map selectByDynamicCondition(String name) {
        logger.info(name);
        try {
            List<Role> roles = roleService.selectByDynamicCondition(name);
            map.put("roles", roles);
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
    @RequestMapping(value = "/role", method = RequestMethod.POST)
    public Map insert(Role record) {
        logger.info(record);
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(1L);
            record.setUpdateBy(2L);
            roleService.insert(record);
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
    @RequestMapping(value = "/role", method = RequestMethod.DELETE)
    public Map deleteByPrimaryKey(Long id) {
        logger.info(id);
        try {
            roleService.deleteByPrimaryKey(id);
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
    @RequestMapping(value = "/role",method = RequestMethod.PUT)
    public Map updateByPrimaryKey(Role record){
        logger.info(record);
        try{
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(1L);
            record.setUpdateBy(2L);
            roleService.updateByPrimaryKey(record);
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
    @RequestMapping(value = "/role/all",method = RequestMethod.GET)
    public Map selectAll(){
        try{
            List<Role>roles =roleService.selectAll();
            map.put("roles",roles);
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
