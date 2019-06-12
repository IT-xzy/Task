package jnshu.controller;


import jnshu.model.Banner;
import jnshu.service.BannerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BannerController {
    private static final Logger logger = Logger.getLogger(BannerController.class);
    Map<String, Object> map = new HashMap<>();
    @Autowired
    BannerService bannerService;

    @ResponseBody
    @RequestMapping(value = "/a/u/banner/list", method = RequestMethod.GET)
    public Map selectByDynamicCondition(Long status,  String name) {
        try {

            logger.info("传入动态参数" + status + name);
            List<Banner> banner = bannerService.selectByDynamicCondition(status,name);

            map.put("code", 1000);
            map.put("banner", banner);
            logger.info("输出动态参数" + map);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/a/u/banner", method = RequestMethod.POST)
    public Map insertSelective(Banner record) {
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(2L);
            record.setUpdateBy(2L);
            logger.info("增加传入参数" + record);
            int banner = bannerService.insertSelective(record);
            map.put("code", 1000);
            logger.info("输出增加参数" + map);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }


    @ResponseBody
    @RequestMapping(value = "/a/u/banner", method = RequestMethod.DELETE)
    public Map deleteByPrimaryKey(Long id) {
        try {

            logger.info("增加传入参数" + id);
            int bannerId = bannerService.deleteByPrimaryKey(id);

            map.put("code", 1000);
            logger.info("输出增加参数" + map);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/a/u/banner", method = RequestMethod.PUT)
    public Map updateByPrimaryKey(Banner record) {
        try {
            record.setUpdateAt(System.currentTimeMillis());
            record.setUpdateBy(2L);
            logger.info("增加传入参数" + record);
            int banner = bannerService.updateByPrimaryKey(record);
            map.put("code", 1000);
            logger.info("输出增加参数" + map);
            return map;
        } catch (Exception e) {
            map.put("code", -1000);
            return map;
        }
    }


}
