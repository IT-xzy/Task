package cn.wp.controller;

import cn.wp.aspect.WebLog;
import cn.wp.model.Works;
import cn.wp.service.WorksService;
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
 * @ClassName: WorksController
 * @Description: Works接口
 * @Author: 老王
 * @Date: 2019/5/13 10:09
 * @Version: 1.0
 */
@Controller
public class WorksController {
    Logger logger = Logger.getLogger(WorksController.class);
    Map<String, Object> map = new HashMap<>();
    @Autowired
    WorksService worksService;

    @ResponseBody
    @WebLog(description = "请求作品列表")
    @RequestMapping(value = "/a/u/works/list", method = RequestMethod.GET)
    public Map selectByDynamicCondition(String name, Long state) {
        logger.info(name);
        logger.info(state);
        try {
            List<Works> works = worksService.selectByDynamicCondition(name, state);
            map.put("works", works);
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
    @WebLog(description = "请求删除作品")
    @RequestMapping(value = "/a/u/works/{id}", method = RequestMethod.DELETE)
    public Map deleteByPrimaryKey(Long id) {
        logger.info(id);
        try {
            worksService.deleteByPrimaryKey(id);
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
    @WebLog(description = "请求更新作品")
    @RequestMapping(value = "/a/u/works/{id}", method = RequestMethod.PUT)
    public Map updateByPrimaryKey(Works record) {
        logger.info(record);
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(1L);
            record.setUpdateBy(2L);
            worksService.updateByPrimaryKey(record);
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
    @WebLog(description = "请求添加作品")
    @RequestMapping(value = "/a/u/works", method = RequestMethod.POST)
    public Map insert(Works record) {
        logger.info(record);
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(1L);
            record.setUpdateBy(2L);
            worksService.insert(record);
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
    @WebLog(description = "请求查询所有作品")
    @RequestMapping(value = "/a/u/works/all", method = RequestMethod.GET)
    public Map selectAll() {
        try {
            List<Works> works = worksService.selectAll();
            map.put("works", works);
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
