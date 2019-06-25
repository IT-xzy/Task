package cn.wp.controller;

import cn.wp.aspect.WebLog;
import cn.wp.entity.Json;
import cn.wp.service.JsonService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/** @ClassName: @Description: @Author: 老王 @Date: 2019/6/1 14:48 @Version: 1.0 */
@Controller
public class JsonController {

  @Autowired JsonService jsonService;
  Logger logger = Logger.getLogger(JsonController.class);

  /** 使用自定义注解打印日志 */
  @WebLog(description = "查询")
  @RequestMapping(value = "/a/u/js", method = RequestMethod.GET)
  public String selectAll(Model model) {
    try {
      List<Json> jsons = jsonService.selectAll();
      logger.info("======================" + jsons);
      model.addAttribute("jsons", jsons);
      model.addAttribute("code", 1);
      return "all";
    } catch (Exception e) {
      model.addAttribute("code", -1);
      return "all";
    }
  }

  @WebLog(description = "查询")
  @RequestMapping(value = "/a/u/page", method = RequestMethod.GET)
  public String findAll(Model model) {
    try {
      // 查出所有的id,放入ids
      List<Long> ids = jsonService.selectAllIds();
      System.out.println("ids=========" + ids);
      // 通过所有的id,查出所有数据,放入data集合中
      List<Json> data = jsonService.selectByIdList(ids);
      System.out.println("data=========" + data);
      model.addAttribute("data", data);
      model.addAttribute("code", 1);
    } catch (Exception e) {
      model.addAttribute("code", -1);
    }
    return "findAll";
  }

  @WebLog(description = "增")
  @RequestMapping(value = "/insert", method = RequestMethod.POST)
  public String insert(Model model, Json json) {
    try {
      json.setId(9L);
      json.setName("大佬");
      json.setQq(1222222L);
      json.setPhone(9999999999L);
      jsonService.insert(json);
      model.addAttribute("code", 1);

    } catch (Exception e) {
      model.addAttribute("code", -1);
    }
    return "data";
  }

  @WebLog(description = "删")
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

  @WebLog(description = "改")
  @RequestMapping(value = "/update", method = RequestMethod.PUT)
  public String update(Model model, Json json) {
    try {
      json.setId(8L);
      json.setName("大佬B");
      json.setQq(66622222L);
      json.setPhone(994444999L);
      jsonService.update(json);
      model.addAttribute("code", 1);
    } catch (Exception e) {
      model.addAttribute("code", -1);
    }
    return "data";
  }

  @WebLog(description = "查")
  @RequestMapping(value = "/select", method = RequestMethod.GET)
  public String selectById(Model model, Long id) {
    try {
      logger.info("id===========" + id);
      Json json = jsonService.selectByPrimaryKey(id);
      Long end = System.currentTimeMillis();
      logger.info("json============" + json);
      List<Json> jsonList = new ArrayList<>();
      jsonList.add(json);
      model.addAttribute("data", jsonList);
      model.addAttribute("code", 1);
    } catch (Exception e) {
      model.addAttribute("code", -1);
    }
    return "findAll";
  }
}
