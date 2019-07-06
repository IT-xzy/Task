package jnshu.controller;
import jnshu.model.Works;
import jnshu.service.WorksService;
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
public class WorksController {
    private static final Logger logger = Logger.getLogger(WorksController.class);
    Map<String, Object> map = new HashMap<>();
    @Autowired
    WorksService worksService;

    @ResponseBody
    @RequestMapping(value = "/a/works/list", method = RequestMethod.GET)
    public Map selectByDynamicCondition(String name, Long status) {
        try {
            logger.info("传入动态参数" + status + name);
            List<Works> workRoom = worksService.selectByDynamicCondition(name, status);
            map.put("code", 1000);
            map.put("workRoom", workRoom);
            logger.info("输出动态参数" + map);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/a/works", method = RequestMethod.POST)
    public Map insertSelective(Works record) {
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(2L);
            record.setUpdateBy(2L);
            logger.info("增加传入参数" + record);
            int works = worksService.insertSelective(record);
            map.put("code", 1000);
            logger.info("输出增加参数" + works);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }


    @ResponseBody
    @RequestMapping(value = "/a/works", method = RequestMethod.DELETE)
    public Map deleteByPrimaryKey(Long id) {
        try {
            logger.info("输入删除ID" + id);
            int Works = worksService.deleteByPrimaryKey(id);
            map.put("code", 1000);
            logger.info("输出删除结果" + Works);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }


    @ResponseBody
    @RequestMapping(value = "/a/works", method = RequestMethod.PUT)
    public Map updateByPrimaryKey(Works record) {
        try {
            record.setUpdateAt(System.currentTimeMillis());
            record.setUpdateBy(2L);
            logger.info("传入修改参数" + record);
            int Works = worksService.updateByPrimaryKey(record);
            map.put("code", 1000);
            logger.info("输出修改结果" + Works);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }
}
