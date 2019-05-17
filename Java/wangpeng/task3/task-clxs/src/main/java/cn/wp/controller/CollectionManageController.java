package cn.wp.controller;

import cn.wp.aspect.WebLog;
import cn.wp.model.CollectionManage;
import cn.wp.service.CollectionManageService;
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
 * @ClassName: CollectionManageController
 * @Description:CollectionManage接口
 * @Author: 老王
 * @Date: 2019/5/13 10:05
 * @Version: 1.0
 */
@Controller
public class CollectionManageController {
    Logger logger = Logger.getLogger(CollectionManageController.class);
    Map<String, Object> map = new HashMap<>();
    @Autowired
    CollectionManageService collectionManageService;

    @ResponseBody
    @WebLog(description = "请求作品管理列表")
    @RequestMapping(value = "/a/u/manage/list", method = RequestMethod.GET)
    public Map selectByDynamicCondition(String name, Long state) {
        logger.info(name);
        logger.info(state);
        try {
            List<CollectionManage> collectionManages = collectionManageService.selectByDynamicCondition(name, state);
            map.put("collectionManages", collectionManages);
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
    @WebLog(description = "请求添加作品管理")
    @RequestMapping(value = "/a/u/manage", method = RequestMethod.POST)
    public Map insert(CollectionManage record) {
        logger.info(record);
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(2L);
            record.setUpdateBy(2L);
            collectionManageService.insert(record);
            map.put("code", 1);
            map.put("message", "成功2");
            return map;

        } catch (Exception e) {
            map.put("code", -1);
            map.put("message", "失败");
            return map;
        }
    }

    @ResponseBody
    @WebLog(description = "请求删除作品管理")
    @RequestMapping(value = "/a/u/manage/{id}", method = RequestMethod.DELETE)
    public Map deleteByPrimaryKey(Long id) {
        logger.info(id);
        try {
            collectionManageService.deleteByPrimaryKey(id);
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
    @WebLog(description = "请求更新作品管理")
    @RequestMapping(value = "/a/u/manage/{id}", method = RequestMethod.PUT)
    public Map updateByPrimaryKey(CollectionManage record) {
        logger.info(record);
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(1L);
            record.setUpdateBy(2L);
            collectionManageService.updateByPrimaryKeySelective(record);
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
    @WebLog(description = "请求查询所有作品管理")
    @RequestMapping(value = "/a/u/manage/all", method = RequestMethod.GET)
    public Map selectAll() {
        try {
            List<CollectionManage> collectionManages = collectionManageService.selectAll();
            map.put("collectionManages", collectionManages);
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
