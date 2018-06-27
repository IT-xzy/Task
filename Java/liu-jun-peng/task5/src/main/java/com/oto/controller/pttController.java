package com.oto.controller;

import com.oto.pojo.homepage;
import com.oto.pojo.pro;
import com.oto.pojo.rec;
import com.oto.pojo.user;
import com.oto.service.ProService;
import com.oto.service.homepageService;
import com.oto.service.recService;
import com.oto.service.userService;
import com.oto.serviceImp.ProServiceImp;
import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: 刘军鹏
 * @program: task4
 * @description:
 * @create: 2018/6/4 下午2:14
 */

@Controller
@RequestMapping("")
public class pttController {
    
    @Autowired
    private ProService proService;
    @Autowired
    private homepageService homepageService;
    @Autowired
    private recService recService;

    
    @RequestMapping("/pro")
    public String query(Model model) {
        
        List<pro> pros = proService.query();
        model.addAttribute("proList", pros);
        return "profession";
    }
    
    @RequestMapping("/homepage")
    public String home(Model model) {
        List<homepage> homepages = homepageService.findAll();
        model.addAttribute("homepageList", homepages);
//        request.setAttribute("homepageList",homepages);
        return "main";
    }
    
    @RequestMapping("/u/recom")
    public String recomm(Model model) {
        List<rec> recs = recService.findAll();
        model.addAttribute("recsList", recs);
        return "recommend";
    }
    
    
}
