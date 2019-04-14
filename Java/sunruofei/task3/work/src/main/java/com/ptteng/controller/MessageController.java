package com.ptteng.controller;

import com.ptteng.model.Message;
import com.ptteng.service.MessageService;
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
 * @ClassName MessageController
 * @Description TODO 如何增加和修改
 * @Author 孙若飞
 * @Date 2019/1/27  11:43
 * @Version 1.0
 **/
@Controller
public class MessageController {
    Logger logger = Logger.getLogger(ManagerController.class);
    Map<String, Object> map = new HashMap<>();
    @Autowired
    MessageService messageService;

    @ResponseBody
    @RequestMapping(value = "/message/list", method = RequestMethod.GET)
    public Map selectByDynamicCondition(String name, Long state) {
        logger.info(name);
        logger.info(state);
        try {
            List<Message> messages = messageService.selectByDynamicCondition(name, state);
            map.put("managers", messages);
            map.put("code", 1);
            map.put("message", "成功");
            return map;
        } catch (Exception e) {
            map.put("code", -1);
            map.put("message", "成功");
            return map;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public Map insert(Message record) {
        logger.info(record);
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(1L);
            record.setUpdateBy(2L);
            messageService.insert(record);
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
    @RequestMapping(value = "/message", method = RequestMethod.DELETE)
    public Map deleteByPrimaryKey(Long id) {
        logger.info(id);
        try {
            messageService.deleteByPrimaryKey(id);
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
    @RequestMapping(value = "/message",method = RequestMethod.PUT)
    public Map updateByPrimaryKey(Message record){
        logger.info(record);
        try{
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(1L);
            record.setUpdateBy(2L);
            messageService.updateByPrimaryKey(record);
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
