package com.controller;

import com.Impl.ProfessionServiceImpl;
import com.POJO.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author: 曹樾
 * @program: task5-module
 * @description: 职业页（前端后端等）控制器
 * @create: 2018/5/7 下午5:32
 */

@Controller
public class ProfessionController {
    @Autowired
    private ProfessionServiceImpl professionServiceImpl;
    @RequestMapping("/profession")
    public String select(Model model) throws Exception {
        List<Profession> Front = professionServiceImpl.findFront();
        List<Profession> After = professionServiceImpl.findAfter();
        List<Profession> OP = professionServiceImpl.findOP();
        List<Profession> PM = professionServiceImpl.findPM();
        
        model.addAttribute("afters",After);
        model.addAttribute("fronts",Front);
        model.addAttribute("ops",OP);
        model.addAttribute("pms",PM);
        return "second";
    }
}

