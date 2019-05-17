package cn.wp.controller;

import cn.wp.aspect.WebLog;
import cn.wp.model.Module;
import cn.wp.service.ModuleService;
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
 * @ClassName: ModuleController
 * @Description: Module接口
 * @Author: 老王
 * @Date: 2019/5/13 10:07
 * @Version: 1.0
 */
@Controller
public class ModuleController {
    Logger logger = Logger.getLogger(ModuleController.class);
    Map<String, Object> map = new HashMap<>();
    @Autowired
    ModuleService moduleService;

    @ResponseBody
    @WebLog(description = "请求模块列表")
    @RequestMapping(value = "/a/u/module/list", method = RequestMethod.GET)
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
    @WebLog(description = "请求增加模块管理")
    @RequestMapping(value = "/a/u/module", method = RequestMethod.POST)
    public Map insert(Module record) {
        logger.info(record);
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(1L);
            record.setUpdateBy(3L);
            moduleService.insert(record);
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
    @WebLog(description = "请求更新模块管理")
    @RequestMapping(value = "/a/u/module/{id}", method = RequestMethod.PUT)
    public Map updateByPrimaryKey(Module record) {
        logger.info(record);
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(1L);
            record.setUpdateBy(1L);
            moduleService.updateByPrimaryKey(record);
            map.put("code", 1);
            map.put("message", "成");
            return map;
        } catch (Exception e) {
            map.put("code", -1);
            map.put("message", "败");
            return map;
        }
    }

    @ResponseBody
    @WebLog(description = "请求删除模块")
    @RequestMapping(value = "/a/u/module/{id}", method = RequestMethod.DELETE)
    public Map deleteByPrimaryKey(Long id) {
        logger.info(id);
        try {
            moduleService.deleteByPrimaryKey(id);
            map.put("code", 1);
            map.put("message", "成功咯");
            return map;
        } catch (Exception e) {
            map.put("code", -1);
            map.put("message", "失败");
            return map;
        }
    }

    @ResponseBody
    @WebLog(description = "请求查询所有模块管理")
    @RequestMapping(value = "/a/u/module/all", method = RequestMethod.GET)
    public Map selectAll() {
        try {
            List<Module> modules = moduleService.selectAll();
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
}
