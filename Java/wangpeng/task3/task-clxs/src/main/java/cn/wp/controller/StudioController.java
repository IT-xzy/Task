package cn.wp.controller;

import cn.wp.aspect.WebLog;
import cn.wp.model.Studio;
import cn.wp.service.StudioService;
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
 * @ClassName: StudioController
 * @Description: Studio接口
 * @Author: 老王
 * @Date: 2019/5/13 10:09
 * @Version: 1.0
 */
@Controller
public class StudioController {
    Logger logger = Logger.getLogger(StudioController.class);
    Map<String, Object> map = new HashMap<>();
    @Autowired
    StudioService studioService;

    @ResponseBody
    @WebLog(description = "请求工作室列表")
    @RequestMapping(value = "/a/u/studio/list", method = RequestMethod.GET)
    public Map selectByDynamicCondition(String name, Long state) {
        logger.info(name);
        logger.info(state);
        try {
            List<Studio> studios = studioService.selectByDynamicCondition(name, state);
            map.put("studios", studios);
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
    @WebLog(description = "请求添加工作室")
    @RequestMapping(value = "/a/u/studio", method = RequestMethod.POST)
    public Map insert(Studio record) {
        logger.info(record);
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(12L);
            record.setUpdateBy(21L);
            studioService.insert(record);
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
    @WebLog(description = "请求删除工作室")
    @RequestMapping(value = "/a/u/studio/{id}", method = RequestMethod.DELETE)
    public Map deleteByPrimaryKey(Long id) {
        logger.info(id);
        try {
            studioService.deleteByPrimaryKey(id);
            map.put("code", 4);
            map.put("message", "成功");
            return map;
        } catch (Exception e) {
            map.put("code", -4);
            map.put("message", "失败");
            return map;
        }
    }

    @ResponseBody
    @WebLog(description = "请求更新工作室")
    @RequestMapping(value = "/a/u/studio/{id}", method = RequestMethod.PUT)
    public Map updateByPrimaryKey(Studio record) {
        logger.info(record);
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(3L);
            record.setUpdateBy(3L);
            studioService.updateByPrimaryKey(record);
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
    @WebLog(description = "请求查询所有工作室")
    @RequestMapping(value = "/a/u/studio/all", method = RequestMethod.GET)
    public Map selectAll() {
        try {
            List<Studio> studios = studioService.selectAll();
            map.put("studios", studios);
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
