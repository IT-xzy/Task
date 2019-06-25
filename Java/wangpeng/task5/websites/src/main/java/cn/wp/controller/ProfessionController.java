package cn.wp.controller;

import cn.wp.model.Profession;
import cn.wp.service.ProfessionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @ClassName:
 * @Description:
 * @Author: 老王
 * @Date: 2019/5/19 17:10
 * @Version: 1.0
 */
@Controller
public class ProfessionController {
    Logger logger = Logger.getLogger(ProfessionController.class);

    @Autowired
    ProfessionService professionService;

    @RequestMapping(value = "/u/profession/list", method = RequestMethod.GET)

    public String selectPageData(Model model) {
        try {
//            查找所有职业
            List<Profession> profession = professionService.selectAll();
            logger.info("所有职业==================" + profession);
            model.addAttribute("profession", profession);
            model.addAttribute("code", 1);
            return "profession";
        } catch (Exception e) {
            model.addAttribute("code", -1);
            return "profession";
        }
    }
}
