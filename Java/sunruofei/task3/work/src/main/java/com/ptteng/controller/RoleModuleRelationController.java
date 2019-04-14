package com.ptteng.controller;

import com.ptteng.model.RoleModuleRelation;
import com.ptteng.service.RoleModuleRelationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName RoleModuleRelationController
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/1/27  19:30
 * @Version 1.0
 **/

@Controller
public class RoleModuleRelationController {
  Logger logger = Logger.getLogger(RoleModuleRelationController.class);
  Map<String ,Object> map = new HashMap<>();
  @Autowired
    RoleModuleRelationService roleModuleRelationService;
  @ResponseBody
  @RequestMapping(value = "/role/module/relation")
  public Map selectByPrimaryKey(Long id){
    logger.info(id);
      try {
        List<RoleModuleRelation> roleModuleRelations = roleModuleRelationService.selectByDynamicCondition(id);
        map.put("roleModuleRelations",roleModuleRelations);
        map.put("code",1);
        map.put("message","成功");
        return map;
      }catch (Exception e){
        map.put("code",1);
        map.put("message","失败");
        return map;
      }

  }



}
