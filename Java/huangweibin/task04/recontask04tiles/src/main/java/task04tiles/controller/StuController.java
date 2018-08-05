package task04tiles.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import task04tiles.pojo.Students;
import task04tiles.services.StuServices;

import java.util.List;

@Controller
public class StuController {
    @Autowired
    private StuServices stuServices;
    private static final Log log = LogFactory.getLog("stuServices.class");

    @RequestMapping(value = "/students",method = RequestMethod.GET)
    public ModelAndView tiles10(){
        ModelAndView mav = new ModelAndView();
        long date = System.currentTimeMillis();

//        获取累计在线学习总人数
        int querySum = stuServices.querySum();

//        获取找到工作总人数
        int queryWorkSum = stuServices.queryWorkSum();

//        获取四位优秀学员
        List<Students> queryFrontList  =stuServices.queryFrontList();

//        放入转发的参数
        mav.addObject("querySum",querySum);
        mav.addObject("queryWorkSum",queryWorkSum);
        mav.addObject("queryFrontList",queryFrontList);
        mav.addObject("date",date);
        mav.setViewName("page01");

        return  mav;
    }



}
