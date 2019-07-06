package jnshu.controller;

import jnshu.model.FirstWorks;
import jnshu.service.FirstWorksService;
import org.apache.ibatis.annotations.Param;
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
public class FirstWorksController {
    private static final Logger logger = Logger.getLogger(FirstWorksController.class);
    Map<String, Object> map = new HashMap<>();
    @Autowired
    FirstWorksService firstWorksService;

    @ResponseBody
    @RequestMapping(value = "/a/first/collection/list", method = RequestMethod.GET)
    public Map selectByDynamicCondition(String firstName, Long status) {
        try {
            logger.info("传入动态参数" + status + firstName);
            List<FirstWorks> firstWorks = firstWorksService.selectByDynamicCondition(firstName, status);
            map.put("code", 1000);
            map.put("code", "成功");
            map.put("banner", firstWorks);
            logger.info("输出动态参数" + map);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            map.put("code", "失败");
            return map;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/a/first/collection", method = RequestMethod.POST)
    public Map insertSelective(FirstWorks record) {
        try {
            record.setStateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(2L);
            record.setUpdateBy(2L);
            logger.info("增加传入参数" + record);
            int firstWorks = firstWorksService.insertSelective(record);
            map.put("code", 1000);
            map.put("code", "成功");
            logger.info("输出增加参数" + firstWorks);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            map.put("code", "失败");
            return map;
        }
    }


    @ResponseBody
    @RequestMapping(value = "/a/first/collection", method = RequestMethod.DELETE)
    public Map deleteByPrimaryKey(Long id) {
        try {
            logger.info("输入删除ID" + id);
            int banner = firstWorksService.deleteByPrimaryKey(id);
            map.put("code", 1000);
            map.put("code", "成功");
            logger.info("输出删除结果" + map);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            map.put("code", "失败");
            return map;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/a/first/collection", method = RequestMethod.PUT)
    public Map updateByPrimaryKey(FirstWorks record) {
        try {
            record.setUpdateAt(System.currentTimeMillis());
            record.setUpdateBy(2L);
            logger.info("传入修改参数" + record);
            int banner = firstWorksService.updateByPrimaryKey(record);
            map.put("code", 1000);
            map.put("code", "成功");
            logger.info("输出修改结果" + map);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            map.put("code", "失败");
            return map;
        }
    }


}
