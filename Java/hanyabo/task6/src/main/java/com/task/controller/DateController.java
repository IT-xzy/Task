package com.task.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/time")
public class DateController {

//    private static final Logger logger = LoggerFactory.getLogger(DateController.class);

    @RequestMapping(value="/long")
    public String getLongTime(Map<String,Object> map){
        long timeTemp=System.currentTimeMillis();
        map.put("currentTime", timeTemp);
//        logger.info("getLongTime:"+timeTemp);
        return "disLong";
    }


    @RequestMapping(value="/date")
    public String getDateTime(HttpServletRequest request, Map<String,Object> map){
        String time = request.getParameter("nowTime");
//        logger.info("getDateTime:"+time);
        map.put("changeTime", time);
        return "disDate";
    }
}