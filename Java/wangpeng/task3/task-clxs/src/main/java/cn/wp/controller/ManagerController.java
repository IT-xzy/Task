package cn.wp.controller;

import cn.wp.aspect.WebLog;
import cn.wp.model.Manager;
import cn.wp.model.Role;
import cn.wp.service.ManagerService;
import cn.wp.service.RoleService;
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
 * @ClassName: ManageController
 * @Description: Manage接口
 * @Author: 老王
 * @Date: 2019/5/13 10:06
 * @Version: 1.0
 */
@Controller
public class ManagerController {
    Logger logger = Logger.getLogger(ManagerController.class);
    Map<String, Object> map = new HashMap<>();

    @Autowired
    ManagerService managerService;

    @Autowired
    RoleService roleService;

    @ResponseBody
    @WebLog(description = "请求后台管理列表")
    @RequestMapping(value = "/a/u/manager/list", method = RequestMethod.GET)
    public Map selectByDynamicCondition(Long role, String name) {
        logger.info(role);
        logger.info(name);
        List<Role> roleList = new ArrayList<>();
        try {
            List<Manager> managers = managerService.selectByDynamicCondition(role, name);
            //根据manager的role,获取name,返回给前端展示
            List<Long> roleIdList = new ArrayList<>();
//              增强型for循环
            for (Manager manager : managers
            ) {
                roleIdList.add(manager.getRole());
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
    @WebLog(description = "请求增加后台管理")
    @RequestMapping(value = "/a/u/manager", method = RequestMethod.POST)
    public Map insert(Manager record) {
        logger.info(record);
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(3L);
            record.setUpdateBy(2L);
            managerService.insert(record);
            map.put("code", 1);
            map.put("message", "成功3");
            return map;
        } catch (Exception e) {
            map.put("code", -1);
            map.put("message", "失败");
            return map;
        }
    }

    @ResponseBody
    @WebLog(description = "请求删除后台管理")
    @RequestMapping(value = "/a/u/manager/{id}", method = RequestMethod.DELETE)
    public Map deleteByPrimaryKey(Long id) {
        logger.info(id);
        try {
            managerService.deleteByPrimaryKey(id);
            map.put("code", 3);
            map.put("message", "成功3");
            return map;
        } catch (Exception e) {
            map.put("code", -1);
            map.put("message", "失败");
            return map;
        }
    }

    @ResponseBody
    @WebLog(description = "请求更新后台管理")
    @RequestMapping(value = "/a/u/manager/{id}", method = RequestMethod.PUT)
    public Map updateByPrimaryKey(Manager record) {
        logger.info(record);
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(3L);
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

    @ResponseBody
    @WebLog(description = "请求查询所有后台管理")
    @RequestMapping(value = "/a/u/manager/all", method = RequestMethod.GET)
    public Map selectAll() {
        try {
            List<Manager> managers = managerService.selectAll();
            map.put("managers", managers);
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
