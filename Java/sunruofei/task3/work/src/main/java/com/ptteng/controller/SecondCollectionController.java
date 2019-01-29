package com.ptteng.controller;

import com.ptteng.model.SecondCollection;
import com.ptteng.service.SecondCollectionService;
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
 * @ClassName SecondCollectionController
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/1/27  16:19
 * @Version 1.0
 **/

@Controller
public class SecondCollectionController {
    Logger logger = Logger.getLogger(SecondCollectionController.class);
    Map<String, Object> map = new HashMap<>();
    @Autowired
    SecondCollectionService secondCollectionService;

    @ResponseBody
    @RequestMapping(value = "/second/collection/list", method = RequestMethod.GET)
    public Map selectByDynamicCondition(String name, Long state) {
        logger.info(name);
        logger.info(state);
        try {
            List<SecondCollection> secondCollections = secondCollectionService.selectByDynamicCondition(name, state);
            map.put("secondCollections", secondCollections);
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
    @RequestMapping(value = "/second/collection", method = RequestMethod.POST)
    public Map insert(SecondCollection record) {
        logger.info(record);
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(1L);
            record.setUpdateBy(2L);
            secondCollectionService.insert(record);
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
    @RequestMapping(value = "/second/collection", method = RequestMethod.DELETE)
    public Map deleteByPrimaryKey(Long id) {
        logger.info(id);
        try {
            secondCollectionService.deleteByPrimaryKey(id);
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
    @RequestMapping(value = "/second/collection", method = RequestMethod.PUT)
    public Map updateByPrimaryKey(SecondCollection record) {
        logger.info(record);
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(1L);
            record.setUpdateBy(2L);
            secondCollectionService.updateByPrimaryKeySelective(record);
            map.put("code", 1);
            map.put("message", "成功");
            return map;
        } catch (Exception e) {
            map.put("code", -1);
            map.put("message", "失败");
            return map;
        }    }
}
