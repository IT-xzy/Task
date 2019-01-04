package com.ptteng.controller;

import com.ptteng.entity.Profession;
import com.ptteng.service.ProfessionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//返回jsp

@Controller
public class TProfessionController {

    static Logger logger=Logger.getLogger(TProfessionController.class);

    @Autowired
    private ProfessionService professionService;

//    先查id序列，再根据id在缓存中查找
    @RequestMapping(value = "t/profession/list", method = RequestMethod.GET)
    public String getTlProfession(Integer page, Integer size, Model model) {
        List<Profession> professionList = professionService.findProfession(page, size);
        model.addAttribute("profession",professionList);
        model.addAttribute("code",0);
        return "profession";
    }

    @RequestMapping(value = "/profession", method = RequestMethod.POST)
    public String insertPro(Profession profession, Model model) {
        logger.info("插入数据入参"+profession);
        try {
            Long id = professionService.insertPro(profession);
            logger.info("插入数据返回的主键"+id);
            model.addAttribute("code",0);
        } catch (Exception e) {
            model.addAttribute("code", -1);
        }
        return "profession";
    }

    @RequestMapping(value = "/profession", method = RequestMethod.PUT)
    public String updatePro(Profession profession, Model model) {
        logger.info("修改数据入参"+profession);
        try {
            Boolean flag = professionService.updatePro(profession);
            logger.info("修改数据是否成功"+flag);
            model.addAttribute("code",0);
        } catch (Exception e) {
            model.addAttribute("code", -1);
        }
        return "profession";
    }


    @RequestMapping(value = "/profession", method = RequestMethod.DELETE)
    public String deletePro(Long id, Model model) {
        try {
            Boolean flag = professionService.deletePro(id);
            logger.info("删除数据是否成功"+flag);
            model.addAttribute("code",0);
        } catch (Exception e) {
            model.addAttribute("code", -1);
        }
        return "profession";
    }




}
