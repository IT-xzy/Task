package cn.wp.controller;

import cn.wp.aspect.WebLog;
import cn.wp.model.RoleModule;
import cn.wp.service.RoleModuleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: RoleModuleRelationController
 * @Description: RoleModuleRelationController接口
 * @Author: 老王
 * @Date: 2019/5/13 10:08
 * @Version: 1.0
 */
@Controller
public class RoleModuleController {
    Logger logger = Logger.getLogger(RoleModuleController.class);
    Map<String, Object> map = new HashMap<>();
    @Autowired
    RoleModuleService roleModuleService;

    @ResponseBody
    @WebLog(description = "请求角色模块关联列表")
    @RequestMapping(value = "/a/u/relation")
    public Map selectByPrimaryKey(Long id) {
        logger.info(id);
        try {
            List<RoleModule> roleModules = roleModuleService.selectByDynamicCondition(id);
            map.put("roleModules", roleModules);
            map.put("code", 1);
            map.put("message", "成功");
            return map;
        } catch (Exception e) {
            map.put("code", 1);
            map.put("message", "失败");
            return map;
        }

    }

}
