package com.ev.controller;

import com.ev.entity.Occupation;
import com.ev.service.OccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/u")
public class PrivatePagesController {

    @Autowired
    OccupationService occupationService;

    @RequestMapping(value = "/occupation", method = RequestMethod.GET)
    public String getOccupation(Model model) throws Exception{
        List<Occupation> occupations=occupationService.selectOccupation();
        model.addAttribute("occupations", occupations);
        return "occupation";

    }

}
