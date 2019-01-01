package com.mutesaid.controller;

import com.mutesaid.pojo.Element;
import com.mutesaid.pojo.Expert;
import com.mutesaid.pojo.PerformanceTree;
import com.mutesaid.pojo.Template;
import com.mutesaid.service.ExpertService;
import com.mutesaid.utils.AccessService;
import com.mutesaid.utils.ResponseBo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private AccessService accessService;

    private final Logger logger = LogManager.getLogger(HomeController.class);

    @GetMapping("/home")
    @SuppressWarnings("unchecked")
    public String home(ModelMap model) {
        logger.info("select expert");
        try {
            List<Expert> expertList = accessService.getExpertService().getAllExpert();
            model.addAttribute("expertList", expertList);
            logger.info("select expert success");
            return "homepage";
        } catch (Throwable t) {
            logger.error(t.getMessage());
            logger.error("select expert unknown error");
            Map json = ResponseBo.msg("Unknow.Exception");
            model.addAttribute("json", json);
            return "redirect:errorPage";
        }
    }
}
