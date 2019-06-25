package cn.wp.controller;

import cn.wp.aspect.WebLog;
import cn.wp.model.Role;
import cn.wp.service.RoleService;
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
 * @ClassName: RoleController
 * @Description: Role接口
 * @Author: 老王
 * @Date: 2019/5/13 10:08
 * @Version: 1.0
 */
@Controller
public class RoleController {
    Logger logger = Logger.getLogger(RoleController.class);
    Map<String, Object> map = new HashMap<>();
    @Autowired
    RoleService roleService;

    @ResponseBody
    @WebLog(description = "请求角色列表")
    @RequestMapping(value = "/a/u/role/list", method = RequestMethod.GET)
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
    @WebLog(description = "请求添加角色")
    @RequestMapping(value = "/a/u/role", method = RequestMethod.POST)
    public Map insert(Role record) {
        logger.info(record);
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(3L);
            record.setUpdateBy(3L);
            roleService.insert(record);
            map.put("code", 3);
            map.put("message", "成功");
            return map;
        } catch (Exception e) {
            map.put("code", -1);
            map.put("message", "失败");
            return map;
        }
    }

    @ResponseBody
    @WebLog(description = "请求删除角色")
    @RequestMapping(value = "/a/u/role/{id}", method = RequestMethod.DELETE)
    public Map deleteByPrimaryKey(Long id) {
        logger.info(id);
        try {
            roleService.deleteByPrimaryKey(id);
            map.put("code", 1);
            map.put("message", "成功");
            return map;
        } catch (Exception e) {
            map.put("code", -1);
            map.put("message", "失败咯");
            return map;
        }
    }

    @ResponseBody
    @WebLog(description = "请求更新角色")
    @RequestMapping(value = "/a/u/role/{id}", method = RequestMethod.PUT)
    public Map updateByPrimaryKey(Role record) {
        logger.info(record);
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(11L);
            record.setUpdateBy(1L);
            roleService.updateByPrimaryKey(record);
            map.put("code", 6);
            map.put("message", "成功");
            return map;
        } catch (Exception e) {
            map.put("code", -1);
            map.put("message", "失败");
            return map;
        }
    }

    @ResponseBody
    @WebLog(description = "请求所有角色")
    @RequestMapping(value = "/a/u/role/all", method = RequestMethod.GET)
    public Map selectAll() {
        try {
            List<Role> roles = roleService.selectAll();
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
}
