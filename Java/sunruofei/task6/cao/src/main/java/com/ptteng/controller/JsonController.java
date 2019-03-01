package com.ptteng.controller;

import com.ptteng.Service.JsonService;
import com.ptteng.Service.JsonServiceImple.JsonServiceImp;
import com.ptteng.dao.JsonMapper;
import com.ptteng.entity.Json;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName JsonController
 * @Description 控制层
 * @Author 孙若飞
 * @Date 2019/2/22  16:35
 * @Version 1.0
 **/


@Controller
public class JsonController {

    @Autowired
    JsonService jsonService;

    static Logger logger = Logger.getLogger(JsonController.class);

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String selectAll(Model model) {
        try {
            //查出所有的id,放入ids
            List<Long> ids = jsonService.selectAllIds();
            System.out.println("ids=========" + ids);
            //通过所有的id,查出所有数据,放入data集合中
            List<Json> data = jsonService.selectByIdList(ids);

            System.out.println("data=========" + data);
            model.addAttribute("data", data);
            model.addAttribute("code", 1);
        } catch (Exception e) {
            model.addAttribute("code", -1);
        }
        return "all";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(Model model, Json json) {
        try {
            jsonService.insert(json);
            model.addAttribute("code", 1);

        } catch (Exception e) {
            model.addAttribute("code", -1);
        }
        return "data";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String delete(Model model, Long id) {
        try {
            jsonService.deleteByPrimaryKey(id);
            model.addAttribute("code", 1);
        } catch (Exception e) {
            model.addAttribute("code", -1);
        }
        return "data";
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(Model model, Json json) {
        try {
            jsonService.updateByPrimaryKey(json);
            model.addAttribute("code", 1);
        } catch (Exception e) {
            model.addAttribute("code", -1);
        }
        return "data";
    }

    @RequestMapping(value = "/selectById", method = RequestMethod.GET)
    public String selectById(Model model, Long id) {
        try {
            logger.info("id===========" + id);
            Json json = jsonService.selectByPrimaryKey(id);
            logger.info("json============" + json);
            List<Json> jsonList = new ArrayList<>();
            jsonList.add(json);
            model.addAttribute("data", jsonList);
            model.addAttribute("code", 1);
        } catch (Exception e) {
            model.addAttribute("code", -1);
        }
        return "all";

    }

}
