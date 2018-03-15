package com.hedonglin.controller;

import com.hedonglin.model.Talent;
import com.hedonglin.service.TalentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TalentController {
    private static final Logger log = LoggerFactory.getLogger(JobController.class);
    @Autowired
    private TalentService talentService;

    @RequestMapping(value = "/talent",method = RequestMethod.GET)
    public String talentList(Model model){
        log.info("进入优秀学员页面");
        List<Talent> randomTalent=talentService.randomSelectTalent();
        model.addAttribute("randomTalent",randomTalent);
        return "talent";
    }


}
