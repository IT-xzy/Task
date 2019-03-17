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


    @RequestMapping(value = "/u/profession", method = RequestMethod.GET)
    public String selectPageData(Model model) {
        try {
//            查找所有职业
            List<Profession> professions = professionService.selectAll();
            logger.info("所有职业==================" + professions);
//            查找所有方向
            List<Direction> directions = directionService.selectAll();
            logger.info("所有方向==================" + directions);
//            查找当前每个职业有多少人在学,得到职业与人数对应的一个集合
            List<Temp> tempList = professionService.selectStudentNumber();
            logger.info("职业与人数对应的一个集合=======================" + tempList);

            model.addAttribute("temList", tempList);
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
