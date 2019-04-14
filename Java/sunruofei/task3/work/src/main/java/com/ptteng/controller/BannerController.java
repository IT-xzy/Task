package com.ptteng.controller;


import com.ptteng.model.Banner;
import com.ptteng.service.BannerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



/*
Banner的接口
 */

//将这个类作为bean注入到spring容器中
@Controller
public class BannerController {
    //定义log4j日志
    Logger logger = Logger.getLogger(BannerController.class);
    //定义Map集合,使用Map集合是因为它是键值对应的
    Map<String, Object> map = new HashMap<>();
    //    取出service层的bean
    @Autowired
    BannerService bannerService;

    //加上 @ResponseBody 后，会直接返回 json 数据
    @ResponseBody
//    @RequestMapping是为控制器指定可以处理的URL,后面的method= RequestMethod.GET 是rest风格
    @RequestMapping(value = "/banner/list", method = RequestMethod.GET)
/**
 * @Author 孙若飞
 * @Description //TODO
 * @Date 21:00 2019/1/26
 * @Param [state, createBy]
 * @return java.util.Map
 **/
//    返回值为Map类型的方法,参数为Integer state, String createBy
    public Map selectByDynamicCondition(Integer state, String createBy) {
        logger.info(state);
        logger.info(createBy);
        //    try,catch捕获异常

        try {
//     调用bannerService里的条件查询方法,并将得到的值赋给banners
            List<Banner> banners = bannerService.selectByDynamicCondition(state, createBy);
//     将键值对应的数据放入map里,code 1和message 成功 代表数据返回成功
            map.put("code", 1);
            map.put("message", "成功");
            map.put("banner", banners);
//     打印出来map
            logger.info(map);
            return map;
        } catch (Exception e) {
//            code -1和message 失败 代表数据返回失败
            map.put("code", -1);
            map.put("message", "失败");
            return map;
        }
    }

    //    直接返回json格式的数据
    @ResponseBody
    @RequestMapping(value = "/banner", method = RequestMethod.POST)
    public Map insert(Banner record) {
        logger.info(record);
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(2L);
            record.setUpdateBy(3L);
            bannerService.insert(record);
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
    @RequestMapping(value = "/banner", method = RequestMethod.DELETE)
    public Map deleteByPrimaryKey(Long id) {
        logger.info(id);
        try {
            bannerService.deleteByPrimaryKey(id);
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
    @RequestMapping(value = "/banner", method = RequestMethod.PUT)
    public Map updateByPrimaryKey(Banner record) {
        logger.info(record);
        try {
            record.setCreateAt(System.currentTimeMillis());
            record.setUpdateAt(System.currentTimeMillis());
            record.setCreateBy(2L);
            record.setUpdateBy(3L);
            bannerService.updateByPrimaryKey(record);
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
