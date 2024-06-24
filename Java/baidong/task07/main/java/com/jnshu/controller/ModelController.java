package com.jnshu.controller;


import com.jnshu.service.ModelService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
public class ModelController {

    private static final Logger logger = Logger.getLogger(ModelController.class);
    //    Map<String, Object> map = new HashMap<>();
    @Autowired
    ModelService modelService;


    @RequestMapping(value = "/a/u/model/list", method = RequestMethod.GET)
    public String selectAll(Model model1) {
        try {
            List<String> modelservice = modelService.selectAll();
//            map.put("code", 0000);
//            map.put("banner", model);
            model1.addAttribute("model", modelservice);
            model1.addAttribute("code", 0000);
            logger.info("输出" + modelservice);

        } catch (Exception e) {
            model1.addAttribute("code", 1000);

        }
        return "home2";
    }

}
