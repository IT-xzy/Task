package com.ptteng.controller;

import com.ptteng.model.WorkRoom;
import com.ptteng.service.WorkRoomService;
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
 * @ClassName WorkRoomController
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/1/27  18:45
 * @Version 1.0
 **/

@Controller
public class WorkRoomController {
    Logger logger = Logger.getLogger(WorkRoomController.class);
    Map<String, Object> map = new HashMap<>();
    @Autowired
    WorkRoomService workRoomService;

    @ResponseBody
    @RequestMapping(value = "/work/room/list", method = RequestMethod.GET)
    public Map selectByDynamicCondition(String name, Long state) {
        logger.info(name);
        logger.info(state);
        try {
            List<WorkRoom> workRooms = workRoomService.selectByDynamicCondition(name, state);
            map.put("workRooms", workRooms);
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
    @RequestMapping(value = "/work/room", method = RequestMethod.POST)
    public Map insert(WorkRoom record) {
        logger.info(record);
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(1L);
            record.setUpdateBy(2L);
            workRoomService.insert(record);
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
    @RequestMapping(value = "/work/room", method = RequestMethod.DELETE)
    public Map deleteByPrimaryKey(Long id) {
        logger.info(id);
        try {
            workRoomService.deleteByPrimaryKey(id);
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
    @RequestMapping(value = "/work/room",method = RequestMethod.PUT)
    public Map updateByPrimaryKey(WorkRoom record){
        logger.info(record);
        try{
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(1L);
            record.setUpdateBy(2L);
            workRoomService.updateByPrimaryKey(record);
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
