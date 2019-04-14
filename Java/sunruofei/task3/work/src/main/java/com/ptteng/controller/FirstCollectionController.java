package com.ptteng.controller;

import com.ptteng.model.FirstCollection;
import com.ptteng.service.FirstCollectionService;
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
 * @ClassName FirstCollectionController
 * @Description TODO 插入修改有问题
 * @Author 孙若飞
 * @Date 2019/1/26  20:38
 * @Version 1.0
 **/
@Controller
public class FirstCollectionController {
    Logger logger = Logger.getLogger(FirstCollectionController.class);
    Map<String, Object> map = new HashMap<>();
    @Autowired
    FirstCollectionService firstCollectionService;

    @ResponseBody
    @RequestMapping(value = "/first/collection/list", method = RequestMethod.GET)
    public Map selectByDynamicCondition(String name, Long state) {
        logger.info(name);
        logger.info(state);
        try {
            List<FirstCollection> firstCollections = firstCollectionService.selectByDynamicCondition(name, state);
            map.put("firstCollections", firstCollections);
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
    @RequestMapping(value = "/first/collection", method = RequestMethod.POST)
    public Map insert(FirstCollection record) {
        logger.info(record);
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(1L);
            record.setUpdateBy(2L);
            record.setState(2L);
            firstCollectionService.insert(record);
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
    @RequestMapping(value = "/first/collection", method = RequestMethod.DELETE)
    public Map deleteByPrimaryKey(Long id) {
        logger.info(id);
        try {
            firstCollectionService.deleteByPrimaryKey(id);
            map.put("code",1);
            map.put("message","成功了");
            return map;
        }catch (Exception e) {
            map.put("code",-1);
            map.put("message","失败");
            return map;
        }
    }
    @ResponseBody
    @RequestMapping(value = "/first/collection",method = RequestMethod.PUT)
    public Map updateByPrimaryKey(FirstCollection record){
        logger.info(record);
        try{
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(1L);
            record.setUpdateBy(1L);
            record.setState(2L);
            firstCollectionService.updateByPrimaryKey(record);
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
