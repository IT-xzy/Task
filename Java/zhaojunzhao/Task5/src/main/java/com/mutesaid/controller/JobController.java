package com.mutesaid.controller;

import com.mutesaid.service.ProfessionService;
import com.mutesaid.utils.AccessService;
import com.mutesaid.utils.ResponseBo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class JobController {
    @Autowired
    private AccessService accessService;

    private Logger logger = LogManager.getLogger(JobController.class);

    @GetMapping("/job")
    public String job(ModelMap model) {
        logger.info("select all job");
        try {
            Long start = System.currentTimeMillis();
            Map<String, List> jobMap = accessService.getProfessionService().getProfesList();
            model.addAttribute("jobMap", jobMap);
            Long end = System.currentTimeMillis();
            logger.info("select all job success");
            logger.info("select all controller runtime {}", end - start);
            return "jobpage";
        } catch (Throwable t) {
            logger.error(t.getMessage());
            logger.error("select job unknown error");
            Map json = ResponseBo.msg("Unknow.Exception");
            model.addAttribute("json", json);
            return "redirect:errorPage";
        }

    }

}
