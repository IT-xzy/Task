package jnshu.controller;


import jnshu.model.Role;
import jnshu.service.RoleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
public class RoleController {
  private static final Logger logger = Logger.getLogger(RoleController.class);
    Map<String, Object> map = new HashMap<>();
    @Autowired
    RoleService roleService;

    @ResponseBody
    @RequestMapping(value = "/a/role/list", method = RequestMethod.GET)
    public Map selectByDynamicCondition(String role) {
        try {
            logger.info("传入动态参数" + role);
            List<Role> module = roleService.selectByDynamicCondition(role);
            map.put("code", 1000);
            map.put("module", module);
            logger.info("输出动态参数" + map);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/a/role", method = RequestMethod.POST)
    public Map insertSelective(Role record) {
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(2L);
            record.setUpdateBy(2L);
            logger.info("增加传入参数" + record);
            int role =roleService.insertSelective(record);
            map.put("code", 1000);
            logger.info("输出增加参数" +role);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }


    @ResponseBody
    @RequestMapping(value = "/a/role", method = RequestMethod.DELETE)
    public Map deleteByPrimaryKey(Long id) {
        try {
            logger.info("输入删除ID" + id);
            int role =roleService.deleteByPrimaryKey(id);
            map.put("code", 1000);
            logger.info("输出删除结果" + role);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/a/role", method = RequestMethod.PUT)
    public Map updateByPrimaryKey(Role record) {
        try {
            record.setUpdateAt(System.currentTimeMillis());
            record.setUpdateBy(2L);
            logger.info("传入修改参数" + record);
            int Module = roleService.updateByPrimaryKey(record);
            map.put("code", 1000);
            logger.info("输出修改结果" + Module);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }
}