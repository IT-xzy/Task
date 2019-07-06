package jnshu.controller;

import jnshu.mapper.SecondWorksMapper;
import jnshu.model.FirstWorks;
import jnshu.model.SecondWorks;
import jnshu.service.FirstWorksService;
import jnshu.service.SecondWorksService;
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
public class SecondWorksController {

    private static final Logger logger = Logger.getLogger(SecondWorksController.class);
    Map<String, Object> map = new HashMap<>();
    @Autowired
    SecondWorksService secondWorksService;

    @ResponseBody
    @RequestMapping(value = "/a/second/collection/list", method = RequestMethod.GET)
    public Map selectByDynamicCondition(String secondName, Long status) {
        try {
            logger.info("传入动态参数" + status + secondName);
            List<SecondWorks> secondWorks = secondWorksService.selectByDynamicCondition(secondName, status);
            map.put("code", 1000);
            map.put("secondWorks", secondWorks);
            logger.info("输出动态参数" + map);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/a/second/collection", method = RequestMethod.POST)
    public Map insertSelective(SecondWorks record) {
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(2L);
            record.setUpdateBy(2L);
            logger.info("增加传入参数" + record);
            int secondWorks = secondWorksService.insertSelective(record);
            map.put("code", 1000);
            logger.info("输出增加参数" + secondWorks);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }


    @ResponseBody
    @RequestMapping(value = "/a/second/collection", method = RequestMethod.DELETE)
    public Map deleteByPrimaryKey(Long id) {
        try {
            logger.info("输入删除ID" + id);
            int secondWorks = secondWorksService.deleteByPrimaryKey(id);
            map.put("code", 1000);
            logger.info("输出删除结果" + map);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/a/second/collection", method = RequestMethod.PUT)
    public Map updateByPrimaryKey(SecondWorks record) {
        try {
            record.setUpdateAt(System.currentTimeMillis());
            record.setUpdateBy(2L);
            logger.info("传入修改参数" + record);
            int secondWorks = secondWorksService.updateByPrimaryKey(record);
            map.put("code", 1000);
            logger.info("输出修改结果" + map);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }
}
