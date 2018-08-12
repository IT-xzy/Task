package task05.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import task05.pojo.CarIntro;
import task05.services.CarIntroServices;

import java.util.List;

@Controller
public class CarIntroController {
    @Autowired
    private CarIntroServices carIntroServices;
    private static final Log log = LogFactory.getLog("carIntroServices.class");

    @RequestMapping(value = "/u/occupation",method = RequestMethod.GET)
    public ModelAndView tiles11(){
        ModelAndView mav = new ModelAndView();

//        存储当前时间
        long date = System.currentTimeMillis();

//        获取数据库信息
        List<CarIntro> queryAllIntro = carIntroServices.queryAllIntro();

//        放入转发参数
        mav.addObject("queryAllIntro",queryAllIntro);
        mav.addObject("date",date);

//        设定跳转页面
        mav.setViewName("page02");


        return mav;

    }




}
