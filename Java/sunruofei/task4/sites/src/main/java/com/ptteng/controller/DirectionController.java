package com.ptteng.controller;

import com.ptteng.model.Direction;
import com.ptteng.model.Profession;
import com.ptteng.model.Temp;
import com.ptteng.service.DirectionService;
import com.ptteng.service.ProfessionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @ClassName DirectionController
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/2/12  10:17
 * @Version 1.0
 **/
@Controller
public class DirectionController {
    Logger logger = Logger.getLogger(DirectionController.class);

    @Autowired
    DirectionService directionService;

    @Autowired
    ProfessionService professionService;


    @RequestMapping(value = "/profession", method = RequestMethod.GET)
    public String select(Model model, Long directionId) {


        try {
            List<Profession> professions = professionService.selectAll();
            List<Direction> directions = directionService.selectAll();
            List<Profession> profession = professionService.selectByDynamicCondition(directionId);


            List<Temp> tempList = professionService.selectStudentNumber();
            model.addAttribute("temList",tempList);
            model.addAttribute("profession", profession);
            model.addAttribute("professions", professions);
            model.addAttribute("directions", directions);
            model.addAttribute("code", 1);
            return "profession";
        } catch (Exception e) {
            model.addAttribute("code", -1);
            return "profession";
        }
    }

}
