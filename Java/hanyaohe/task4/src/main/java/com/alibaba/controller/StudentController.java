package com.alibaba.controller;

import com.alibaba.dao.CountMapper;
import com.alibaba.dao.ExcellentMapper;
import com.alibaba.model.Count;
import com.alibaba.model.Excellent;
import com.alibaba.model.Position;
import com.alibaba.service.ExcellentService;
import com.alibaba.service.Impl.ExcellentServiceImpl;
import com.alibaba.service.Impl.PositionServiceImpl;
import com.alibaba.service.PositionService;
import com.alibaba.service.Impl.CountServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class StudentController {
    private static final Logger log = LoggerFactory.getLogger(StudentController.class);
    @Resource
    private CountServiceImpl countServiceImpl;
    @Resource
    private ExcellentServiceImpl excellentServiceImpl;
    @Resource
    private PositionServiceImpl positionServiceImpl;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String toAdd() {
        return "CustomerForm";
    }

    @RequestMapping(value = "/one",method = RequestMethod.GET)
    public ModelAndView one(){
        ModelAndView mv = new ModelAndView("CustomerForm");
        List<Excellent> excellentList = excellentServiceImpl.getAllExcellent();
        Count count = countServiceImpl.selectById(2);
        mv.addObject("excellentList",excellentList);
        mv.addObject("count",count);
        return mv;
    }

    @RequestMapping(value = "/two", method = RequestMethod.GET)
    public ModelAndView two() {
        ModelAndView mv = new ModelAndView("CustomerDetail");
        List<Position> positionList = positionServiceImpl.getAllPosition();
        mv.addObject("positionList", positionList);
        return mv;
    }
}

