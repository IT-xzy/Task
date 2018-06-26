package com.task.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/time")
public class DateController {

    @RequestMapping(value="/long")
    public String getTest(Map<String,Object> map){
        long timeTemp=System.currentTimeMillis()/1000;
        map.put("currentTime", timeTemp);
        return "disLong";
    }


    @RequestMapping(value="/date")
    public String getTest2(HttpServletRequest request, Map<String,Object> map){
        String time = request.getParameter("nowTime");
        System.out.println(time);
        map.put("changeTime", time);
        return "disDate";
    }
}