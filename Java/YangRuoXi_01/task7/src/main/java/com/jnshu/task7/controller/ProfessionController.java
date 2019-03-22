package com.jnshu.task7.controller;

import com.jnshu.task7.beans.Profession;
import com.jnshu.task7.service.impl.ProfessionServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
public class ProfessionController {

    Logger logger = LoggerFactory.getLogger(ProfessionController.class);
    @Autowired
    private ProfessionServiceImpl professionService;



    /**
     *  测试json字符串方法,其中去重DevelopmentDirectior中重复的字段
     * @param model 存在model域中
     * @return 返回json页面;
     */
    @RequestMapping(value = "/u/professionJson",method = RequestMethod.GET)
    public String  showProfessionJson(Model model){
//        List<Profession> professionList = professionService.showProfession();
//        model.addAttribute("professionList",professionList);
//        Set set = new HashSet();
//        for (int i =0 ; i < professionList.size();i++){
//            set.add(professionList.get(i).getDevelopmentDirectior());
//        }
//        model.addAttribute("set",set);
//        logger.info("set" + set);
        return "json";
    }

    /**
     *  查询数据,同时跳转到职业页面;同时去重;
     * @param model 放在model域中
     * @return 返回到profession页面中;
     */
    @RequestMapping(value = "/u/profession",method = RequestMethod.GET)
    public String showAllProfession(Model model, HttpSession session){

        List<Profession> professionList = professionService.showProfession();
        List<Profession> departmentList = professionService.selectProfessionByName();
        model.addAttribute("professionList",professionList);
        model.addAttribute("list",departmentList);
        Object loginName = session.getAttribute("loginName");

        if (loginName != null){
            return "profession";
        } else {
            logger.info("未登录");
            return "redirect:/home";
        }
    }



}
