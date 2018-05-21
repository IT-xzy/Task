package com.hedonglin.controller;

import com.hedonglin.model.Talent;
import com.hedonglin.service.TalentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TalentController {

    @Autowired
    private TalentService talentService;

    @RequestMapping(value = "/talent",method = RequestMethod.GET)
    public String talentList(Model model){
        List<Talent> randomTalent=talentService.randomSelectTalent();
        model.addAttribute("randomTalent",randomTalent);

        Long time = System.currentTimeMillis();
        model.addAttribute("time",time);
        return "talents";
    }


}
