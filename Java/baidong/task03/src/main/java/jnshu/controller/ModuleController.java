package jnshu.controller;

import jnshu.model.FirstWorks;

import jnshu.model.Module;
import jnshu.service.ModuleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
@Controller
public class ModuleController {
  private static final Logger logger = Logger.getLogger(ModuleController.class);
    Map<String, Object> map = new HashMap<>();
    @Autowired
    ModuleService moduleService;

    @ResponseBody
    @RequestMapping(value = "/a/module/list", method = RequestMethod.GET)
    public Map selectByDynamicCondition(String moduleName) {
        try {
            logger.info("传入动态参数" + moduleName);
            List<Module> module = moduleService.selectByDynamicCondition(moduleName);
            map.put("code", 1000);
            map.put("banner", module);
            logger.info("输出动态参数" + map);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/a/module", method = RequestMethod.POST)
    public Map insertSelective(Module record) {
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(2L);
            record.setUpdateBy(2L);
            logger.info("增加传入参数" + record);
            int model = moduleService.insertSelective(record);
            map.put("code", 1000);
            logger.info("输出增加参数" +model);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }


    @ResponseBody
    @RequestMapping(value = "/a/module", method = RequestMethod.DELETE)
    public Map deleteByPrimaryKey(Long id) {
        try {
            logger.info("输入删除ID" + id);
            int module = moduleService.deleteByPrimaryKey(id);
            map.put("code", 1000);
            logger.info("输出删除结果" + module);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/a/module", method = RequestMethod.PUT)
    public Map updateByPrimaryKey(Module record) {
        try {
            record.setUpdateAt(System.currentTimeMillis());
            record.setUpdateBy(2L);
            logger.info("传入修改参数" + record);
            int Module = moduleService.updateByPrimaryKey(record);
            map.put("code", 1000);
            logger.info("输出修改结果" + Module);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }
}

