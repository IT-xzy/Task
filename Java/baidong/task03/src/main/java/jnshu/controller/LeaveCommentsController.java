package jnshu.controller;

import jnshu.model.FirstWorks;
import jnshu.model.LeaveComments;
import jnshu.service.FirstWorksService;
import jnshu.service.LeaveCommentsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeaveCommentsController {

    private static final Logger logger = Logger.getLogger(LeaveCommentsController.class);
    Map<String, Object> map = new HashMap<>();
    @Autowired
    LeaveCommentsService leaveCommentsService;

    @ResponseBody
    @RequestMapping(value = "/a/first/collection/list", method = RequestMethod.GET)
    public Map selectByDynamicCondition(Long status, String worksName) {
        try {
            logger.info("传入动态参数" + status + worksName);
            List<LeaveComments> leaveComments = leaveCommentsService.selectByDynamicCondition(status,worksName);
            map.put("code", 1000);
            map.put("banner", leaveComments);
            logger.info("输出动态参数" + map);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/a/first/collection", method = RequestMethod.POST)
    public Map insertSelective(LeaveComments record) {
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(2L);
            record.setUpdateBy(2L);
            logger.info("增加传入参数" + record);
            int firstWorks = leaveCommentsService.insertSelective(record);
            map.put("code", 1000);
            logger.info("输出增加参数" + firstWorks);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }


    @ResponseBody
    @RequestMapping(value = "/a/first/collection", method = RequestMethod.DELETE)
    public Map deleteByPrimaryKey(Long id) {
        try {
            logger.info("输入删除ID" + id);
            int banner = leaveCommentsService.deleteByPrimaryKey(id);
            map.put("code", 1000);
            logger.info("输出删除结果" + map);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/a/first/collection", method = RequestMethod.PUT)
    public Map updateByPrimaryKey(LeaveComments record) {
        try {
            record.setUpdateAt(System.currentTimeMillis());
            record.setUpdateBy(2L);
            logger.info("传入修改参数" + record);
            int leaveComments = leaveCommentsService.updateByPrimaryKey(record);
            map.put("code", 1000);
            logger.info("输出修改结果" + leaveComments);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }
}
