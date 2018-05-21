package com.jnshu.controller;
import com.jnshu.model.Count;
import com.jnshu.model.Position;
import com.jnshu.service.Impl.CountServiceImpl;
import com.jnshu.service.Impl.ExcellentServiceImpl;
import com.jnshu.service.Impl.PositionServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.jnshu.model.Excellent;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Controller
public class StudentController {
    @Resource
    private ExcellentServiceImpl excellentServiceImpl;
    @Resource
    private PositionServiceImpl positionService;

    @Resource
    private CountServiceImpl countServiceImpl;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String inputCustomer() {
        return "CustomerDetail";
    }

    @RequestMapping(value = "/t10", method = RequestMethod.GET)
    public ModelAndView to10() throws IOException {
        ModelAndView mv = new ModelAndView("CustomerForm");
        List<Excellent> excellencelist = excellentServiceImpl.getAllExcellent();
        Count count = countServiceImpl.selectByid(1);
        mv.addObject("count", count);
        mv.addObject("excellencelist", excellencelist);
        return mv;
    }

    @RequestMapping(value = "/t11", method = RequestMethod.GET)
    public ModelAndView toTo11() throws IOException {
        ModelAndView mv = new ModelAndView("CustomerDetail");
        List<Position> list = positionService.getAllPosition();
        mv.addObject("list", list);
        return mv;
    }
}
