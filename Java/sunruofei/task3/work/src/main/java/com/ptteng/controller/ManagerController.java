package com.ptteng.controller;

import com.ptteng.model.Manager;
import com.ptteng.model.Role;
import com.ptteng.service.ManagerService;
import com.ptteng.service.RoleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ManagerController
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/1/27  9:33
 * @Version 1.0
 **/

@Controller
public class ManagerController {
    Logger logger = Logger.getLogger(ManagerController.class);
    Map<String, Object> map = new HashMap<>();

    @Autowired
    ManagerService managerService;

    @Autowired
    RoleService roleService;

    @ResponseBody
    @RequestMapping(value = "/manager/list", method = RequestMethod.GET)
    public Map selectByDynamicCondition(Long roleId, String name) {
        logger.info(roleId);
        logger.info(name);
        List<Role> roleList = new ArrayList<>();
        try {
            List<Manager> managers = managerService.selectByDynamicCondition(roleId, name);
            //根据manager的roleid,获取rolename,返回给前端展示
            List<Long> roleIdList = new ArrayList<>();
//              增强型for循环
            for (Manager manager : managers
                    ) {
                roleIdList.add(manager.getRoleId());
            }
//            如果roleIdList不为空,执行
            if (!CollectionUtils.isEmpty(roleIdList)) {
                roleList = roleService.selectByIds(roleIdList);
            }
            Map<String, Object> data = new HashMap<>();
            data.put("roleList", roleList);
            data.put("managers", managers);

            map.put("code", 1);
            map.put("message", "成功");
            map.put("data", data);
            return map;
        } catch (Exception e) {
            map.put("code", -1);
            map.put("message", "成功");
            return map;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/manager", method = RequestMethod.POST)
    public Map insert(Manager record) {
        logger.info(record);
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(1L);
            record.setUpdateBy(2L);
            managerService.insert(record);
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
    @RequestMapping(value = "/manager", method = RequestMethod.DELETE)
    public Map deleteByPrimaryKey(Long id) {
        logger.info(id);
        try {
            managerService.deleteByPrimaryKey(id);
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
    @RequestMapping(value = "/manager", method = RequestMethod.PUT)
    public Map updateByPrimaryKey(Manager record) {
        logger.info(record);
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(1L);
            record.setUpdateBy(2L);
            managerService.updateByPrimaryKey(record);
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
