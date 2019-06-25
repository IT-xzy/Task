package cn.wp.controller;

import cn.wp.aspect.WebLog;
import cn.wp.model.Message;
import cn.wp.service.MessageService;
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
 * @ClassName: MessageController
 * @Description: Message接口
 * @Author: 老王
 * @Date: 2019/5/13 10:06
 * @Version: 1.0
 */
@Controller
public class MessageController {
    Logger logger = Logger.getLogger(MessageController.class);
    Map<String, Object> map = new HashMap<>();
    @Autowired
    MessageService messageService;

    @ResponseBody
    @WebLog(description = "请求留言列表")
    @RequestMapping(value = "/a/u/message/list", method = RequestMethod.GET)
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
    @WebLog(description = "请求增加留言")
    @RequestMapping(value = "/a/u/message", method = RequestMethod.POST)
    public Map insert(Message record) {
        logger.info(record);
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(1L);
            record.setUpdateBy(1L);
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
    @WebLog(description = "请求删除留言")
    @RequestMapping(value = "/a/u/message/{id}", method = RequestMethod.DELETE)
    public Map deleteByPrimaryKey(Long id) {
        logger.info(id);
        try {
            messageService.deleteByPrimaryKey(id);
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
    @WebLog(description = "请求更新留言")
    @RequestMapping(value = "/a/u/message/{id}", method = RequestMethod.PUT)
    public Map updateByPrimaryKey(Message record) {
        logger.info(record);
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(2L);
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

    @ResponseBody
    @WebLog(description = "请求查询所有留言")
    @RequestMapping(value = "/a/u/message/all", method = RequestMethod.GET)
    public Map selectAll() {
        try {
            List<Message> messages = messageService.selectAll();
            map.put("messages", messages);
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
