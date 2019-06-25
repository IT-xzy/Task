package cn.wp.controller;

import cn.wp.aspect.WebLog;
import cn.wp.model.Classification;
import cn.wp.service.ClassificationService;
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
 * @ClassName: CollectionClassController
 * @Description:CollectionClass接口
 * @Author: 老王
 * @Date: 2019/5/13 10:04
 * @Version: 1.0
 */
@Controller
public class ClassificationController {
    Logger logger = Logger.getLogger(ClassificationController.class);
    Map<String, Object> map = new HashMap<>();
    @Autowired
    ClassificationService classificationService;

    @ResponseBody
    @WebLog(description = "请求作品分类列表")
    @RequestMapping(value = "/a/u/class/list", method = RequestMethod.GET)
    public Map selectByDynamicCondition(String name, Long state) {
        logger.info(name);
        logger.info(state);
        try {
            List<Classification> classifications = classificationService.selectByDynamicCondition(name, state);
            map.put("collectionClasses", classifications);
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
    @WebLog(description = "请求增加作品分类")
    @RequestMapping(value = "/a/u/class", method = RequestMethod.POST)
    public Map insert(Classification record) {
        logger.info(record);
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(1L);
            record.setUpdateBy(2L);
            record.setState(2L);
            classificationService.insert(record);
            map.put("code", 1);
            map.put("message", "对");
            return map;
        } catch (Exception e) {
            map.put("code", -1);
            map.put("message", "错");
            return map;
        }

    }

    @ResponseBody
    @WebLog(description = "请求删除作品分类")
    @RequestMapping(value = "/a/u/class/{id}", method = RequestMethod.DELETE)
    public Map deleteByPrimaryKey(Long id) {
        logger.info(id);
        try {
            classificationService.deleteByPrimaryKey(id);
            map.put("code", 1);
            map.put("message", "成功了");
            return map;
        } catch (Exception e) {
            map.put("code", -1);
            map.put("message", "失败");
            return map;
        }
    }

    @ResponseBody
    @WebLog(description = "请求更新作品分类")
    @RequestMapping(value = "/a/u/class/{id}", method = RequestMethod.PUT)
    public Map updateByPrimaryKey(Classification record) {
        logger.info(record);
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(1L);
            record.setUpdateBy(1L);
            record.setState(2L);
            classificationService.updateByPrimaryKey(record);
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
    @WebLog(description = "请求查询所有作品分类")
    @RequestMapping(value = "/a/u/class/all", method = RequestMethod.GET)
    public Map selectAll() {
        try {
            List<Classification> classifications = classificationService.selectAll();
            map.put("collectionClasses", classifications);
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
