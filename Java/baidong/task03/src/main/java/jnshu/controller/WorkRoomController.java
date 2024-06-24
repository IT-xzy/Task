package jnshu.controller;

import jnshu.mapper.UserMapper;
import jnshu.mapper.WorkRoomMapper;
import jnshu.model.User;
import jnshu.model.WorkRoom;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
public class WorkRoomController {
    private static final Logger logger = Logger.getLogger(WorkRoomController.class);
    Map<String, Object> map = new HashMap<>();
    @Autowired
    WorkRoomMapper workRoomMapper;

    @ResponseBody
    @RequestMapping(value = "/a/work/room/list", method = RequestMethod.GET)
    public Map selectByDynamicCondition(String name, Long status) {
        try {
            logger.info("传入动态参数" + status + name);
            List<WorkRoom> workRoom = workRoomMapper.selectByDynamicCondition(name, status);
            map.put("code", 1000);
            map.put("secondWorks", workRoom);
            logger.info("输出动态参数" + map);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/a/work/room", method = RequestMethod.POST)
    public Map insertSelective(WorkRoom record) {
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(2L);
            record.setUpdateBy(2L);
            logger.info("增加传入参数" + record);
            int workRoom = workRoomMapper.insertSelective(record);
            map.put("code", 1000);
            logger.info("输出增加参数" + workRoom);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }


    @ResponseBody
    @RequestMapping(value = "/a/work/room", method = RequestMethod.DELETE)
    public Map deleteByPrimaryKey(Long id) {
        try {
            logger.info("输入删除ID" + id);
            int workRoom = workRoomMapper.deleteByPrimaryKey(id);
            map.put("code", 1000);
            logger.info("输出删除结果" + map);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }


    @ResponseBody
    @RequestMapping(value = "/a/work/room", method = RequestMethod.PUT)
    public Map updateByPrimaryKey(WorkRoom record) {
        try {
            record.setUpdateAt(System.currentTimeMillis());
            record.setUpdateBy(2L);
            logger.info("传入修改参数" + record);
            int workRoom = workRoomMapper.updateByPrimaryKey(record);
            map.put("code", 1000);
            logger.info("输出修改结果" + map);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }
}
