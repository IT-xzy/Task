package cn.summerwaves.controller;

import cn.summerwaves.model.Excellence;
import cn.summerwaves.model.Position;
import cn.summerwaves.service.IExcellenceService;
import cn.summerwaves.service.IPositionService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
public class TilesController {

    private static Logger logger = Logger.getLogger("TilesController.class");
    @Resource
    private IExcellenceService excellenceService;
    @Resource
    private IPositionService positionService;

    @RequestMapping(value = "/tiles")
    public String toTiles() {
        return "myView";
    }


    @RequestMapping(value = "/")
    public String toIndex() {
        return "welcome";
    }

    @RequestMapping(value = "/t10",method = RequestMethod.GET)
    public ModelAndView toT10() {
        ModelAndView mv = new ModelAndView("t10");
        List<Excellence> excellencelist = excellenceService.selectExcellenceByName();
        mv.addObject("excellencelist",excellencelist);
        return mv;
    }
    @RequestMapping(value = "/t11")
    public ModelAndView toT11() {
        ModelAndView mv = new ModelAndView("t11");
        List<Position> positions = positionService.selectPositionByType(1);
        mv.addObject("date",new Date().getTime());
        mv.addObject("positions", positions);
        return mv;
    }
}
