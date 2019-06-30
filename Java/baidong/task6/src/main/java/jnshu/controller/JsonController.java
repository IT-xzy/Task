package jnshu.controller;

import jnshu.Service.JsonService;
import jnshu.entity.Json;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Controller
public class JsonController {

    @Resource(name="JsonServiceImp")
    JsonService jsonService;

    static Logger logger = Logger.getLogger(JsonController.class);

    @RequestMapping(value = "/a/user/all", method = RequestMethod.GET)
    public String selectAl(Model model) {
        try {
            logger.info("begin==============");
            List<Json> data = jsonService.selectAll();
            logger.info("out==============" + data);
            model.addAttribute("code", 1);
            model.addAttribute("message", "成功");
            model.addAttribute("data", data);
        } catch (Exception e) {
            model.addAttribute("code", -1);
            model.addAttribute("message", "失败");
        }
        return "all";
    }


    //    查找全部的话，首先查找出他们的id，其次根据id去查找他们的每一条数据，放入集合中。（这里因为要用到缓存，所以需要先查找id，根据id再去查找他们的缓存中的键值对）
    @RequestMapping(value = "/a/all", method = RequestMethod.GET)
    public String selsevtAll(Model model) {

        try {
            List<Long> ids = jsonService.selectAllIds();
            logger.info("ids==============" + ids);
            List<Json> list = jsonService.selectByIdList(ids);
            logger.info("list==============" + ids);
            model.addAttribute("code", 1);
            model.addAttribute("data", list);

        }catch(Exception e){
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
        return "all";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String delete(Model model, Long id) {
        try {
            jsonService.deleteByPrimaryKey(id);
            model.addAttribute("code", 1);
        } catch (Exception e) {
            model.addAttribute("code", -1);
        }
        return "all";
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(Model model, Json json) {
        try {
            jsonService.updateByPrimaryKey(json);
            model.addAttribute("code", 1);
        } catch (Exception e) {
            model.addAttribute("code", -1);
        }
        return "all";
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