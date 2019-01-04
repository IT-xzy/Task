package jnshu.controller;

import com.alibaba.fastjson.JSON;
import jnshu.model.ExcellentStudent;
import jnshu.model.Profession;
import jnshu.service.ProfessionService;
import jnshu.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ControllerOne {
    private static Logger logger = Logger.getLogger (ControllerOne.class);//引入日志配置
    @Resource
    StudentService studentService;
    @Resource
    ProfessionService professionService;

    long timeStamp=System.currentTimeMillis ();

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public ModelAndView home(){
        List<ExcellentStudent> rs=studentService.selectStudent ();
        logger.info (JSON.toJSONString (rs));

        ModelAndView mv = new ModelAndView ();
        mv.setViewName ("home");
        mv.addObject ("students", rs);
        return mv;
    }

    @RequestMapping(value = "/home11",method = RequestMethod.GET)
    public ModelAndView home11(){
        List<Profession> rs=professionService.selectProfession ();
        logger.info (JSON.toJSONString (rs));
        ModelAndView mv = new ModelAndView ();
        mv.setViewName ("home11");
        mv.addObject ("professions", rs);
        return mv;
    }
}
